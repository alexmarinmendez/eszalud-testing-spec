
package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PacienteTest {

    @Test
    @DisplayName("Crear un paciente con datos válidos")
    void shouldCreatePatientWithValidData() {
        Paciente paciente = new Paciente(
                "12345678",
                "Gianello",
                "Orbegozo",
                "987654321",
                "paciente@gmail.com"
        );

        assertEquals("12345678", paciente.getDocumento());
        assertEquals("Gianello", paciente.getNombres());
        assertEquals("Orbegozo", paciente.getApellidos());
        assertEquals("987654321", paciente.getTelefono());
        assertEquals("paciente@gmail.com", paciente.getCorreo());
    }
}