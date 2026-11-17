# Decisiones de negocio - EsZalud

## Estado de una cita médica

Una cita médica debe contar con un estado válido.

Los Estados Permitidos son:
- PROGRAMADA
- ATENDIDA
- CANCELADA

Si el estado recibido es null, el constructor lanzará IllegalArgumentException.

Esta decisión corresponde al caso CIT-006 de la Especificación Formal de Pruebas.