package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    @Test
    @DisplayName("PAC-001: Crear un paciente con datos válidos")
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
    @DisplayName("PAC-002: Rechazar paciente sin documento")
    void shouldRejectPatientWithoutDocument() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Paciente(
                        null,
                        "Ana",
                        "Pérez",
                        "987654321",
                        "ana@mail.com"
                )
        );
    }

    @Test
    @DisplayName("PAC-003: Rechazar paciente sin nombres")
    void shouldRejectPatientWithoutFirstName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Paciente(
                        "12345678",
                        null,
                        "Pérez",
                        "987654321",
                        "ana@mail.com"
                )
        );
    }

    @Test
    @DisplayName("PAC-004: Rechazar paciente sin apellidos")
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

    @Test
    @DisplayName("PAC-005: Verificar atributos después de construir el objeto")
    void shouldKeepAttributesAfterConstruction() {
        Paciente paciente = new Paciente(
                "87654321",
                "Luis",
                "Gómez",
                "912345678",
                "luis@mail.com"
        );

        assertEquals("87654321", paciente.getDocumento());
        assertEquals("Luis", paciente.getNombres());
        assertEquals("Gómez", paciente.getApellidos());
        assertEquals("912345678", paciente.getTelefono());
        assertEquals("luis@mail.com", paciente.getCorreo());
    }


}