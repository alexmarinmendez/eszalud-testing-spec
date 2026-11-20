package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    // PAC-001: Crear paciente válido
    @Test
    @DisplayName("Crear paciente con datos válidos")
    void shouldCreatePatientWithValidData() {

        Paciente paciente = new Paciente(
                "12345678",
                "Ana",
                "Pérez",
                "987654321",
                "ana@mail.com"
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

    // PAC-002: Rechazar documento null
    @Test
    @DisplayName("Rechazar paciente sin documento")
    void shouldRejectPatientWithoutDocument() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Paciente(
                        null, "Ana", "Pérez",
                        "987654321", "ana@mail.com"
                )
        );
    }

    // PAC-003: Rechazar nombres null
    @Test
    @DisplayName("Rechazar paciente sin nombres")
    void shouldRejectPatientWithoutFirstName() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Paciente(
                        "12345678", null, "Pérez",
                        "987654321", "ana@mail.com"
                )
        );
    }

    // PAC-004: Rechazar apellidos null
    @Test
    @DisplayName("Rechazar paciente sin apellidos")
    void shouldRejectPatientWithoutLastName() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Paciente(
                        "12345678",
                        "Ana",
                        null,
                        "987654321",
                        "ana@mail.com"
                )
        );
    }
}