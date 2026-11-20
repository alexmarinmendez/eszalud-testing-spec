# Decisiones de negocio – Capa Model (EsZalud)

Documento de decisiones adoptadas según la sección 8 de la Especificación Formal de Pruebas Unitarias (EFP).

| Elemento | Decisión adoptada |
| --- | --- |
| Documento (Paciente y Doctor) | Obligatorio (no `null`). No se impone restricción de longitud ni formato para no inventar reglas no especificadas. |
| Nombres y apellidos (Paciente y Doctor) | Obligatorios (no `null`). |
| Teléfono (Paciente) | Opcional. Sin restricción de formato ni longitud. |
| Correo (Paciente) | Opcional (acepta `null`). Sin validación de formato. |
| Colegiatura (Doctor) | Obligatoria (no `null`). Sin restricción de formato ni longitud. |
| Especialidad (Doctor) | Identificador `String`, opcional en la construcción del modelo. |
| Nombre (Especialidad) | Obligatorio (no `null`). |
| Descripción (Especialidad) | Opcional (acepta `null`). |
| Motivo de la cita (CitaMedica) | Opcional (acepta `null`). Sin longitud máxima fija. |
| Fecha y hora de la cita (CitaMedica) | Obligatoria (`LocalDateTime`, no `null`). Se permiten fechas pasadas y futuras. |
| Estado de la cita (CitaMedica) | Representado con el enum `EstadoCita` (`PROGRAMADA`, `ATENDIDA`, `CANCELADA`). Para el caso **CIT-006**, cuando se recibe `null` se asigna automáticamente `PROGRAMADA`. |
| Identificadores (paciente, doctor, especialidad) | Se representan con tipo `String`. En `CitaMedica` los tres son obligatorios (no `null`). |