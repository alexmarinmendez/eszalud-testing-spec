# Decisiones de Negocio - Capa Model (EsZalud)

- **Identificadores y campos de texto obligatorios (`documento`, `nombres`, `apellidos`, `colegiatura`, `nombre`, `paciente`, `doctor`, `especialidad`):** Se representan como `String` y se validan para rechazar valores `null` o en blanco mediante `IllegalArgumentException`.
- **Campos opcionales (`telefono`, `correo`, `descripcion`, `motivo`):** Se aceptan como `String` sin restricciones adicionales no especificadas en el dominio.
- **Fecha y hora de cita (`fechaHora`):** Se representa con `java.time.LocalDateTime` y es obligatoria (no `null`).
- **Estado de la cita (`estado`):** Se representa mediante el enum `EstadoCita` (`PROGRAMADA`, `ATENDIDA`, `CANCELADA`). Si se recibe `null` al crear la cita (`CIT-006`), se asigna `EstadoCita.PROGRAMADA` por defecto.
