
@'
# Validación del examen EsZalud

## Pruebas unitarias

Se implementaron los 22 casos obligatorios mediante JUnit y TDD.

| Clase | Pruebas | Fallos |
|---|---:|---:|
| PacienteTest | 5 | 0 |
| DoctorTest | 6 | 0 |
| EspecialidadTest | 3 | 0 |
| CitaMedicaTest | 8 | 0 |
| Total | 22 | 0 |

Resultado: BUILD SUCCESSFUL.
Porcentaje de éxito: 100 %.

## Regla de negocio CIT-006

Cuando el constructor de CitaMedica recibe estado = null,
asigna automáticamente el valor PROGRAMADA.

Cuando recibe un estado distinto de null,
conserva el valor proporcionado.

Esta decisión se verificó mediante la prueba CIT-006.

## Verificación de MongoDB

El servidor MongoDB local responde en el puerto 27017.

Cadena de conexión:
mongodb://127.0.0.1:27017/salud_publica

Comando para ejecutar la aplicación de referencia:
java -jar .\reference-app\salud-publica-all.jar

La aplicación abrió correctamente.

Registros observados:
- Pacientes: 18.
- Especialidades: 4.
- Doctores: 5.
- Citas médicas: 3.

Se verificó que los doctores y las citas médicas
aparecen correctamente en MongoDB Compass
y en la aplicación EsZalud.

Las pruebas unitarias se ejecutan de manera independiente
de la base de datos MongoDB.
'@ | Set-Content -Path .\VALIDACION_EXAMEN.md -Encoding UTF8
