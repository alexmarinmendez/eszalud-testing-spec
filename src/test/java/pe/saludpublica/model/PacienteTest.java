package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PacienteTest {

    @Test
    @DisplayName("Debe crear un paciente correctamente cuando todos los datos son válidos")
    void shouldCreatePatientWhenDataIsValid() {
        Paciente paciente = new Paciente(
                "12345678",
                "Ana",
                "García",
                "987654321",
                "ana.garcia@correo.com"
        );

        assertNotNull(paciente);
        assertEquals("12345678", paciente.getDocumento());
        assertEquals("Ana", paciente.getNombres());
        assertEquals("García", paciente.getApellidos());
        assertEquals("987654321", paciente.getTelefono());
        assertEquals("ana.garcia@correo.com", paciente.getCorreo());
    }

    @Test
    @DisplayName("Debe lanzar IllegalArgumentException cuando el documento es nulo")
    void shouldRejectPatientWhenDocumentIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Paciente(
                null,
                "Ana",
                "García",
                "987654321",
                "ana.garcia@correo.com"
        ));
    }
}
