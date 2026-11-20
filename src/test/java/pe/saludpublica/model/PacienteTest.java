package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    @Test
    @DisplayName("Crear un paciente con datos válidos")
    void shouldCreatePatientWithValidData() {

        Paciente paciente = new Paciente(
                "73891245",
                "Pedro Miguel",
                "Flores Chávez",
                "978123456",
                "pedro.flores@example.com"
        );

        assertNotNull(paciente);
        assertEquals("73891245", paciente.getDocumento());
        assertEquals("Pedro Miguel", paciente.getNombres());
        assertEquals("Flores Chávez", paciente.getApellidos());
        assertEquals("978123456", paciente.getTelefono());
        assertEquals("pedro.flores@example.com", paciente.getCorreo());
    }

    @Test
    @DisplayName("No permitir crear un paciente con documento nulo")
    void shouldThrowExceptionWhenDocumentIsNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Paciente(
                    null,
                    "Pedro Miguel",
                    "Flores Chávez",
                    "978123456",
                    "pedro.flores@example.com"
            );
        });
    }

    @Test
    @DisplayName("No permitir crear un paciente con nombres nulos")
    void shouldThrowExceptionWhenNamesAreNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Paciente(
                    "73891245",
                    null,
                    "Flores Chávez",
                    "978123456",
                    "pedro.flores@example.com"
            );
        });
    }
    @Test
    @DisplayName("No permitir crear un paciente con apellidos nulos")
    void shouldThrowExceptionWhenLastNamesAreNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Paciente(
                    "73891245",
                    "Pedro Miguel",
                    null,
                    "978123456",
                    "pedro.flores@example.com"
            );
        });
    }
    @Test
    @DisplayName("Obtener correctamente los datos del paciente")
    void shouldReturnCorrectPatientData() {

        Paciente paciente = new Paciente(
                "73891245",
                "Pedro Miguel",
                "Flores Chávez",
                "978123456",
                "pedro.flores@example.com"
        );

        assertEquals("73891245", paciente.getDocumento());
        assertEquals("Pedro Miguel", paciente.getNombres());
        assertEquals("Flores Chávez", paciente.getApellidos());
        assertEquals("978123456", paciente.getTelefono());
        assertEquals("pedro.flores@example.com", paciente.getCorreo());
    }
}