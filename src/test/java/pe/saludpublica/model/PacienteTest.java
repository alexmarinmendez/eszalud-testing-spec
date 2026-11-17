package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
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

    @Test
    void shouldThrowExceptionWhenDniIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Paciente(
                null,
                "Alex Américo",
                "Marín Méndez",
                "942270712",
                "alexmarinmendez@gmail.com"
        ));
    }

    @Test
    @DisplayName("Rechazar la creación de un paciente sin nombres")
    void shouldRejectPatientWithoutFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Paciente(
                "18205786",
                null,
                "Marín Méndez",
                "942270712",
                "alexmarinmendez@gmail.com"
        ));
    }

}
