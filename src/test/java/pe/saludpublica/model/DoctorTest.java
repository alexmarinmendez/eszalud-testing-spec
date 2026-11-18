package pe.saludpublica.model;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {
    @Test
    @DisplayName("DOC-001 / DOC-006: Crear un doctor con datos válidos y verificar atributos")
    void shouldCreateDoctorWithValidData() {
        Doctor doctor = new Doctor("87654321", "Carlos", "Gómez", "CMP-10203", "ESP-01");
        assertNotNull(doctor);
        assertEquals("87654321", doctor.getDocumento());
        assertEquals("Carlos", doctor.getNombres());
        assertEquals("Gómez", doctor.getApellidos());
        assertEquals("CMP-10203", doctor.getColegiatura());
        assertEquals("ESP-01", doctor.getEspecialidad());
    }

    @Test
    @DisplayName("DOC-002: Rechazar la creación de un doctor sin documento (null)")
    void shouldRejectDoctorWithoutDocument() {
        assertThrows(IllegalArgumentException.class, () -> new Doctor(null, "Carlos", "Gómez", "CMP-10203", "ESP-01"));
    }

    @Test
    @DisplayName("DOC-003: Rechazar la creación de un doctor sin nombres (null)")
    void shouldRejectDoctorWithoutFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Doctor("87654321", null, "Gómez", "CMP-10203", "ESP-01"));
    }

    @Test
    @DisplayName("DOC-004: Rechazar la creación de un doctor sin apellidos (null)")
    void shouldRejectDoctorWithoutLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Doctor("87654321", "Carlos", null, "CMP-10203", "ESP-01"));
    }

    @Test
    @DisplayName("DOC-005: Rechazar la creación de un doctor sin colegiatura (null)")
    void shouldRejectDoctorWithoutLicense() {
        assertThrows(IllegalArgumentException.class, () -> new Doctor("87654321", "Carlos", "Gómez", null, "ESP-01"));
    }

    @Test
    @DisplayName("DOC-007 / DOC-009: Rechazar documento o colegiatura vacíos")
    void shouldRejectDoctorWithBlankDocumentOrLicense() {
        assertThrows(IllegalArgumentException.class, () -> new Doctor("", "Carlos", "Gómez", "CMP-10203", "ESP-01"));
        assertThrows(IllegalArgumentException.class, () -> new Doctor("87654321", "Carlos", "Gómez", "   ", "ESP-01"));
    }
}
