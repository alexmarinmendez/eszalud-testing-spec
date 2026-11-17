package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PacienteTest {

    @Test
    @DisplayName("PAC-001: Crear un paciente con datos válidos")
    void shouldCreatePatientWithValidData() {
        Paciente paciente = new Paciente("12345678", "Carlos", "Jimenez", "987654321", "Carlitos@mail.com");

        assertNotNull(paciente);
        assertEquals("12345678", paciente.getDocumento());
        assertEquals("Carlos", paciente.getNombres());
        assertEquals("Jimenez", paciente.getApellidos());
        assertEquals("987654321", paciente.getTelefono());
        assertEquals("Carlitos@mail.com", paciente.getCorreo());
    }
    @Test
    void testNullDocumentValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Paciente(null, "Carlos", "Jimenez", "987654321", "Carlitos@test.com");
        });
    }
    @Test
    void testNullFirstNameValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Paciente("73123456", null, "Jimenez", "987654321", "Carlitos@test.com");
        });
    }
}