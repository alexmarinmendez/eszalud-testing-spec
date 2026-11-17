# Decisiones de negocio

## Estado de la cita médica

Para el caso obligatorio CIT-006, el estado de una cita es obligatorio. Si se recibe `null` al crearla, se rechazará con `IllegalArgumentException`. Quien crea la cita deberá indicar explícitamente su estado, por ejemplo `PROGRAMADA`.
