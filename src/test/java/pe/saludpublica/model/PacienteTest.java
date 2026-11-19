
package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    // PAC-001: Crear paciente con datos válidos
    @Test
    @DisplayName("Crear un paciente con datos válidos")
    void shouldCreatePatientWithValidData() {

        Paciente paciente = new Paciente(
                "12345678", "Ana", "Pérez",
                "987654321", "ana@mail.com"
        );

        assertNotNull(paciente);
    }

    // PAC-002: Documento nulo
    @Test
    @DisplayName("No permitir documento nulo")
    void shouldThrowExceptionWhenDocumentIsNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Paciente(null, "Ana", "Pérez",
                    "987654321", "ana@mail.com");
        });
    }

    // PAC-003: Nombres nulos
    @Test
    @DisplayName("No permitir nombres nulos")
    void shouldThrowExceptionWhenNamesAreNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Paciente("12345678", null, "Pérez",
                    "987654321", "ana@mail.com");
        });
    }

    // PAC-004: Apellidos nulos
    @Test
    @DisplayName("No permitir apellidos nulos")
    void shouldThrowExceptionWhenLastNamesAreNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Paciente("12345678", "Ana", null,
                    "987654321", "ana@mail.com");
        });
    }

    // PAC-005: Verificar todos los atributos
    @Test
    @DisplayName("Verificar todos los atributos del paciente")
    void shouldReturnAllPatientAttributes() {

        Paciente paciente = new Paciente(
                "12345678", "Ana", "Pérez",
                "987654321", "ana@mail.com"
        );

        assertEquals("12345678", paciente.getDocumento());
        assertEquals("Ana", paciente.getNombres());
        assertEquals("Pérez", paciente.getApellidos());
        assertEquals("987654321", paciente.getTelefono());
        assertEquals("ana@mail.com", paciente.getCorreo());
    }
}
