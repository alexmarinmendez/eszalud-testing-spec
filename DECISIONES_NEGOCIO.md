# Decisiones de Negocio - EsZalud

Documentación de las decisiones de negocio y criterios de validación establecidos para la implementación y pruebas unitarias de la capa de modelos (`model`) del sistema EsZalud.

| Elemento | Decisión establecida | Regla / Justificación en el Dominio |
| :--- | :--- | :--- |
| **Documento** | Cadena (`String`) obligatoria (`!= null`) | Requerido de forma estricta en `Paciente` y `Doctor`. Sin restricciones arbitrarias de longitud o formato no especificadas en la especificación. |
| **Teléfono** | Cadena (`String`) opcional | Atributo flexible en `Paciente`. No bloqueante y sin validaciones de expresiones regulares o longitudes rígidas no declaradas. |
| **Correo** | Cadena (`String`) opcional | Atributo opcional en `Paciente`. Se acepta formato libre sin forzar restricciones de estructura arbitrarias. |
| **Colegiatura** | Cadena (`String`) obligatoria (`!= null`) | Obligatorio en `Doctor` para asegurar la identificación formal del profesional médico. Sin formato de longitud fija impuesto. |
| **Descripción de especialidad** | Cadena (`String`) opcional | Campo descriptivo complementario en `Especialidad`, permitido como `null`. |
| **Motivo de la cita** | Cadena (`String`) opcional | Detalle informativo opcional en `CitaMedica`, sin límite rígido de caracteres. |
| **Fecha de cita** | `LocalDateTime` obligatoria (`!= null`) | Obligatoria en `CitaMedica`. Se permiten fechas pasadas o futuras para desacoplar reglas temporales de la capa de modelo. |
| **Estado de la cita** | Asignación automática de `EstadoCita.PROGRAMADA` | Si se recibe `null` en el constructor de `CitaMedica`, se asigna por defecto el estado `PROGRAMADA` de acuerdo con el requerimiento `CIT-006`. |
| **Identificadores** | Representados como tipo `String` | Las referencias a paciente, doctor y especialidad dentro de `CitaMedica` se gestionan mediante identificadores de texto obligatorios (`!= null`). |