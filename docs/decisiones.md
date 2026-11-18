# Decisiones de diseño y de pruebas del modelo (EsZalud)

**Alumno:** Giron Zarate Rodrigo
**Rama:** tdd/GironZarate_Rodrigo

## 1. Cómo trabajé

Desarrollé la capa Model de EsZalud aplicando TDD. Para cada caso obligatorio de la EFP seguí el ciclo completo: primero escribí el test y comprobé que fallara por la razón correcta (RED), hice un commit `test(...)`, luego escribí el código mínimo para que pasara (GREEN) y hice un commit `feat(...)`. Cuando vi código repetido, hice un REFACTOR y corrí toda la suite antes de cada commit `refactor(...)`.

Los mensajes de commit están en inglés con el formato `type(scope): description`, los `@DisplayName` de los tests están en español y los nombres de los métodos siguen el formato `shouldXxx`. Las clases de producción están en `src/main/java/pe/saludpublica/model` y los tests en `src/test/java/pe/saludpublica/model`.

Entregué 22 tests en total: Paciente 5, Doctor 6, Especialidad 3 y CitaMedica 8. Cubren todos los casos obligatorios de la EFP.

Antes de empezar los ciclos dejé registrada la configuración del proyecto en commits `build(...)`: el `.gitignore`, Gradle con JUnit 6 y Mockito, y el wrapper de Gradle.

## 2. Decisiones generales

- **Qué valido:** en los campos obligatorios rechazo el valor `null` lanzando `IllegalArgumentException` con un mensaje en español. No validé cadenas vacías, espacios en blanco ni formatos (por ejemplo, de teléfono o correo), porque la EFP no lo pide como obligatorio y no quise inventar reglas de negocio.
- **Campos opcionales:** no los validé. Son `telefono` y `correo` (Paciente), `especialidad` (Doctor), `descripcion` (Especialidad) y `motivo` (CitaMedica).
- **Inmutabilidad:** todos los atributos son `private final`. Cada clase tiene solo constructor y getters, sin setters, para que un objeto válido no pueda quedar inválido después.
- **Casos de verificación de atributos (PAC-005, DOC-006, ESP-003 y CIT-008):** los implementé como tests propios, con datos distintos a los del test de creación válida, para comprobar que cada getter devuelve el dato recibido. Como el código ya cumplía el comportamiento desde el primer ciclo, estos tests pasaron directamente, así que tienen un commit `test` y no tienen commit `feat`.
- **Por qué no usé Mockito ni MongoDB:** la capa Model que desarrollé no depende de la base de datos ni de otras clases, porque las referencias entre modelos son `String`. Por eso no había nada que simular con Mockito y mis tests no necesitan MongoDB ni JavaFX. Dejé Mockito configurado en `build.gradle` por si se necesitara más adelante.

## 3. Decisiones por modelo

### Paciente
- Campos: documento, nombres, apellidos, telefono y correo (todos `String`).
- Obligatorios: documento, nombres y apellidos. Mensajes: "El documento es obligatorio", "Los nombres son obligatorios" y "Los apellidos son obligatorios".
- Opcionales: telefono y correo.
- Casos con ciclo completo: PAC-001 a PAC-004. PAC-005 como test directo.

### Doctor
- Campos: documento, nombres, apellidos, colegiatura y especialidad (todos `String`).
- Guardé la especialidad del doctor como `String` (un identificador o referencia) y no como objeto `Especialidad`, para que los modelos no dependan entre sí y las pruebas sigan siendo unitarias.
- Obligatorios: documento, nombres, apellidos y colegiatura. Mensajes equivalentes a los de Paciente, y "La colegiatura es obligatoria". La especialidad no se valida en el constructor.
- Casos con ciclo completo: DOC-001 a DOC-005. DOC-006 como test directo.

### Especialidad
- Campos: nombre y descripcion (`String`).
- Obligatorio: nombre ("El nombre es obligatorio"). La descripción es opcional.
- Casos con ciclo completo: ESP-001 y ESP-002. ESP-003 como test directo.

### CitaMedica
- Campos: paciente, doctor y especialidad (`String`), fechaHora (`LocalDateTime`), motivo (`String`) y estado (`EstadoCita`).
- **Tipo de los identificadores:** paciente, doctor y especialidad son `String` (identificador o referencia), y no objetos `Paciente`, `Doctor` o `Especialidad`, por el mismo motivo que en Doctor: evitar dependencias entre modelos.
- **Tipo de la fecha:** usé `LocalDateTime` porque la cita necesita fecha y hora y no requiere zona horaria.
- **Estado:** creé el enum `EstadoCita` con los valores PROGRAMADA, ATENDIDA y CANCELADA, como recomienda la EFP, en lugar de usar cadenas de texto.
- Obligatorios: paciente, doctor, especialidad, fechaHora y estado. El motivo es opcional.
- **CIT-006 (estado `null`):** la EFP no dice qué hacer, así que tuve que decidir. Elegí **rechazarlo** con `IllegalArgumentException` ("El estado es obligatorio"). Asignar PROGRAMADA automáticamente habría sido inventar una regla de negocio que nadie pidió, y además podría ocultar un error de quien crea la cita.
- **CIT-007 (estado válido se conserva):** este test pasó directamente, porque el código ya lo cumplía después de CIT-006. Por eso tiene un commit `test` y no tiene commit `feat`.
- Casos con ciclo completo: CIT-001 a CIT-006. CIT-007 y CIT-008 como tests directos.

## 4. Refactorizaciones

- **Paciente, Doctor y CitaMedica:** extraje un método privado `requerido(...)` para eliminar los `if (campo == null)` repetidos. En CitaMedica lo hice genérico para poder validar también `LocalDateTime` y `EstadoCita`. Después de cada refactor corrí toda la suite y siguió en verde.
- **Especialidad:** no la refactoricé porque solo tiene una validación y no hay código repetido que eliminar.

## 5. Decisiones de negocio pendientes (sección 8 de la EFP)

| Elemento | Decisión |
|---|---|
| Documento | No se valida longitud ni caracteres. Solo se exige que no sea `null`, porque no existe una regla de negocio que fije un formato. |
| Teléfono | Opcional. No se valida formato ni longitud. |
| Correo | Opcional. No se valida formato. |
| Colegiatura | Obligatoria (no `null`). No se valida formato ni longitud. |
| Descripción de especialidad | Opcional (puede ser `null`). |
| Motivo de la cita | Opcional. No se valida longitud máxima. |
| Fecha de cita | Obligatoria (no `null`). No se restringe a fechas futuras: se permiten fechas pasadas porque el modelo no define esa regla. |
| Estado de la cita | Obligatorio. Si es `null` se rechaza con `IllegalArgumentException`; no se asigna PROGRAMADA automáticamente. |
| Identificadores | Paciente, doctor y especialidad se representan como `String`. |

Como pide la EFP, no agregué restricciones (longitudes, formatos, fechas futuras) sin una regla de negocio que las justifique.

## 6. Observaciones sobre mi proceso

- En el primer ciclo de cada modelo, el commit RED incluyó la clase como esqueleto mínimo (por ejemplo, getters que devuelven `null`) para que el test compilara y fallara por la aserción y no por un error de compilación. La implementación real quedó en el commit GREEN.
- En la clase `CitaMedica`, el commit RED de CIT-001 también incluyó el enum `EstadoCita`, porque el constructor lo necesita para compilar.
- Al crear el `.gitignore`, el primer commit quedó vacío por error. Lo corregí con un commit posterior que agrega las reglas. Por eso el historial muestra dos commits `build(git)`.
- No implementé las pruebas recomendadas de la sección 7 de la EFP (cadenas vacías, formatos y fechas pasadas), porque dependen de reglas de negocio que no están definidas.