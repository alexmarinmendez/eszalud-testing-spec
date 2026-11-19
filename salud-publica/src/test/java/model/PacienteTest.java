package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pe.saludpublica.model.Paciente;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PacienteTest {

    @Test
    @DisplayName("Crear un paciente con datos válidos")
    void shouldCreatePatientWithValidData() {
        Paciente paciente = new Paciente(
                "12345678",
                "Ana",
                "Pérez",
                "987654321",
                "ana@mail.com"
        );

        assertNotNull(paciente);
        assertEquals("12345678", paciente.getDocumento());
        assertEquals("Ana", paciente.getNombres());
        assertEquals("Pérez", paciente.getApellidos());
        assertEquals("987654321", paciente.getTelefono());
        assertEquals("ana@mail.com", paciente.getCorreo());
    }
}
