# Reglas de negocio – Capa Model

- Identificadores: Se utiliza String para los ObjectId de MongoDB.
- Paciente: Documento, nombres y apellidos obligatorios (no nulos, no vacíos ni compuestos solo por espacios). Teléfono y correo opcionales, sin validación de formato.
- Doctor: Documento, nombres, apellidos, colegiatura y especialidad obligatorios. Sin restricciones de formato.
- Especialidad: Nombre obligatorio; descripción opcional.
- CitaMedica: Paciente, doctor, especialidad, fechaHora (LocalDateTime) y motivo obligatorios. Se permiten fechas anteriores a la actual.
- Estado: Enum EstadoCita { PROGRAMADA, ATENDIDA, CANCELADA }. Si recibe null, se establece PROGRAMADA por defecto.
- Todas las validaciones generan IllegalArgumentException.
- Mockito permanece configurado como dependencia, pero no se utiliza porque los modelos no tienen dependencias que requieran ser simuladas.