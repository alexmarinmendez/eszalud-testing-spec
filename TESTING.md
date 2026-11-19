# Especificación y Decisiones de Pruebas Unitarias (TDD) - EsZalud

**Estudiante:** Alexander Josué Verenzuela Daboin  
**Curso:** Pruebas de Software / Desarrollo de Software  
**Enfoque metodológico:** Test-Driven Development (TDD) – Ciclo RED / GREEN / REFACTOR  

---

## 1. Cobertura de Modelos Implementados

1. **Paciente (`Paciente.java`):**
   - Construcción con datos válidos (`documento`, `nombres`, `apellidos`, `telefono`, `correo`).
   - Validación de no nulidad y no vacuidad para `documento`, `nombres` y `apellidos` (lanzando `IllegalArgumentException`).
   - Verificación de la consistencia de los getters.

2. **Doctor (`Doctor.java`):**
   - Construcción con datos válidos (`documento`, `nombres`, `apellidos`, `colegiatura`, `especialidad`).
   - Validación de obligatoriedad para `documento`, `nombres`, `apellidos` y `colegiatura` profesional.
   - Verificación de atributos mediante sus respectivos getters.

3. **Especialidad (`Especialidad.java`):**
   - Construcción con datos válidos (`nombre`, `descripcion`).
   - Validación obligatoria de `nombre` (no nulo ni vacío).
   - Acceso consistente a sus propiedades.

4. **Cita Médica (`CitaMedica.java` y `EstadoCita.java`):**
   - Representación de estados mediante el enum `EstadoCita` (`PROGRAMADA`, `ATENDIDA`, `CANCELADA`).
   - Validación obligatoria de referencias (`paciente`, `doctor`, `especialidad`, `fechaHora`).
   - Asignación por defecto del estado `PROGRAMADA` cuando el estado inicial recibido sea `null`.

---

## 2. Decisiones de Negocio y Dominio (Sección 8 de la EFP)

* **Obligatoriedad de Campos:** Se estableció que ningún campo obligatorio acepte valores `null` ni cadenas vacías (`""`) o con solo espacios.
* **Estado Predeterminado de Cita:** Conforme a la observación de la regla `CIT-006`, cuando el parámetro de estado es recibido como `null`, el sistema asigna de forma automática y predeterminada el estado `EstadoCita.PROGRAMADA`.
* **Inmutabilidad y Encapsulamiento:** Las clases del modelo garantizan el encapsulamiento de sus atributos privados, exponiendo únicamente métodos de acceso de solo lectura (getters).

---

## 3. Ejecución de Pruebas Automatizadas

La suite completa de pruebas unitarias fue desarrollada utilizando **JUnit 5 Jupiter** y ejecutada exitosamente a través del wrapper oficial de Gradle:

```bash
.\gradlew.bat test
```
