# Decisiones de Negocio – Capa Model (EsZalud)

De acuerdo con la **Sección 1** y la **Sección 8** de la *Especificación Formal de Pruebas Unitarias*, se documentan las reglas de dominio acordadas a partir de los datos reales de la aplicación (`database/*.json`):

| Elemento | Decisión acordada | Justificación en la aplicación |
| :--- | :--- | :--- |
| **Documento** (`Paciente`, `Doctor`) | Cadena obligatoria (`String`), no nula, no vacía ni solo espacios. Formato de 8 dígitos numéricos (`^\d{8}$`). | En `patients.json` y `doctors.json` los documentos son DNI de 8 dígitos. |
| **Teléfono** (`Paciente`) | Opcional (`null` permitido). Si se proporciona, debe tener 9 dígitos numéricos (`^\d{9}$`). | En `patients.json` los teléfonos tienen 9 dígitos. |
| **Correo** (`Paciente`) | Opcional (`null` permitido). Si se proporciona, debe tener formato de email válido (`^[^@\s]+@[^@\s]+\.[^@\s]+$`). | En `patients.json` se registran correos estándar. |
| **Colegiatura** (`Doctor`) | Obligatoria (`String`), no nula, no vacía ni solo espacios. Formato `"CMP "` seguido de 6 dígitos (`^CMP \d{6}$`). | En `doctors.json` todas las colegiaturas tienen el patrón `"CMP 085432"`. |
| **Descripción de especialidad** (`Especialidad`) | Opcional (`null` o cadena vacía permitida). | Permite especialidades con o sin descripción detallada. |
| **Motivo de la cita** (`CitaMedica`) | Obligatorio (`String`), no nulo, no vacío ni solo espacios, máximo 250 caracteres. | En `appointments.json` toda cita registra un motivo clínico. |
| **Fecha y hora de cita** (`CitaMedica`) | Obligatoria (`LocalDateTime`, no `null`). Se permiten fechas pasadas en el modelo para reconstruir citas históricas ya atendidas o canceladas. | En `appointments.json` existen citas pasadas con estado `"ATENDIDA"`. |
| **Estado de la cita** (`CitaMedica`) | Enum `EstadoCita` (`PROGRAMADA`, `ATENDIDA`, `CANCELADA`). Si el constructor recibe `null`, asigna `EstadoCita.PROGRAMADA` por defecto. | Garantiza un estado inicial consistente conforme a `CIT-006`. |
| **Identificadores** (`paciente`, `doctor`, `especialidad`) | Tipo `String` obligatorio (no nulo ni vacío), correspondiente al `ObjectId` de MongoDB. | En `appointments.json` y `doctors.json` las referencias son cadenas `ObjectId`. |