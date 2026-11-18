# Decisiones de Negocio Acordadas - Capa Model (EsZalud)

1. Identificadores: Se utiliza el tipo String para representar las referencias a pacientes, doctores y especialidades.
2. Documento, Nombres, Apellidos y Colegiatura: Son obligatorios. No se permiten valores null ni cadenas vacías o en blanco.
3. Teléfono y Correo (Paciente): Son atributos opcionales (aceptan null).
4. Descripción (Especialidad): Es un atributo opcional (acepta null o cadena vacía).
5. Estado de la Cita (CIT-006): Se representa mediante el enumerado EstadoCita (PROGRAMADA, ATENDIDA, CANCELADA). Si se recibe null, se asigna PROGRAMADA por defecto.
6. Fecha y Hora de la Cita: Se utiliza el tipo LocalDateTime y es un campo obligatorio (no acepta null).
7. Motivo de la Cita: Es un campo opcional de tipo String.