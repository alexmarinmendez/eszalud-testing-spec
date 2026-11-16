
package pe.saludpublica.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class PacienteTest {

    @Test
    @DisplayName("PAC-001: Crear un paciente con datos válidos")
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


    @Test
    @DisplayName("PAC-002: Rechazar paciente sin documento")
    void shouldRejectPatientWithoutDocument() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Paciente(
                        null,
                        "Ana",
                        "Pérez",
                        "987654321",
                        "ana@mail.com"
                )
        );
    }

}
