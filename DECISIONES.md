# Decisiones de negocio – Capa Model EsZalud

Este documento registra las decisiones adoptadas para la implementación de la capa Model,
de acuerdo con la sección 8 de la Especificación Formal de Pruebas Unitarias (EFP).

## 1. Identificadores

- Las referencias a paciente, doctor y especialidad se representan mediante `String`.
- En `CitaMedica`, los campos `paciente`, `doctor` y `especialidad` son obligatorios
  y no pueden ser `null`.
- Estos identificadores se validan únicamente contra `null`, porque representan
  referencias a otros registros y la EFP no exige validar su contenido.

## 2. Campos obligatorios

Se rechaza la creación del objeto con `IllegalArgumentException` cuando un campo
obligatorio de texto es `null`, una cadena vacía (`""`) o una cadena compuesta
únicamente por espacios.

| Modelo | Campos obligatorios |
|---|---|
| `Paciente` | `documento`, `nombres`, `apellidos` |
| `Doctor` | `documento`, `nombres`, `apellidos`, `colegiatura` |
| `Especialidad` | `nombre` |
| `CitaMedica` | `paciente`, `doctor`, `especialidad`, `fechaHora` |

## 3. Campos opcionales

Los siguientes campos son opcionales y aceptan `null` y cadena vacía:

| Modelo | Campos opcionales |
|---|---|
| `Paciente` | `telefono`, `correo` |
| `Doctor` | `especialidad` |
| `Especialidad` | `descripcion` |
| `CitaMedica` | `motivo` |

No se establecen longitudes máximas ni formatos específicos para los campos de texto,
porque la EFP no define una regla de negocio que los justifique.

## 4. Fecha y hora de la cita

- `fechaHora` se representa como `String` con el formato `yyyy-MM-dd HH:mm`,
  igual que los datos almacenados por la aplicación de referencia.
- El campo es obligatorio: se rechaza `null` o una cadena vacía.
- Se rechaza con `IllegalArgumentException` cualquier valor que no cumpla el formato.
- Se rechazan las fechas anteriores a la fecha actual, tal como hace la aplicación
  de referencia: no se pueden agendar citas en fechas pasadas.

## 5. Estados de la cita

- Los estados válidos son `PROGRAMADA`, `ATENDIDA` y `CANCELADA`, representados
  mediante el enum `EstadoCita`.
- Si al crear una cita el estado recibido es `null`, se asigna automáticamente
  el estado `PROGRAMADA`.
- No se definen transiciones entre estados en esta versión.

## 6. Fuera de alcance

- No se implementan reglas que requieran consultar otros registros, como verificar
  que el paciente, el doctor o la especialidad existan, ni validar el cruce de
  horarios de un doctor. La EFP las excluye de la capa Model.
- No se implementa persistencia, CRUD, integración con MongoDB ni componentes de
  interfaz gráfica en la capa Model.

## 7. Pruebas adicionales

Se implementaron las pruebas recomendadas de la sección 7 de la EFP que son
compatibles con las decisiones anteriores:

| Modelo | Pruebas implementadas |
|---|---|
| `Paciente` | PAC-006 a PAC-009 (documento, nombres y apellidos vacíos o con espacios), PAC-012 (correo `null` aceptado) y GEN-003 (dos objetos independientes) |
| `Doctor` | DOC-007 a DOC-009 (campos obligatorios vacíos) y DOC-011, DOC-012 (especialidad vacía o `null` aceptada por ser opcional) |
| `Especialidad` | ESP-004, ESP-005 (nombre vacío o con espacios) y ESP-006, ESP-007 (descripción vacía o `null` aceptada) |
| `CitaMedica` | CIT-009, CIT-016 (motivo vacío o con espacios aceptado), CIT-010 (formato de fecha inválido rechazado), CIT-011 (fecha pasada rechazada) y CIT-012 a CIT-014 (estados válidos) |

Las siguientes pruebas recomendadas no aplican a esta versión:

| Prueba | Motivo |
|---|---|
| PAC-010, PAC-011 | No se valida el formato de correo ni de teléfono. |
| DOC-010 | No se valida el formato de la colegiatura. |
| CIT-015 | El enum `EstadoCita` impide representar un estado no reconocido. |
| GEN-002 | Los modelos son inmutables y no tienen setters. |
| GEN-004 | Los modelos no implementan `equals()` ni `hashCode()`. |

GEN-001 (verificación de atributos) está cubierto por las pruebas de atributos
de cada modelo: PAC-005, DOC-006, ESP-003 y CIT-008.

La suite completa se ejecuta con:

```powershell
.\gradlew.bat test
```
