# Decisiones de negocio

## Estado de la cita médica

Para el caso obligatorio CIT-006, el estado de una cita es obligatorio. Si se recibe `null` al crearla, se rechazará con `IllegalArgumentException`. Quien crea la cita deberá indicar explícitamente su estado, por ejemplo `PROGRAMADA`.

## Representación de los datos

- Los identificadores de paciente, doctor y especialidad se representan como `String` en la capa de modelos. Esta elección evita depender de un tipo específico de MongoDB; no valida si el registro existe.
- La fecha y hora de una cita se representan mediante `LocalDateTime`. El modelo no especifica una zona horaria.
- Los estados de una cita se representan con `EstadoCita`: `PROGRAMADA`, `ATENDIDA` y `CANCELADA`.

## Reglas todavía no definidas

La especificación no establece las siguientes reglas de negocio. Se dejan pendientes de confirmación y no se añaden restricciones que las presupongan:

- Longitud y caracteres del documento y de la colegiatura.
- Obligatoriedad, formato y longitud del teléfono y del correo.
- Obligatoriedad de la descripción de una especialidad y del identificador de especialidad de un doctor.
- Obligatoriedad y longitud máxima del motivo de una cita.
- Si se permiten citas con fechas pasadas.

En la implementación actual solo se comprueba `null` para los campos exigidos por los casos obligatorios y para el estado de la cita. Los demás campos se conservan sin validaciones adicionales; esto describe el comportamiento actual y no confirma una regla de negocio para ellos. Tampoco se valida si las cadenas están vacías o contienen solo espacios.
