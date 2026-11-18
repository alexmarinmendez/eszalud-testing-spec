package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}