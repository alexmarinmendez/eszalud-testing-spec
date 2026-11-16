package pe.saludpublica.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    @Test
    void shouldCreatePatientWithValidData() {
        Paciente paciente = new Paciente(
                "18205786",
                "Alex Américo",
                "Marín Méndez",
                "942270712",
                "alexmarinmendez@gmail.com"
        );

        assertNotNull(paciente);
        assertEquals("18205786", paciente.getDocumento());
        assertEquals("Alex Américo", paciente.getNombres());
        assertEquals("Marín Méndez", paciente.getApellidos());
        assertEquals("942270712", paciente.getTelefono());
        assertEquals("alexmarinmendez@gmail.com", paciente.getCorreo());
    }
}
