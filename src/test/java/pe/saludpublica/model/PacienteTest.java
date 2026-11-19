package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    @Test
    @DisplayName("PAC-001: Crear paciente con datos válidos")
    void shouldCreatePatientWithValidData() {
        Paciente paciente = new Paciente(
                "12345678",
                "Ana",
                "Pérez",
                "987654321",
                "ana@mail.com"
        );
        assertNotNull(paciente, "El paciente debe crearse");
        assertEquals("12345678", paciente.getDocumento());
        assertEquals("Ana", paciente.getNombres());
        assertEquals("Pérez", paciente.getApellidos());
        assertEquals("987654321", paciente.getTelefono());
        assertEquals("ana@mail.com", paciente.getCorreo());
    }

    @Test
    @DisplayName("PAC-002: Rechazar creación sin documento")
    void shouldRejectPatientWithoutDocument() {
        assertThrows(IllegalArgumentException.class, () ->
                new Paciente(null, "Ana", "Pérez", "987654321", "ana@mail.com")
        );
    }

    @Test
    @DisplayName("PAC-003: Rechazar creación sin nombres")
    void shouldRejectPatientWithoutNombres() {
        assertThrows(IllegalArgumentException.class, () ->
                new Paciente("12345678", null, "Pérez", "987654321", "ana@mail.com")
        );
    }

    @Test
    @DisplayName("PAC-004: Rechazar creación sin apellidos")
    void shouldRejectPatientWithoutApellidos() {
        assertThrows(IllegalArgumentException.class, () ->
                new Paciente("12345678", "Ana", null, "987654321", "ana@mail.com")
        );
    }

    @Test
    @DisplayName("PAC-005: Verificar valores de atributos")
    void shouldReturnCorrectAttributeValues() {
        Paciente paciente = new Paciente(
                "87654321",
                "Luis",
                "Gómez",
                "912345678",
                "luis@mail.com"
        );
        assertAll("Todos los atributos deben conservar su valor",
                () -> assertEquals("87654321", paciente.getDocumento()),
                () -> assertEquals("Luis", paciente.getNombres()),
                () -> assertEquals("Gómez", paciente.getApellidos()),
                () -> assertEquals("912345678", paciente.getTelefono()),
                () -> assertEquals("luis@mail.com", paciente.getCorreo())
        );
    }
}
