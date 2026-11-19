# Decisiones de negocio - capa Model

- Identificadores de paciente, doctor y especialidad (en Doctor y en CitaMedica): se representan como String.
- Fecha y hora de la cita: se representa con LocalDateTime.
- Estado de la cita: se representa con el enum EstadoCita (PROGRAMADA, ATENDIDA, CANCELADA).
- Si una cita se crea con estado null, se asigna automaticamente PROGRAMADA.
- Campos obligatorios (null lanza IllegalArgumentException):
  - Paciente: documento, nombres, apellidos.
  - Doctor: documento, nombres, apellidos, colegiatura.
  - Especialidad: nombre.
  - CitaMedica: paciente, doctor, especialidad, fechaHora.
- Campos opcionales: telefono y correo (Paciente), especialidad (Doctor), descripcion (Especialidad), motivo (CitaMedica).
- No se validan formatos ni longitudes, porque no existe una regla de negocio que los defina.