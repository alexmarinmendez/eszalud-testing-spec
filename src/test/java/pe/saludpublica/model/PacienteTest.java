package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PacienteTest {

    @Test
    @DisplayName("PAC-001: Crear un paciente con datos válidos")
    void shouldCreatePatientWithValidData() {
        Paciente paciente = new Paciente(
                "12345678", "Ana", "Pérez", "987654321", "ana@mail.com"
        );

        assertNotNull(paciente);
        assertEquals("12345678", paciente.getDocumento());
        assertEquals("Ana", paciente.getNombres());
        assertEquals("Pérez", paciente.getApellidos());
        assertEquals("987654321", paciente.getTelefono());
        assertEquals("ana@mail.com", paciente.getCorreo());
    }
    @Test
    @DisplayName("PAC-002: Rechazar un paciente con documento nulo")
    void shouldRejectPatientWithoutDocument() {
        assertThrows(IllegalArgumentException.class, () -> new Paciente(
                null, "Ana", "Pérez", "987654321", "ana@mail.com"
        ));
    }
    @Test
    @DisplayName("PAC-003: Rechazar un paciente con nombres nulos")
    void shouldRejectPatientWithoutFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Paciente(
                "12345678", null, "Pérez", "987654321", "ana@mail.com"
        ));
    }
    @Test
    @DisplayName("PAC-004: Rechazar un paciente con apellidos nulos")
    void shouldRejectPatientWithoutLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Paciente(
                "12345678", "Ana", null, "987654321", "ana@mail.com"
        ));
    }
    @Test
    @DisplayName("PAC-005: Verificar los atributos después de construir el paciente")
    void shouldPreserveAllPatientAttributesAfterConstruction() {
        Paciente paciente = new Paciente(
                "87654321", "Luis", "García", "912345678", "luis@example.com"
        );

        assertEquals("87654321", paciente.getDocumento());
        assertEquals("Luis", paciente.getNombres());
        assertEquals("García", paciente.getApellidos());
        assertEquals("912345678", paciente.getTelefono());
        assertEquals("luis@example.com", paciente.getCorreo());
    }
}
