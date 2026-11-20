# Decisiones de negocio – Capa Model

- Identificadores: String (ObjectId de MongoDB).
- Paciente: documento, nombres y apellidos obligatorios (no null, no vacío, no solo espacios). Teléfono y correo opcionales, sin validar formato.
- Doctor: documento, nombres, apellidos, colegiatura y especialidad obligatorios. Sin regla de formato.
- Especialidad: nombre obligatorio; descripción opcional.
- CitaMedica: paciente, doctor, especialidad, fechaHora (LocalDateTime) y motivo obligatorios. Se permiten fechas pasadas.
- Estado: enum EstadoCita { PROGRAMADA, ATENDIDA, CANCELADA }. Si llega null, se asigna PROGRAMADA.
- Todas las validaciones lanzan IllegalArgumentException.
- Mockito queda configurado; no se usa porque los modelos no tienen dependencias que aislar.