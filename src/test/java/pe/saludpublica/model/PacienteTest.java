
package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    @DisplayName("Rechazar paciente con documento nulo")
    void shouldThrowExceptionWhenDocumentIsNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Paciente(
                    null,
                    "Gianello",
                    "Orbegozo",
                    "987654321",
                    "paciente@gmail.com"
            );
        });
    }

    @Test
    @DisplayName("Rechazar paciente con nombres nulos")
    void shouldThrowExceptionWhenFirstNameIsNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Paciente(
                    "12345678",
                    null,
                    "Orbegozo",
                    "987654321",
                    "paciente@gmail.com"
            );
        });
    }

    @Test
    @DisplayName("Rechazar paciente con apellidos nulos")
    void shouldThrowExceptionWhenLastNameIsNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Paciente(
                    "12345678",
                    "Gianello",
                    null,
                    "987654321",
                    "paciente@gmail.com"
            );
        });
    }
}