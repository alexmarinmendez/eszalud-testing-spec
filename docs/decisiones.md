# Decisiones de negocio pendientes (EFP sección 8)

- **Estado de la cita (CIT-006):** si el estado es `null`, se rechaza con `IllegalArgumentException`. No se asigna `PROGRAMADA` automáticamente.
- **Fecha de la cita:** se usa `LocalDateTime`. La validación de fechas pasadas queda pendiente.
- **Identificadores:** paciente, doctor y especialidad se representan como `String`.
- **Documento, teléfono, correo y colegiatura:** no tienen restricciones de longitud ni formato. Quedan pendientes de definir.
- **Descripción de especialidad y motivo de la cita:** obligatoriedad pendiente de definir.