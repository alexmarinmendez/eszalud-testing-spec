package pe.saludpublica.model;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {
    @Test
    @DisplayName("PAC-001 / PAC-005: Crear un paciente con datos válidos y verificar getters")
    void shouldCreatePatientWithValidData() {
        Paciente paciente = new Paciente("12345678", "Ana", "Pérez", "987654321", "ana@mail.com");
        assertNotNull(paciente);
        assertEquals("12345678", paciente.getDocumento());
        assertEquals("Ana", paciente.getNombres());
        assertEquals("Pérez", paciente.getApellidos());
        assertEquals("987654321", paciente.getTelefono());
        assertEquals("ana@mail.com", paciente.getCorreo());
    
    @Test
    @DisplayName("PAC-002: Rechazar la creación de un paciente sin documento (null)")
    void shouldRejectPatientWithoutDocument() {
        assertThrows(IllegalArgumentException.class, () -> new Paciente(null, "Ana", "Pérez", "987654321", "ana@mail.com"));
    }

    @Test
    @DisplayName("PAC-003: Rechazar la creación de un paciente sin nombres (null)")
    void shouldRejectPatientWithoutFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Paciente("12345678", null, "Pérez", "987654321", "ana@mail.com"));
    }

    @Test
    @DisplayName("PAC-004: Rechazar la creación de un paciente sin apellidos (null)")
    void shouldRejectPatientWithoutLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Paciente("12345678", "Ana", null, "987654321", "ana@mail.com"));
    }

    @Test
    @DisplayName("PAC-006 / PAC-007: Rechazar documento vacío o con solo espacios")
    void shouldRejectPatientWithBlankDocument() {
        assertThrows(IllegalArgumentException.class, () -> new Paciente("   ", "Ana", "Pérez", "987654321", "ana@mail.com"));
    }

    @Test
    @DisplayName("PAC-008 / PAC-009: Rechazar nombres o apellidos vacíos")
    void shouldRejectPatientWithEmptyNames() {
        assertThrows(IllegalArgumentException.class, () -> new Paciente("12345678", "", "Pérez", "987654321", "ana@mail.com"));
        assertThrows(IllegalArgumentException.class, () -> new Paciente("12345678", "Ana", "", "987654321", "ana@mail.com"));
    }
}

    @Test
    @DisplayName("PAC-002: Rechazar la creación de un paciente sin documento (null)")
    void shouldRejectPatientWithoutDocument() {
        assertThrows(IllegalArgumentException.class, () -> new Paciente(null, "Ana", "Pérez", "987654321", "ana@mail.com"));
    }

    @Test
    @DisplayName("PAC-003: Rechazar la creación de un paciente sin nombres (null)")
    void shouldRejectPatientWithoutFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Paciente("12345678", null, "Pérez", "987654321", "ana@mail.com"));
    }

    @Test
    @DisplayName("PAC-004: Rechazar la creación de un paciente sin apellidos (null)")
    void shouldRejectPatientWithoutLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Paciente("12345678", "Ana", null, "987654321", "ana@mail.com"));
    }

    @Test
    @DisplayName("PAC-006 / PAC-007: Rechazar documento vacío o con solo espacios")
    void shouldRejectPatientWithBlankDocument() {
        assertThrows(IllegalArgumentException.class, () -> new Paciente("   ", "Ana", "Pérez", "987654321", "ana@mail.com"));
    }

    @Test
    @DisplayName("PAC-008 / PAC-009: Rechazar nombres o apellidos vacíos")
    void shouldRejectPatientWithEmptyNames() {
        assertThrows(IllegalArgumentException.class, () -> new Paciente("12345678", "", "Pérez", "987654321", "ana@mail.com"));
        assertThrows(IllegalArgumentException.class, () -> new Paciente("12345678", "Ana", "", "987654321", "ana@mail.com"));
    }
}
