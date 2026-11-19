# Decisiones de Negocio – Capa Model (EsZalud)

En cumplimiento de la **Sección 1 y Sección 8** de la Especificación Formal de Pruebas Unitarias (`EFP_Pruebas_Unitarias_EsZalud.md`), se documentan las siguientes definiciones aplicadas en el dominio:

| Elemento | Decisión adoptada | Justificación |
| :--- | :--- | :--- |
| **Identificadores** | Tipo `String` (no nulo ni vacío en referencias obligatorias). | Consistente con los campos `patientId`, `doctorId` y `specialtyId` almacenados en las colecciones JSON de `salud_publica`. |
| **Documento** | Obligatorio (`!= null` y no en blanco). Sin restricción fija de longitud en la capa Model. | Permite aceptar documentos nacionales y extranjeros sin imponer reglas no definidas en la aplicación base. |
| **Teléfono y Correo** | Opcionales (`String`) en la capa Model; pueden ser `null` o texto. | La EFP define como obligatorios únicamente `documento`, `nombres` y `apellidos` en las pruebas base (`PAC-002` a `PAC-004`). |
| **Colegiatura** | Obligatoria (`!= null` y no en blanco), aceptando texto alfanumérico con prefijo. | En `salud_publica.doctors.json` los registros tienen el formato `"CMP 085432"`. |
| **Especialidad en Doctor** | Tipo `String` (opcional en el constructor base del modelo). | Las pruebas obligatorias `DOC-001` a `DOC-006` exigen validar `documento`, `nombres`, `apellidos` y `colegiatura`. |
| **Descripción de Especialidad** | Opcional (`String`). | Solo `nombre` se exige como obligatorio en `ESP-002`. |
| **Fecha y hora de la cita** | Tipo `LocalDateTime`, obligatorio (`!= null`). Se permiten fechas pasadas y futuras. | En `salud_publica.appointments.json` existen citas históricas (`ATENDIDA`) y futuras (`PROGRAMADA`). |
| **Motivo de la cita** | Opcional (`String`). | Las pruebas obligatorias `CIT-002` a `CIT-005` exigen validar `paciente`, `doctor`, `especialidad` y `fechaHora`. |
| **Estado de la cita** | Enum `EstadoCita` (`PROGRAMADA`, `ATENDIDA`, `CANCELADA`). Si se recibe `null` (caso `CIT-006`), se asigna automáticamente `EstadoCita.PROGRAMADA`. | Garantiza que toda cita recién registrada cuente con un estado inicial válido dentro del flujo de atención. |