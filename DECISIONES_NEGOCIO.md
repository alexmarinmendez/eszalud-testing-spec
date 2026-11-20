# Decisiones de Negocio – Capa Model (EsZalud)

- **Paciente:** `documento`, `nombres` y `apellidos` son obligatorios (no nulos ni en blanco). `telefono` y `correo` son opcionales.
- **Doctor:** `documento`, `nombres`, `apellidos` y `colegiatura` son obligatorios (no nulos ni en blanco). `especialidad` es opcional.
- **Especialidad:** `nombre` es obligatorio (no nulo ni en blanco). `descripcion` es opcional.
- **CitaMedica:** `paciente`, `doctor`, `especialidad` y `fechaHora` son obligatorios (no nulos ni en blanco). `motivo` es opcional. Si `estado` es `null`, se asigna por defecto `EstadoCita.PROGRAMADA`; si se indica un estado válido (`PROGRAMADA`, `ATENDIDA` o `CANCELADA`), se conserva.