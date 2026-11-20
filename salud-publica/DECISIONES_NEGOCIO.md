\# Decisiones de negocio - EsZalud



\## Citas médicas



1\. Los identificadores de paciente, doctor y especialidad se representan como String.

2\. La fecha y hora se conservan como String, siguiendo el formato presente en los datos de ejemplo: yyyy-MM-dd HH:mm.

3\. El estado de la cita se representa mediante el enumerado EstadoCita, con los valores PROGRAMADA, ATENDIDA y CANCELADA.

4\. Si el estado recibido es null, el constructor lanza IllegalArgumentException.

5\. No se asigna automáticamente el estado PROGRAMADA cuando se recibe null.

6\. El motivo se conserva como String; no se agrega una validación de obligatoriedad fuera de los casos requeridos.

