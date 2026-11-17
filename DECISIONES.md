# Decisiones de negocio – Capa Model (EsZalud)

De acuerdo con la sección 8 y la observación sobre el caso `CIT-006` de la Especificación Formal de Pruebas Unitarias, se documentan las siguientes reglas adoptadas para los modelos:

1. **Estado predeterminado de la cita (`CIT-006`):** Cuando se construye una `CitaMedica` recibiendo `estado` con valor `null`, el modelo asigna automáticamente el estado predeterminado `EstadoCita.PROGRAMADA`.
2. **Atributos opcionales:** En `Paciente`, los campos `telefono` y `correo` son opcionales. En `Especialidad`, el campo `descripcion` es opcional. En `CitaMedica`, el campo `motivo` es opcional.
3. **Normalización de cadenas:** Los campos de texto reciben limpieza de espacios laterales (`trim()`) al construir el objeto.
