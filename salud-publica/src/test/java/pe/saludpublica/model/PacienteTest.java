package pe.saludpublica.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PacienteTest {

    @Test
    @DisplayName("PAC-001: Crear un paciente con datos válidos")
    void shouldCreatePatientWithValidData() {
        Paciente paciente = new Paciente("12345678", "Ana", "Pérez", "987654321", "ana@mail.com");

        assertNotNull(paciente);
        assertEquals("12345678", paciente.getDocumento());
        assertEquals("Ana", paciente.getNombres());
        assertEquals("Pérez", paciente.getApellidos());
        assertEquals("987654321", paciente.getTelefono());
        assertEquals("ana@mail.com", paciente.getCorreo());
    }

    @Test
    @DisplayName("PAC-002: Rechazar la creación de un paciente sin documento")
    void shouldRejectPatientWithoutDocument() {
        assertThrows(IllegalArgumentException.class,
            () -> new Paciente(null, "Ana", "Pérez", "987654321", "ana@mail.com"));
    }

    @Test
    @DisplayName("PAC-003: Rechazar la creación de un paciente sin nombres")
    void shouldRejectPatientWithoutFirstName() {
        assertThrows(IllegalArgumentException.class,
            () -> new Paciente("12345678", null, "Pérez", "987654321", "ana@mail.com"));
    }
    @Test
    @DisplayName("PAC-004: Rechazar la creación de un paciente sin apellidos")
    void shouldRejectPatientWithoutLastName() {
        assertThrows(IllegalArgumentException.class,
            () -> new Paciente("12345678", "Ana", null, "987654321", "ana@mail.com"));
    }
    @Test
    @DisplayName("PAC-005: Verificar los atributos del paciente mediante sus getters")
    void shouldReturnAllAttributesThroughGetters() {
        Paciente paciente = new Paciente("87654321", "Luis", "Gómez", "999888777", "luis@mail.com");

        assertAll(
            () -> assertEquals("87654321", paciente.getDocumento()),
            () -> assertEquals("Luis", paciente.getNombres()),
            () -> assertEquals("Gómez", paciente.getApellidos()),
            () -> assertEquals("999888777", paciente.getTelefono()),
            () -> assertEquals("luis@mail.com", paciente.getCorreo())
        );
    }
}
