package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    @Test
    @DisplayName("Crear un paciente con datos válidos")
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
    @DisplayName("Permitir campos opcionales nulos o en blanco")
    void shouldAllowOptionalFieldsWhenNullOrBlank() {
        Paciente paciente = new Paciente(
                "45678912",
                "Carlos Eduardo",
                "Ramírez Torres",
                null,
                "   "
        );

        assertEquals("45678912", paciente.getDocumento());
        assertNull(paciente.getTelefono());
        assertEquals("   ", paciente.getCorreo());
    }

    @Test
    @DisplayName("Rechazar la creación de un paciente sin documento")
    void shouldRejectPatientWithoutDocument() {
        assertThrows(IllegalArgumentException.class, () ->
                new Paciente(null, "Ana", "Pérez", "987654321", "ana@mail.com")
        );
        assertThrows(IllegalArgumentException.class, () ->
                new Paciente("   ", "Ana", "Pérez", "987654321", "ana@mail.com")
        );
    }

    @Test
    @DisplayName("Rechazar la creación de un paciente sin nombres")
    void shouldRejectPatientWithoutFirstName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Paciente("12345678", null, "Pérez", "987654321", "ana@mail.com")
        );
        assertThrows(IllegalArgumentException.class, () ->
                new Paciente("12345678", "  ", "Pérez", "987654321", "ana@mail.com")
        );
    }

    @Test
    @DisplayName("Rechazar la creación de un paciente sin apellidos")
    void shouldRejectPatientWithoutLastName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Paciente("12345678", "Ana", null, "987654321", "ana@mail.com")
        );
        assertThrows(IllegalArgumentException.class, () ->
                new Paciente("12345678", "Ana", "", "987654321", "ana@mail.com")
        );
    }
}