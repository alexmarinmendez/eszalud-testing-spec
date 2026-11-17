# Decisiones de negocio – Capa Model (EsZalud)

Este documento registra las decisiones adoptadas para implementar la capa Model
mediante TDD. Se implementó el conjunto obligatorio de pruebas unitarias de los
modelos Paciente, Doctor, Especialidad y CitaMedica.

## 1. Tipo de los identificadores

Las referencias entre modelos (paciente, doctor y especialidad en CitaMedica, y
especialidad en Doctor) se representan como `String`, porque los documentos de
MongoDB usan un `_id` de tipo cadena. La capa Model no verifica la existencia de
esas referencias; únicamente las almacena.

## 2. Campos obligatorios y opcionales

Un campo obligatorio en `null` hace que el constructor lance
`IllegalArgumentException`. Los campos opcionales aceptan `null`.

| Modelo       | Obligatorios                               | Opcionales       |
| ------------ | ------------------------------------------ | ---------------- |
| Paciente     | documento, nombres, apellidos              | telefono, correo |
| Doctor       | documento, nombres, apellidos, colegiatura | especialidad     |
| Especialidad | nombre                                     | descripcion      |
| CitaMedica   | paciente, doctor, especialidad, fechaHora  | motivo, estado   |

## 3. Validación de formato

Solo se valida la obligatoriedad (no-null) de los campos. No se valida el formato
de documento, telefono, correo ni colegiatura, porque no hay una regla de negocio
que defina esos formatos.

## 4. Estado de la cita

Los estados posibles son PROGRAMADA, ATENDIDA y CANCELADA, modelados con el enum
`EstadoCita`. Cuando el constructor recibe `estado` en `null`, la cita se crea como
PROGRAMADA por defecto, por ser el estado inicial de una cita nueva. Un estado no
nulo se conserva tal cual.

## 5. Fecha y hora

`fechaHora` se representa con `java.time.LocalDateTime`. Es obligatoria y no se
restringe a fechas futuras.
