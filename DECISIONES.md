# Decisiones de Negocio – Capa Model (EsZalud)

De acuerdo con la Sección 8 de la Especificación Formal de Pruebas Unitarias y los datos de referencia de la base de datos (`database/`), se establecen las siguientes reglas para los modelos:

| Elemento | Decisión adoptada | Justificación |
| :--- | :--- | :--- |
| **Identificadores** (`paciente`, `doctor`, `especialidad`) | Se representan como `String` (ObjectId hexadecimal de MongoDB). | Coincide con la estructura almacenada en los archivos JSON de referencia (`salud_publica.*.json`). |
| **Campos obligatorios de texto** | No aceptan `null` ni cadenas vacías o solo espacios (`isBlank()`), arrojando `IllegalArgumentException`. | Evita registrar entidades con datos identificadores en blanco (Sección 7 y 8). |
| **Documento** (`Paciente` y `Doctor`) | Obligatorio (`!= null` y no vacío). No se restringe longitud ni formato fijo en el modelo. | La especificación exige validar obligatoriedad sin inventar restricciones no definidas en el negocio. |
| **Teléfono y Correo** (`Paciente`) | Opcionales (`String`), aceptan valores `null`. | Solo `documento`, `nombres` y `apellidos` figuran como obligatorios en el catálogo de pruebas (`PAC-002` a `PAC-004`). |
| **Colegiatura** (`Doctor`) | Obligatoria (`!= null` y no vacía) de tipo `String` (ej. `"CMP 085432"`). | Requerida por el caso obligatorio `DOC-005`. |
| **Especialidad en Doctor** | Opcional en el constructor (`String`), acepta `null`. | Solo `documento`, `nombres`, `apellidos` y `colegiatura` son obligatorios en `DOC-002` a `DOC-005`. |
| **Descripción** (`Especialidad`) | Opcional (`String`), acepta `null`. | Solo `nombre` es obligatorio según `ESP-002`. |
| **Fecha y hora** (`CitaMedica`) | Obligatoria (`!= null`), representada con `java.time.LocalDateTime`. | Permite representar fecha y hora exacta de la consulta (`yyyy-MM-dd HH:mm`) sin depender de zonas horarias externas. |
| **Motivo** (`CitaMedica`) | Opcional (`String`), acepta `null`. | Solo `paciente`, `doctor`, `especialidad` y `fechaHora` son obligatorios en `CIT-002` a `CIT-005`. |
| **Estado de la cita** (`CitaMedica`) | Representado con `enum EstadoCita` (`PROGRAMADA`, `ATENDIDA`, `CANCELADA`). Si se recibe `null`, se asigna **`EstadoCita.PROGRAMADA`** por defecto (`CIT-006`). | Toda cita recién registrada inicia programada si no se especifica un estado distinto. |