package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pe.saludpublica.model.Paciente;

import static org.junit.jupiter.api.Assertions.*;

public class PacienteTest {

    @Test
    @DisplayName("Crear un paciente con datos válidos")
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
    @DisplayName("Rechazar la creación de paciente sin documento")
    void shouldRejectPatientWithoutDocument() {
        assertThrows(IllegalArgumentException.class,
                () -> new Paciente(null, "Ana", "Pérez", "987654321", "ana@mail.com"));
    }

    @Test
    @DisplayName("Rechazar la creación de paciente sin nombres")
    void shouldRejectPatientWithoutFirstName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Paciente("12345678", null, "Pérez", "987654321", "ana@mail.com"));
    }

    @Test
    @DisplayName("Rechazar la creación de paciente sin apellidos")
    void shouldRejectPatientWithoutLastName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Paciente("12345678", "Ana", null, "987654321", "ana@mail.com"));
    }

    @Test
    @DisplayName("Conservar cada atributo después de construir el objeto")
    void shouldKeepEachAttributeAfterConstruction() {
        Paciente paciente = new Paciente("87654321", "Luis", "Gómez", "912345678", "luis@mail.com");

        assertEquals("87654321", paciente.getDocumento());
        assertEquals("Luis", paciente.getNombres());
        assertEquals("Gómez", paciente.getApellidos());
        assertEquals("912345678", paciente.getTelefono());
        assertEquals("luis@mail.com", paciente.getCorreo());
    }
}
