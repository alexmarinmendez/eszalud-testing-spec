# Decisiones de negocio – Capa Model de EsZalud

Este documento registra las reglas de negocio acordadas antes de implementar
las pruebas que dependen de ellas (sección 8 de la EFP).

| Elemento | Decisión | Justificación |
|---|---|---|
| Documento | Obligatorio. Se rechaza `null`, vacío o compuesto solo por espacios. No se restringe longitud ni caracteres. | Es el identificador de la persona. No existe una regla de negocio que fije su longitud o formato. |
| Teléfono | Opcional. No se valida formato ni longitud. | No existe una regla de negocio que defina su formato. |
| Correo | Opcional (se acepta `null`). Si se informa, debe tener un formato básico `usuario@dominio`. | Es un dato de contacto, no de identificación. Un correo mal escrito no sirve para contactar al paciente. |
| Colegiatura | Obligatoria. Se rechaza `null`, vacía o solo espacios. No se restringe formato ni longitud. | Acredita al profesional. No existe una regla que fije su formato. |
| Descripción de especialidad | Opcional (se acepta `null` o vacía). | El nombre identifica la especialidad; la descripción es informativa. |
| Motivo de la cita | Opcional. No se fija longitud máxima. | No existe una regla de negocio que lo exija ni que limite su longitud. |
| Fecha de la cita | Obligatoria. Se permiten fechas pasadas. | Las citas con estado ATENDIDA tienen fechas pasadas; rechazarlas impediría representar el historial. |
| Estado de la cita | Si se recibe `null`, se asigna `PROGRAMADA`. | Una cita recién creada nace programada. Sigue el mismo criterio de valores por defecto aplicado en los ejemplos del curso. |
| Identificadores | Las referencias a paciente, doctor y especialidad se representan como `String`. | MongoDB identifica los documentos con `_id`; en el modelo se manejan como texto. |
| Tipo de fecha y hora | `java.time.LocalDateTime`. | Representa fecha y hora sin depender de la zona horaria. |