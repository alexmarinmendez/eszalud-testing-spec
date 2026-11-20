# Decisiones de negocio – Capa Model EsZalud

Decisiones tomadas antes de implementar las pruebas (sección 8 de la EFP).

| Elemento | Decisión |
| --- | --- |
| Identificadores | Las referencias a paciente, doctor y especialidad se representan como `String` (id del documento en MongoDB). |
| Documento | Obligatorio (no `null`). No se define longitud ni formato porque no existe una regla de negocio que lo justifique. |
| Nombres y apellidos | Obligatorios (no `null`). |
| Teléfono | Opcional. Sin formato definido. |
| Correo | Opcional. Sin validación de formato en el modelo. |
| Colegiatura | Obligatoria (no `null`). Sin formato definido. |
| Especialidad del doctor | Opcional en el modelo Doctor. |
| Nombre de especialidad | Obligatorio (no `null`). |
| Descripción de especialidad | Opcional. |
| Paciente, doctor y especialidad de la cita | Obligatorios (no `null`). |
| Fecha y hora de la cita | Obligatoria (no `null`), tipo `LocalDateTime`. Se permiten fechas pasadas (registro de citas ya atendidas). |
| Motivo de la cita | Opcional. Sin longitud máxima definida. |
| Estado de la cita (CIT-006) | Si se recibe `null`, se asigna automáticamente `PROGRAMADA`, porque toda cita nueva nace programada. |
| Estados válidos | Se representan con el `enum` `EstadoCita`: `PROGRAMADA`, `ATENDIDA`, `CANCELADA`. |
| Excepción de validación | Los datos obligatorios inválidos lanzan `IllegalArgumentException`. |
| Mockito | Configurado en Gradle. Los modelos no tienen dependencias externas que aislar, por lo que estas pruebas no requieren mocks. |
