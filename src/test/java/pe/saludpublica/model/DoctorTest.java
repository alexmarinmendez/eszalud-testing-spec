package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    @Test
    @DisplayName("DOC-001: Crear doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {
        Doctor doctor = new Doctor("12345678", "Juan", "Pérez", "COL-999", "Cardiología", "987654321", "juan@mail.com");

        assertNotNull(doctor);
        assertEquals("12345678", doctor.getDocumento());
        assertEquals("Juan", doctor.getNombres());
        assertEquals("Pérez", doctor.getApellidos());
        assertEquals("COL-999", doctor.getColegiatura());
        assertEquals("Cardiología", doctor.getEspecialidad());
        assertEquals("987654321", doctor.getTelefono());
        assertEquals("juan@mail.com", doctor.getCorreo());
    }

    @Test
    @DisplayName("DOC-002: Crear doctor sin documento (null)")
    void shouldRejectDoctorWithoutDocument() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(null, "Juan", "Pérez", "COL-999", "Cardiología", "987654321", "juan@mail.com")
        );
    }

    @Test
    @DisplayName("DOC-003: Crear doctor sin nombres (null)")
    void shouldRejectDoctorWithoutNames() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor("12345678", null, "Pérez", "COL-999", "Cardiología", "987654321", "juan@mail.com")
        );
    }

    @Test
    @DisplayName("DOC-004: Crear doctor sin apellidos (null)")
    void shouldRejectDoctorWithoutLastNames() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor("12345678", "Juan", null, "COL-999", "Cardiología", "987654321", "juan@mail.com")
        );
    }

    @Test
    @DisplayName("DOC-005: Crear doctor sin colegiatura (null)")
    void shouldRejectDoctorWithoutColegiatura() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor("12345678", "Juan", "Pérez", null, "Cardiología", "987654321", "juan@mail.com")
        );
    }

    @Test
    @DisplayName("DOC-006: Verificar los atributos después de construir el objeto")
    void shouldVerifyDoctorAttributesAfterConstruction() {
        Doctor doctor = new Doctor("87654321", "Ana", "Gómez", "COL-111", "Pediatría", "912345678", "ana@mail.com");

        assertEquals("87654321", doctor.getDocumento());
        assertEquals("Ana", doctor.getNombres());
        assertEquals("Gómez", doctor.getApellidos());
        assertEquals("COL-111", doctor.getColegiatura());
        assertEquals("Pediatría", doctor.getEspecialidad());
    }
}