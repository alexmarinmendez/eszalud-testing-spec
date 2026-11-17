package pe.saludpublica.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PacienteTest {

    @Test
    void ShouldCreateProjectWithValidData() {
        Paciente paciente = new Paciente(
                "12345678",
                "Marco",
                "Francisco",
                "970688997",
                "null@gnail.pe"
        );
        assertNotNull(paciente);
        assertEquals("12345678", paciente.getDocumento());
        assertEquals("Marco", paciente.getNombres());
        assertEquals("Francisco", paciente.getApellidos());
        assertEquals("970688997", paciente.getTelefono());
        assertEquals("null@gnail.pe", paciente.getCorreo());



    }

}
