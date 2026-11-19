package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    @Test
    @DisplayName("Crear un paciente con datos válidos")
    void shouldCreatePatientWithValidData() {
        Paciente paciente = new Paciente("12345678", "Ana", "Pérez", "987654321", "ana@mail.com");
        assertNotNull(paciente);
        assertEquals("12345678", paciente.getDocumento());
        assertEquals("Ana", paciente.getNombres());
        assertEquals("Pérez", paciente.getApellidos());
        assertEquals("987654321", paciente.getTelefono());
        assertEquals("ana@mail.com", paciente.getCorreo());
    }

    @Test
    @DisplayName("Conservar los atributos después de construir el paciente")
    void shouldKeepAttributesAfterConstruction() {
        Paciente paciente = new Paciente("87654321", "Luis", "Gómez", "912345678", "luis@mail.com");
        assertEquals("87654321", paciente.getDocumento());
        assertEquals("Luis", paciente.getNombres());
        assertEquals("Gómez", paciente.getApellidos());
        assertEquals("912345678", paciente.getTelefono());
        assertEquals("luis@mail.com", paciente.getCorreo());
    }
}