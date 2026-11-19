# Registro de Decisiones de Negocio 

- **Estudiante:** Yumpe Cruz, Sebastian
- **Rama de desarrollo:** `tdd/YumpeCruz_Sebastian`

---

## 1. Decisiones sobre reglas abiertas del dominio (Sección 8)

En cumplimiento de la Especificación Formal de Pruebas Unitarias, se documentan las definiciones adoptadas para los puntos abiertos del contrato antes y durante la implementación de la capa `Model`:

| Elemento | Decisión adoptada | Justificación |
| :--- | :--- | :--- |
| **Identificadores** (`paciente`, `doctor`, `especialidad`) | Se representan como `String`. | Mantiene la capa `Model` desacoplada de la representación interna de documentos en MongoDB. |
| **Fecha y hora de la cita** (`fechaHora`) | Se utiliza `java.time.LocalDateTime`. | Es el tipo estándar de Java 25 para manejar fecha y hora sin zona horaria. |
| **Estado de la cita** (`estado`) | Se implementa mediante el enum `EstadoCita` (`PROGRAMADA`, `ATENDIDA`, `CANCELADA`). | Garantiza seguridad de tipos y evita valores de texto arbitrarios, tal como recomienda la especificación. |
| **Estado `null` en `CitaMedica` (`CIT-006`)** | Se asigna `EstadoCita.PROGRAMADA` automáticamente por defecto. | Toda cita médica registrada sin un estado explícito inicia en estado programado. |
| **Fechas pasadas en `CitaMedica`** | Se permiten en el constructor del modelo. | Permite instanciar historial de citas ya atendidas o canceladas; la restricción de agendamiento futuro corresponde a la capa de servicios. |
| **Validación de cadenas obligatorias** | Se rechazan tanto `null` como cadenas vacías o de solo espacios (`isBlank()`) con `IllegalArgumentException`. | Evita construir entidades del dominio con atributos obligatorios en blanco. |
| **Formato y longitud** (`documento`, `telefono`, `correo`, `colegiatura`) | No se imponen expresiones regulares ni longitudes fijas. | La especificación prohíbe inventar restricciones de formato sin una regla de negocio documentada. |
| **Atributos opcionales** | `telefono` y `correo` (`Paciente`), `especialidad` (`Doctor`), `descripcion` (`Especialidad`) y `motivo` (`CitaMedica`) aceptan `null`. | No forman parte de los atributos obligatorios exigidos en el catálogo base. |

---

## 2. Matriz de obligatoriedad por entidad

| Entidad | Atributos obligatorios (rechazan `null` / `blank`) | Atributos opcionales |
| :--- | :--- | :--- |
| **`Paciente`** | `documento`, `nombres`, `apellidos` | `telefono`, `correo` |
| **`Doctor`** | `documento`, `nombres`, `apellidos`, `colegiatura` | `especialidad` |
| **`Especialidad`** | `nombre` | `descripcion` |
| **`CitaMedica`** | `paciente`, `doctor`, `especialidad`, `fechaHora` | `motivo`, `estado` *(por defecto `PROGRAMADA`)* |

---

## 3. Alcance y trazabilidad del ciclo TDD

- **Cobertura implementada:** Se automatizaron los **22 casos obligatorios** (`PAC-001` a `PAC-005`, `DOC-001` a `DOC-006`, `ESP-001` a `ESP-003` y `CIT-001` a `CIT-008`), complementados con validaciones de cadenas en blanco (`isBlank()`), descripción opcional en `Especialidad` y verificación explícita de los tres estados de `EstadoCita`.
- **Comportamiento del ciclo RED–GREEN:** Los casos de verificación posterior de getters (`PAC-005`, `DOC-006`, `ESP-003`, `CIT-008`) y conservación de estados válidos (`CIT-007`) pasaron directamente tras implementarse los constructores base en ciclos previos, confirmando la ausencia de regresiones en la suite.