# Decisiones de negocio – EsZalud

1. Los identificadores de los modelos serán String,
   compatibles con los identificadores de MongoDB.

2. Si el estado de una cita médica es null,
   se asignará automáticamente PROGRAMADA.

3. Se validará que los campos obligatorios
   no reciban valores null.

4. Los estados permitidos para una cita son:
   PROGRAMADA, ATENDIDA y CANCELADA.
