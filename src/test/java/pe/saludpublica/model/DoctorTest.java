
package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    @Test
    @DisplayName("DOC-001: Crear doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {

        Doctor doctor = new Doctor(
                "12345678",
                "Carlos",
                "Ramírez",
                "CMP12345",
                "ESP001"
        );

        assertNotNull(doctor);
        assertEquals("12345678", doctor.getDocumento());
        assertEquals("Carlos", doctor.getNombres());
        assertEquals("Ramírez", doctor.getApellidos());
        assertEquals("CMP12345", doctor.getColegiatura());
        assertEquals("ESP001", doctor.getEspecialidad());
    }

    @Test
    @DisplayName("DOC-002: Crear doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        null,
                        "Carlos",
                        "Ramírez",
                        "CMP12345",
                        "ESP001"
                )
        );
    }

    @Test
    @DisplayName("DOC-003: Crear doctor sin nombres")
    void shouldRejectDoctorWithoutNames() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "12345678",
                        null,
                        "Ramírez",
                        "CMP12345",
                        "ESP001"
                )
        );
    }

    @Test
    @DisplayName("DOC-004: Crear doctor sin apellidos")
    void shouldRejectDoctorWithoutLastNames() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "12345678",
                        "Carlos",
                        null,
                        "CMP12345",
                        "ESP001"
                )
        );
    }

    @Test
    @DisplayName("DOC-005: Crear doctor sin colegiatura")
    void shouldRejectDoctorWithoutLicense() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "12345678",
                        "Carlos",
                        "Ramírez",
                        null,
                        "ESP001"
                )
        );
    }

    @Test
    @DisplayName("DOC-006: Verificar los atributos del doctor")
    void shouldReturnCorrectDoctorAttributes() {

        Doctor doctor = new Doctor(
                "87654321",
                "María",
                "Fernández",
                "CMP98765",
                "ESP002"
        );

        assertAll(
                () -> assertEquals("87654321", doctor.getDocumento()),
                () -> assertEquals("María", doctor.getNombres()),
                () -> assertEquals("Fernández", doctor.getApellidos()),
                () -> assertEquals("CMP98765", doctor.getColegiatura()),
                () -> assertEquals("ESP002", doctor.getEspecialidad())
        );
    }

}