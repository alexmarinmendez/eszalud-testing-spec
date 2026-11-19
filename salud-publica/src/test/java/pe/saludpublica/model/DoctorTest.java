package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Pruebas del modelo Doctor")
class DoctorTest {

    // DOC-001
    @Test
    @DisplayName("Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {
        Doctor doctor = new Doctor(
                "45678912",
                "Carlos",
                "Ramírez",
                "CMP-12345",
                "esp-001"
        );

        assertNotNull(doctor);
        assertEquals("45678912", doctor.getDocumento());
        assertEquals("Carlos", doctor.getNombres());
        assertEquals("Ramírez", doctor.getApellidos());
        assertEquals("CMP-12345", doctor.getColegiatura());
        assertEquals("esp-001", doctor.getEspecialidad());
    }

    // DOC-002
    @Test
    @DisplayName("Rechazar la creación de un doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        null,
                        "Carlos",
                        "Ramírez",
                        "CMP-12345",
                        "esp-001"
                )
        );
    }

    // DOC-003
    @Test
    @DisplayName("Rechazar la creación de un doctor sin nombres")
    void shouldRejectDoctorWithoutFirstName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "45678912",
                        null,
                        "Ramírez",
                        "CMP-12345",
                        "esp-001"
                )
        );
    }

    // DOC-004
    @Test
    @DisplayName("Rechazar la creación de un doctor sin apellidos")
    void shouldRejectDoctorWithoutLastName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "45678912",
                        "Carlos",
                        null,
                        "CMP-12345",
                        "esp-001"
                )
        );
    }

    // DOC-005
    @Test
    @DisplayName("Rechazar la creación de un doctor sin colegiatura")
    void shouldRejectDoctorWithoutLicense() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "45678912",
                        "Carlos",
                        "Ramírez",
                        null,
                        "esp-001"
                )
        );
    }

    // DOC-006
    @Test
    @DisplayName("Verificar que cada atributo conserve su valor después de construir el doctor")
    void shouldKeepEachAttributeWhenDoctorIsCreated() {
        Doctor doctor = new Doctor(
                "71234567",
                "María Elena",
                "Quispe Huamán",
                "CMP-98765",
                "esp-003"
        );

        assertAll(
                () -> assertEquals("71234567", doctor.getDocumento(), "documento"),
                () -> assertEquals("María Elena", doctor.getNombres(), "nombres"),
                () -> assertEquals("Quispe Huamán", doctor.getApellidos(), "apellidos"),
                () -> assertEquals("CMP-98765", doctor.getColegiatura(), "colegiatura"),
                () -> assertEquals("esp-003", doctor.getEspecialidad(), "especialidad")
        );
    }

    // DOC-007 (recomendada)
    @Test
    @DisplayName("Rechazar la creación de un doctor con documento vacío")
    void shouldRejectDoctorWithEmptyDocument() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "",
                        "Carlos",
                        "Ramírez",
                        "CMP-12345",
                        "esp-001"
                )
        );
    }

    // DOC-008 (recomendada)
    @Test
    @DisplayName("Rechazar la creación de un doctor con nombres o apellidos vacíos")
    void shouldRejectDoctorWithEmptyNames() {
        assertAll(
                () -> assertThrows(
                        IllegalArgumentException.class,
                        () -> new Doctor("45678912", "", "Ramírez", "CMP-12345", "esp-001"),
                        "nombres vacíos"
                ),
                () -> assertThrows(
                        IllegalArgumentException.class,
                        () -> new Doctor("45678912", "Carlos", "", "CMP-12345", "esp-001"),
                        "apellidos vacíos"
                )
        );
    }

    // DOC-009 (recomendada)
    @Test
    @DisplayName("Rechazar la creación de un doctor con colegiatura vacía")
    void shouldRejectDoctorWithEmptyLicense() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "45678912",
                        "Carlos",
                        "Ramírez",
                        "",
                        "esp-001"
                )
        );
    }

    // DOC-010 (recomendada, regla documentada en DECISIONES.md)
    @Test
    @DisplayName("Aceptar una colegiatura con formato libre porque no existe una regla de formato")
    void shouldAcceptLicenseWithAnyFormatWhenNoFormatRuleExists() {
        Doctor doctor = new Doctor(
                "45678912",
                "Carlos",
                "Ramírez",
                "12345",
                "esp-001"
        );

        assertEquals("12345", doctor.getColegiatura());
    }

    // DOC-012 (recomendada, regla documentada en DECISIONES.md)
    @Test
    @DisplayName("Rechazar la creación de un doctor sin especialidad")
    void shouldRejectDoctorWithoutSpecialty() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "45678912",
                        "Carlos",
                        "Ramírez",
                        "CMP-12345",
                        null
                )
        );
    }
}