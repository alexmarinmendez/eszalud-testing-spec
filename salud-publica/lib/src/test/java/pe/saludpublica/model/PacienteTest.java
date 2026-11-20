package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    // PAC-001
    @Test
    @DisplayName("Crear paciente con datos válidos")
    void shouldCreatePatientWithValidData() {

        Paciente paciente = new Paciente(
                "12345678", "Ana", "Pérez",
                "987654321", "ana@mail.com"
        );

        assertNotNull(paciente);
        assertAll(
                () -> assertEquals("12345678", paciente.getDocumento()),
                () -> assertEquals("Ana", paciente.getNombres()),
                () -> assertEquals("Pérez", paciente.getApellidos()),
                () -> assertEquals("987654321", paciente.getTelefono()),
                () -> assertEquals("ana@mail.com", paciente.getCorreo())
        );
    }

    // PAC-002
    @Test
    @DisplayName("Rechazar paciente sin documento")
    void shouldRejectPatientWithoutDocument() {

        assertThrows(IllegalArgumentException.class,
                () -> new Paciente(null, "Ana", "Pérez",
                        "987654321", "ana@mail.com"));
    }

    // PAC-003
    @Test
    @DisplayName("Rechazar paciente sin nombres")
    void shouldRejectPatientWithoutFirstName() {

        assertThrows(IllegalArgumentException.class,
                () -> new Paciente("12345678", null, "Pérez",
                        "987654321", "ana@mail.com"));
    }

    // PAC-004
    @Test
    @DisplayName("Rechazar paciente sin apellidos")
    void shouldRejectPatientWithoutLastName() {

        assertThrows(IllegalArgumentException.class,
                () -> new Paciente("12345678", "Ana", null,
                        "987654321", "ana@mail.com"));
    }

    // PAC-005
    @Test
    @DisplayName("Verificar los atributos del paciente después de construirlo")
    void shouldReturnCorrectValuesAfterPatientCreation() {

        Paciente paciente = new Paciente(
                "87654321",
                "Carlos",
                "Toledo Asenjo",
                "999888777",
                "carlos@mail.com"
        );

        assertAll(
                () -> assertEquals("87654321", paciente.getDocumento()),
                () -> assertEquals("Carlos", paciente.getNombres()),
                () -> assertEquals("Toledo Asenjo", paciente.getApellidos()),
                () -> assertEquals("999888777", paciente.getTelefono()),
                () -> assertEquals("carlos@mail.com", paciente.getCorreo())
        );
    }
}