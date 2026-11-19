# Pruebas unitarias – Capa Model de EsZalud

Pruebas desarrolladas con TDD (RED → GREEN → REFACTOR) siguiendo la
Especificación Formal de Pruebas (EFP). Las reglas de negocio aplicadas
están en [DECISIONES.md](DECISIONES.md).

## Cómo ejecutar

Desde la carpeta `salud-publica`:

    .\gradlew.bat test

Reporte HTML: `build/reports/tests/test/index.html`

Las pruebas no requieren MongoDB, Docker ni la interfaz gráfica.

## Resumen

| Modelo | Clase de prueba | Obligatorias | Recomendadas | Ejecuciones |
|---|---|---|---|---|
| Paciente | `PacienteTest` | 5 | 7 | 12 |
| Doctor | `DoctorTest` | 6 | 6 | 12 |
| Especialidad | `EspecialidadTest` | 3 | 4 | 7 |
| CitaMedica | `CitaMedicaTest` | 8 | 8 | 16 |
| Generales | `ModelosGeneralesTest` | — | 2 | 5 |
| **Total** | | **22** | **27** | **52** |

## Trazabilidad

### Paciente (`PacienteTest`)

| ID | Método |
|---|---|
| PAC-001 | `shouldCreatePatientWithValidData` |
| PAC-002 | `shouldRejectPatientWithoutDocument` |
| PAC-003 | `shouldRejectPatientWithoutFirstName` |
| PAC-004 | `shouldRejectPatientWithoutLastName` |
| PAC-005 | `shouldKeepEachAttributeWhenPatientIsCreated` |
| PAC-006 | `shouldRejectPatientWithEmptyDocument` |
| PAC-007 | `shouldRejectPatientWithBlankDocument` |
| PAC-008 | `shouldRejectPatientWithEmptyFirstName` |
| PAC-009 | `shouldRejectPatientWithEmptyLastName` |
| PAC-010 | `shouldRejectPatientWithInvalidEmail` |
| PAC-011 | `shouldAcceptPhoneWithAnyFormatWhenNoFormatRuleExists` |
| PAC-012 | `shouldAcceptPatientWithoutEmailWhenEmailIsOptional` |

### Doctor (`DoctorTest`)

| ID | Método |
|---|---|
| DOC-001 | `shouldCreateDoctorWithValidData` |
| DOC-002 | `shouldRejectDoctorWithoutDocument` |
| DOC-003 | `shouldRejectDoctorWithoutFirstName` |
| DOC-004 | `shouldRejectDoctorWithoutLastName` |
| DOC-005 | `shouldRejectDoctorWithoutLicense` |
| DOC-006 | `shouldKeepEachAttributeWhenDoctorIsCreated` |
| DOC-007 | `shouldRejectDoctorWithEmptyDocument` |
| DOC-008 | `shouldRejectDoctorWithEmptyNames` |
| DOC-009 | `shouldRejectDoctorWithEmptyLicense` |
| DOC-010 | `shouldAcceptLicenseWithAnyFormatWhenNoFormatRuleExists` |
| DOC-011 | `shouldRejectDoctorWithEmptySpecialty` |
| DOC-012 | `shouldRejectDoctorWithoutSpecialty` |

### Especialidad (`EspecialidadTest`)

| ID | Método |
|---|---|
| ESP-001 | `shouldCreateSpecialtyWithValidData` |
| ESP-002 | `shouldRejectSpecialtyWithoutName` |
| ESP-003 | `shouldKeepEachAttributeWhenSpecialtyIsCreated` |
| ESP-004 | `shouldRejectSpecialtyWithEmptyName` |
| ESP-005 | `shouldRejectSpecialtyWithBlankName` |
| ESP-006 | `shouldAcceptSpecialtyWithEmptyDescriptionWhenDescriptionIsOptional` |
| ESP-007 | `shouldAcceptSpecialtyWithoutDescriptionWhenDescriptionIsOptional` |

### CitaMedica (`CitaMedicaTest`)

| ID | Método |
|---|---|
| CIT-001 | `shouldCreateAppointmentWithValidData` |
| CIT-002 | `shouldRejectAppointmentWithoutPatient` |
| CIT-003 | `shouldRejectAppointmentWithoutDoctor` |
| CIT-004 | `shouldRejectAppointmentWithoutSpecialty` |
| CIT-005 | `shouldRejectAppointmentWithoutDateTime` |
| CIT-006 | `shouldAssignScheduledStatusWhenStatusIsNull` |
| CIT-007 | `shouldKeepValidStatusWhenAppointmentIsCreated` |
| CIT-008 | `shouldKeepEachAttributeWhenAppointmentIsCreated` |
| CIT-009 | `shouldAcceptAppointmentWithEmptyReasonWhenReasonIsOptional` |
| CIT-010 | `shouldRejectInvalidDateTimeBeforeCreatingAppointment` |
| CIT-011 | `shouldAcceptAppointmentWithPastDateWhenHistoryIsAllowed` |
| CIT-012 a CIT-014 | `shouldKeepEachStatusWhenAppointmentIsCreated` (parametrizada con `@EnumSource`) |
| CIT-015 | `shouldRejectUnrecognizedAppointmentStatus` |
| CIT-016 | `shouldAcceptAppointmentWithBlankReasonWhenReasonIsOptional` |

### Generales (`ModelosGeneralesTest`)

| ID | Método / situación |
|---|---|
| GEN-001 | Cubierto por PAC-005, DOC-006, ESP-003 y CIT-008. |
| GEN-002 | `shouldBeImmutableWhenModelIsCreated` (parametrizada: los modelos no tienen setters). |
| GEN-003 | `shouldKeepIndependentDataWhenCreatingDifferentObjects` |
| GEN-004 | No aplica: `equals()` y `hashCode()` no están implementados (ver DECISIONES.md). |

## Notas

- Las pruebas que verifican atributos o decisiones ya implementadas pasaron
  en verde desde el primer intento; sus commits lo indican en la descripción.
- Mockito está configurado, pero no fue necesario: los modelos no tienen
  dependencias externas que aislar.
- La validación de campos obligatorios está centralizada en la clase
  `Validaciones`, compartida por los cuatro modelos.