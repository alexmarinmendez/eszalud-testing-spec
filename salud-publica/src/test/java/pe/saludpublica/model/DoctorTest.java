package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    @Test
    @DisplayName("DOC-001: Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {
        Doctor doctor = new Doctor(
                "40123456",
                "Carlos",
                "Ramírez",
                "CMP-12345",
                "esp-01"
        );

        assertNotNull(doctor);
        assertEquals("40123456", doctor.getDocumento());
        assertEquals("Carlos", doctor.getNombres());
        assertEquals("Ramírez", doctor.getApellidos());
        assertEquals("CMP-12345", doctor.getColegiatura());
        assertEquals("esp-01", doctor.getEspecialidad());
    }

    @Test
    @DisplayName("DOC-002: Rechazar doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        null,
                        "Carlos",
                        "Ramírez",
                        "CMP-12345",
                        "esp-01"
                )
        );
    }

    @Test
    @DisplayName("DOC-003: Rechazar doctor sin nombres")
    void shouldRejectDoctorWithoutFirstName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "40123456",
                        null,
                        "Ramírez",
                        "CMP-12345",
                        "esp-01"
                )
        );
    }

    @Test
    @DisplayName("DOC-004: Rechazar doctor sin apellidos")
    void shouldRejectDoctorWithoutLastName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "40123456",
                        "Carlos",
                        null,
                        "CMP-12345",
                        "esp-01"
                )
        );
    }

    @Test
    @DisplayName("DOC-005: Rechazar doctor sin colegiatura")
    void shouldRejectDoctorWithoutLicense() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "40123456",
                        "Carlos",
                        "Ramírez",
                        null,
                        "esp-01"
                )
        );
    }

    @Test
    @DisplayName("DOC-006: Verificar atributos después de construir el objeto")
    void shouldKeepAttributesAfterConstruction() {
        Doctor doctor = new Doctor(
                "40999888",
                "María",
                "Torres",
                "CMP-99999",
                "esp-02"
        );

        assertEquals("40999888", doctor.getDocumento());
        assertEquals("María", doctor.getNombres());
        assertEquals("Torres", doctor.getApellidos());
        assertEquals("CMP-99999", doctor.getColegiatura());
        assertEquals("esp-02", doctor.getEspecialidad());
    }
}