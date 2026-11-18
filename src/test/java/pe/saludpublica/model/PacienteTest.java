package pe.saludpublica.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    @Test
    void shouldCreatePatientWithValidData() {
        Paciente paciente = new Paciente(
                "12345678",
                "Cristhian",
                "Cotrina",
                "987654321",
                "cristhian@gmail.com"
        );

        assertNotNull(paciente);
        assertEquals("12345678", paciente.getDocumento());
        assertEquals("Cristhian", paciente.getNombres());
        assertEquals("Cotrina", paciente.getApellidos());
        assertEquals("987654321", paciente.getTelefono());
        assertEquals("cristhian@gmail.com", paciente.getCorreo());
    }

    @Test
    void shouldRejectPatientWithoutDocument() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Paciente(
                        null,
                        "Cristhian",
                        "Cotrina",
                        "987654321",
                        "cristhian@gmail.com"
                )
        );
    }
    @Test
    void shouldRejectPatientWithoutNames() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Paciente(
                        "12345678",
                        null,
                        "Cotrina",
                        "987654321",
                        "cristhian@gmail.com"
                )
        );
    }
}