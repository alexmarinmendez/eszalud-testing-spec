# DECISIONES DE NEGOCIO — EsZalud

Documento de decisiones de diseño de la capa Model, conforme a la sección 8 de
`EFP_Pruebas_Unitarias_EsZalud.md` y al criterio de aceptación de la sección 12.

| Dato | Detalle |
|---|---|
| Proyecto | EsZalud – Sistema de gestión de consultas médicas |
| Componente | Capa de modelos (`pe.saludpublica.model`) |
| Enfoque | Test Driven Development (RED → GREEN → REFACTOR) |
| Fecha | 17 de noviembre de 2026 |

---

## 1. Propósito

La especificación formal deja nueve decisiones abiertas. Este documento las
resuelve **antes** de implementarlas, indica la evidencia que sostiene cada una y
señala qué NO se valida y por qué.

Criterio rector: no inventar restricciones. Solo se exige aquello que el dominio
necesita para funcionar o que la aplicación de referencia ya exige.

### Fuentes de evidencia utilizadas

| Fuente | Qué aporta |
|---|---|
| `database/salud_publica.*.json` | Datos reales exportados de MongoDB: 6 pacientes, 5 doctores, 4 especialidades y 3 citas |
| `reference-app/salud-publica-all.jar` | Mensajes de validación reales de la aplicación (`pe/saludpublica/App.class`) |
| `EFP_Pruebas_Unitarias_EsZalud.md` | Catálogo obligatorio y recomendado, y las nueve decisiones pendientes |

Mensajes recuperados del binario de la aplicación:

```text
"Campo obligatorio"
"Completa el campo: "
"Verifica que los IDs de paciente, doctor y especialidad existan."
"La especialidad indicada no existe. Registra primero la especialidad."
"El doctor ya tiene una cita en ese horario."
"No se pueden agendar citas en fechas pasadas."
"La fecha debe tener el formato yyyy-MM-dd HH:mm."
"Estado válido: PROGRAMADA, ATENDIDA o CANCELADA."
```

---

## 2. Resumen de decisiones

| # | Elemento | Decisión |
|---|---|---|
| D-01 | Documento (paciente y doctor) | Obligatorio. No nulo, no vacío, no solo espacios. Sin regla de longitud ni de caracteres |
| D-02 | Teléfono | Opcional. Sin validación de formato |
| D-03 | Correo | Opcional. Sin validación de formato |
| D-04 | Colegiatura | Obligatoria. Sin validación de formato |
| D-05 | Descripción de especialidad | Opcional |
| D-06 | Motivo de la cita | Obligatorio. No nulo, no vacío, no solo espacios. Sin longitud máxima |
| D-07 | Fecha de la cita | `String` con formato `yyyy-MM-dd HH:mm`. Se rechazan formatos inválidos y fechas inexistentes. **No** se rechazan fechas pasadas en el modelo |
| D-08 | Estado de la cita | `null` → `EstadoCita.PROGRAMADA`. Un estado recibido se conserva |
| D-09 | Identificadores | `String`. Se validan como obligatorios; sin validación de longitud ni de hexadecimalidad |
| D-10 | Especialidad del doctor | Obligatoria |
| D-11 | Mutabilidad e identidad | Modelos inmutables, sin setters, sin atributo `id`, sin `equals()`/`hashCode()` |
| D-12 | Mockito | Configurado en Gradle, no utilizado: no hay dependencias que aislar |

---

## 3. Decisiones detalladas

### D-01 · Documento

**Decisión.** Obligatorio. Se rechaza `null`, la cadena vacía y la compuesta solo
por espacios. No se valida longitud ni conjunto de caracteres.

**Evidencia.** Los 6 pacientes y los 5 doctores exportados tienen documento. La
aplicación usa una validación genérica de campo obligatorio (`"Completa el campo: "`).
La EFP prohíbe expresamente inventar longitudes: *"No se deben inventar
restricciones, como una longitud específica de documento o teléfono, sin que
exista una regla de negocio que las justifique"*.

**Por qué no se exigen 8 dígitos.** Todos los documentos de los datos de ejemplo
tienen 8 caracteres, pero eso es una coincidencia del dataset, no una regla
declarada. Exigirlo rompería documentos válidos de otro tipo (carné de
extranjería, pasaporte).

**Pruebas.** PAC-002, PAC-003, PAC-004, PAC-006, PAC-007, DOC-002, DOC-007.

---

### D-02 · Teléfono

**Decisión.** Opcional. Sin validación de formato.

**Evidencia.** El catálogo obligatorio no incluye ninguna prueba de teléfono. La
prueba recomendada PAC-011 es explícitamente condicional (*"si se establece una
regla de formato"*). La aplicación no valida el formato del teléfono: solo exige
que el campo no esté vacío en el formulario.

**Consecuencia.** `new Paciente(..., telefono = null, ...)` es válido.

---

### D-03 · Correo

**Decisión.** Opcional. Sin validación de formato.

**Evidencia.** PAC-010 y PAC-012 son condicionales. Los 6 pacientes tienen correo,
pero el catálogo obligatorio no lo exige y la aplicación no comprueba el formato.

**Por qué no se valida con expresión regular.** Una regla de correo es una
restricción de formato que la EFP no define y que la aplicación de referencia no
aplica. Añadirla obligaría a fijar un patrón arbitrario.

**Prueba.** PAC-012 → `shouldAcceptPatientWithoutEmail`.

---

### D-04 · Colegiatura

**Decisión.** Obligatoria. Se rechaza `null`, vacío y solo espacios. Sin
validación de formato.

**Evidencia.** Los 5 doctores registrados tienen colegiatura con el patrón
`CMP NNNNNN`. La EFP exige la validación de obligatoriedad (DOC-005) y de valor
vacío (DOC-009), pero deja el formato como condicional (DOC-010).

**Por qué no se exige el patrón `CMP`.** El prefijo aparece en el 100 % de los
datos, pero ninguna fuente lo declara como regla. Un colegiado de otra profesión
o de otra sede podría no usarlo.

**Pruebas.** DOC-005, DOC-009.

---

### D-05 · Descripción de especialidad

**Decisión.** Opcional.

**Evidencia.** Las 4 especialidades tienen descripción, pero es información
complementaria: la especialidad se identifica por su nombre. ESP-006 y ESP-007
dejan la decisión abierta (*"Aceptar o rechazar según la obligatoriedad definida"*
y *"Aceptar si la descripción es opcional"*).

**Pruebas.** ESP-006 → `shouldAcceptSpecialtyWithBlankDescription`;
ESP-007 → `shouldAcceptSpecialtyWithoutDescription`.

---

### D-06 · Motivo de la cita

**Decisión.** Obligatorio. Se rechaza `null`, vacío y solo espacios. Sin longitud
máxima.

**Evidencia.** Las 3 citas registradas tienen motivo. El formulario de la
aplicación aplica la validación genérica de campo obligatorio a todos sus campos.
CIT-009 y CIT-016 son condicionales, por lo que la obligatoriedad debe decidirse
aquí.

**Por qué no hay longitud máxima.** No existe regla declarada. El motivo más largo
de los datos de ejemplo tiene 46 caracteres; fijar un límite sería inventarlo.

**Pruebas.** CIT-009, CIT-016 y una prueba adicional para el valor `null`.

---

### D-07 · Fecha y hora de la cita

**Decisión.** El atributo `fechaHora` es `String` con formato exacto
`yyyy-MM-dd HH:mm`. Se rechazan los formatos inválidos y las fechas que no existen
en el calendario. **No** se rechazan las fechas pasadas dentro del modelo.

**Evidencia del tipo `String`.** Los datos reales de MongoDB almacenan el valor
como texto:

```json
"fechaHora": "2026-11-23 16:30"
```

La aplicación lo convierte a `LocalDateTime` solo para comparar, con
`DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")`, y devuelve el mensaje
`"La fecha debe tener el formato yyyy-MM-dd HH:mm."`.

**Por qué es imprescindible que sea `String`.** Si el atributo fuera
`LocalDateTime`, la prueba CIT-010 (*"crear cita con fecha y hora inválidas"*)
sería **imposible de escribir**: el compilador no permite construir una fecha
inválida. El tipo `String` es lo que hace testeable el requisito.

**Implementación.**

```java
DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm")
        .withResolverStyle(ResolverStyle.STRICT)
```

- `uuuu` (año cronológico) en lugar de `yyyy` (año de era), porque en modo
  `STRICT` el año de era exige una era explícita.
- `ResolverStyle.STRICT` impide que una fecha inexistente se "corrija" en
  silencio: con el modo `SMART` por defecto, `2026-02-30` se convierte en
  `2026-02-28` y la validación pasaría por alto.

**Por qué no se validan las fechas pasadas en el modelo.** La aplicación sí las
rechaza (`"No se pueden agendar citas en fechas pasadas."`), pero lo hace en el
momento de agendar, no al construir el objeto. Llevar esa regla al constructor
obligaría al modelo a depender del reloj del sistema: cualquier prueba con una
fecha fija dejaría de pasar al día siguiente, incumpliendo el requisito de que
*cada prueba produzca el mismo resultado independientemente de cuándo se ejecute*
(EFP §4 y §11). CIT-011 es condicional y se resuelve, por tanto, en la capa de
servicio.

**Pruebas.** CIT-005, CIT-010, más una prueba de fecha inexistente
(`2026-02-30 10:00`) que verifica el modo `STRICT`.

---

### D-08 · Estado de la cita

**Decisión.** Cuando se recibe `null`, se asigna `EstadoCita.PROGRAMADA`. Cuando
se recibe un estado válido, se conserva.

**Evidencia.** CIT-006 deja la decisión abierta y pide documentarla. La aplicación
utiliza `PROGRAMADA` como estado inicial: las dos citas futuras de los datos
exportados están en `PROGRAMADA` y solo la cita pasada figura como `ATENDIDA`.

Además, el profesor ya resolvió este mismo escenario dos veces en especificaciones
anteriores:

| Documento | Prueba | Regla |
|---|---|---|
| PROJ-MGMT | PRJ-006 | `estado` nulo → `ProjectStatus.PROPOSED` |
| CONS-MGMT | CNS-011 | `disponibilidad` nula → `AvailabilityStatus.AVAILABLE` |

Es un patrón documentado del dominio, no una analogía: **cuando un enum de estado
llega nulo, se aplica el valor inicial en lugar de rechazarlo.**

**Por qué no se rechaza.** Rechazar `null` obligaría a todo cliente del modelo a
conocer el estado inicial, duplicando la regla. Asignarlo en el constructor deja
la decisión en un solo lugar.

**Pruebas.** CIT-006 → `shouldDefaultStatusToScheduledWhenStatusIsNull`;
CIT-007, CIT-012, CIT-013 y CIT-014 → `shouldKeepReceivedStatus`, parametrizada
sobre los tres valores del enum.

---

### D-09 · Identificadores de referencia

**Decisión.** `String`. Se validan como obligatorios (no nulos, no vacíos, no solo
espacios). No se valida longitud ni que sean hexadecimales.

**Evidencia.** MongoDB almacena los identificadores como `ObjectId`, que en los
datos exportados aparece serializado como cadena hexadecimal de 24 caracteres:

```json
"patientId": "6af71e0b501cca046a166049"
```

**Por qué no se usa `ObjectId`.** La EFP declara fuera de alcance toda dependencia
de MongoDB (§2). Usar `org.bson.types.ObjectId` en el modelo acoplaría el dominio
a la base de datos y rompería la independencia exigida en §12.

**Por qué no se valida el formato.** Comprobar 24 caracteres hexadecimales es una
restricción del motor de persistencia, no del dominio. Un modelo que la imponga
deja de poder probarse sin conocer MongoDB.

**Pruebas.** CIT-002, CIT-003, CIT-004.

---

### D-10 · Especialidad del doctor

**Decisión.** Obligatoria.

**Evidencia.** Los 5 doctores registrados tienen `specialtyId`. La especialidad
determina qué citas puede atender un doctor y la aplicación rechaza agendar
cuando la referencia no resuelve (`"La especialidad indicada no existe. Registra
primero la especialidad."`). Un doctor sin especialidad no puede participar del
flujo principal del sistema.

**Nota.** DOC-011 y DOC-012 son condicionales. Se establece la obligatoriedad y se
implementan ambas pruebas.

**Pruebas.** DOC-011 → `shouldRejectDoctorWithBlankSpecialty`;
DOC-012 → `shouldRejectDoctorWithoutSpecialty`.

---

### D-11 · Mutabilidad e identidad

**Decisión.** Los cuatro modelos son inmutables: atributos `private final`, sin
setters. No incluyen atributo `id`. No implementan `equals()` ni `hashCode()`.

**Evidencia.** La EFP incluye en el alcance *"el comportamiento de getters y
setters, si existen"*: no existen, por lo que GEN-002 no aplica. La sección 12
exige únicamente que los atributos conserven los valores recibidos.

**Por qué no hay `id`.** La identidad de persistencia es responsabilidad de
MongoDB (`_id`), no del dominio. El proyecto TDD de referencia del curso
(`proj-mgmt-tdd_manor`) aplica el mismo criterio: frente a su versión tradicional,
elimina el atributo `id` del modelo.

**Por qué no hay `equals()`/`hashCode()`.** El contrato de igualdad del dominio no
está definido: dos pacientes con los mismos datos podrían ser personas distintas.
GEN-004 es condicional (*"si están implementados"*).

---

### D-12 · Mockito

**Decisión.** La dependencia queda configurada en `build.gradle` (COM-001) pero no
se utiliza en ninguna prueba.

**Evidencia.** La sección 12 de la EFP condiciona su uso: *"Mockito se utilice
cuando exista una dependencia real que deba aislarse"*. Los cuatro modelos son
POJO sin colaboradores, sin repositorios y sin servicios inyectados: no hay nada
que sustituir por un doble de prueba. Introducir un mock artificial sería ruido.

---

## 4. Lo que el modelo NO valida, y por qué

| Escenario | ID | Motivo |
|---|---|---|
| Formato y longitud del documento | — | Restricción no declarada (D-01) |
| Formato y longitud del teléfono | PAC-011 | Condicional; la aplicación no lo valida (D-02) |
| Formato del correo | PAC-010 | Condicional; requiere un patrón arbitrario (D-03) |
| Formato de la colegiatura | DOC-010 | Condicional; el prefijo `CMP` no es una regla declarada (D-04) |
| Longitud máxima del motivo | — | No existe regla (D-06) |
| Fechas pasadas | CIT-011 | Convertiría la prueba en dependiente del reloj (D-07) |
| Estado no reconocido | CIT-015 | Imposible con un `enum`: el compilador lo impide. La validación ocurre al deserializar, fuera del modelo |
| Setters | GEN-002 | El modelo es inmutable, no hay setters (D-11) |
| `equals()` / `hashCode()` | GEN-004 | El contrato de igualdad no está definido (D-11) |

Sobre **CIT-015**: al representar el estado con `EstadoCita`, un valor no
reconocido no puede llegar al constructor. La aplicación lo valida en la interfaz
con el mensaje `"Estado válido: PROGRAMADA, ATENDIDA o CANCELADA."` antes de
construir el objeto. Una prueba de estado inválido exigiría recibir el estado como
`String`, lo que contradice la recomendación explícita de la EFP de usar un
`enum` (§3.4).

---

## 5. Trazabilidad de las pruebas obligatorias

| ID | Clase de prueba | Método |
|---|---|---|
| ESP-001 | `EspecialidadTest` | `shouldCreateSpecialtyWithValidData` |
| ESP-002 | `EspecialidadTest` | `shouldRejectSpecialtyWithoutName` |
| ESP-003 | `EspecialidadTest` | `shouldExposeAllAttributesAfterCreation` |
| PAC-001 | `PacienteTest` | `shouldCreatePatientWithValidData` |
| PAC-002 | `PacienteTest` | `shouldRejectPatientWithoutDocument` |
| PAC-003 | `PacienteTest` | `shouldRejectPatientWithoutFirstNames` |
| PAC-004 | `PacienteTest` | `shouldRejectPatientWithoutLastNames` |
| PAC-005 | `PacienteTest` | `shouldExposeAllAttributesAfterCreation` |
| DOC-001 | `DoctorTest` | `shouldCreateDoctorWithValidData` |
| DOC-002 | `DoctorTest` | `shouldRejectDoctorWithoutDocument` |
| DOC-003 | `DoctorTest` | `shouldRejectDoctorWithoutFirstNames` |
| DOC-004 | `DoctorTest` | `shouldRejectDoctorWithoutLastNames` |
| DOC-005 | `DoctorTest` | `shouldRejectDoctorWithoutMedicalLicense` |
| DOC-006 | `DoctorTest` | `shouldExposeAllAttributesAfterCreation` |
| CIT-001 | `CitaMedicaTest` | `shouldCreateAppointmentWithValidData` |
| CIT-002 | `CitaMedicaTest` | `shouldRejectAppointmentWithoutPatientReference` |
| CIT-003 | `CitaMedicaTest` | `shouldRejectAppointmentWithoutDoctorReference` |
| CIT-004 | `CitaMedicaTest` | `shouldRejectAppointmentWithoutSpecialtyReference` |
| CIT-005 | `CitaMedicaTest` | `shouldRejectAppointmentWithoutDate` |
| CIT-006 | `CitaMedicaTest` | `shouldDefaultStatusToScheduledWhenStatusIsNull` |
| CIT-007 | `CitaMedicaTest` | `shouldKeepReceivedStatus` |
| CIT-008 | `CitaMedicaTest` | `shouldExposeAllAttributesAfterCreation` |

**22 de 22 pruebas obligatorias implementadas y en verde.**

### Pruebas recomendadas implementadas (20)

| Modelo | Pruebas |
|---|---|
| Especialidad | ESP-004, ESP-005, ESP-006, ESP-007 |
| Paciente | PAC-006, PAC-007, PAC-008, PAC-009, PAC-012 |
| Doctor | DOC-007, DOC-008, DOC-009, DOC-011, DOC-012 |
| Cita médica | CIT-009, CIT-010, CIT-012, CIT-013, CIT-014, CIT-016 |

Además, GEN-001 (los getters devuelven todos los atributos) queda cubierto por las
pruebas de atributos de los cuatro modelos.

---

## 6. Ejecución

```powershell
.\gradlew.bat test
```

Resultado esperado: **44 pruebas ejecutadas, 0 fallos.**

| Clase | Pruebas |
|---|---|
| `EspecialidadTest` | 7 |
| `PacienteTest` | 10 |
| `DoctorTest` | 12 |
| `CitaMedicaTest` | 15 (12 métodos, uno parametrizado sobre los 3 estados) |

El reporte HTML se genera en `build/reports/tests/test/index.html`.
