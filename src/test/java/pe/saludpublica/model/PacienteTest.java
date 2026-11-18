package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    @DisplayName("PAC-005: Verificar los atributos después de construir el objeto")
    void shouldReturnPatientAttributes() {
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

    @Test
    @DisplayName("PAC-002: Rechazar la creación de un paciente sin documento")
    void shouldRejectPatientWithoutDocument() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Paciente(null, "Ana", "Pérez", "987654321", "ana@mail.com")
        );
    }

    @Test
    @DisplayName("PAC-003: Rechazar la creación de un paciente sin nombres")
    void shouldRejectPatientWithoutNames() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Paciente("12345678", null, "Pérez", "987654321", "ana@mail.com")
        );
    }

    @Test
    @DisplayName("PAC-004: Rechazar la creación de un paciente sin apellidos")
    void shouldRejectPatientWithoutLastNames() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Paciente("12345678", "Ana", null, "987654321", "ana@mail.com")
        );
    }

    @Test
    @DisplayName("PAC-006: Rechazar un documento vacío")
    void shouldRejectPatientWithEmptyDocument() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Paciente("", "Ana", "Pérez", "987654321", "ana@mail.com")
        );
    }

    @Test
    @DisplayName("PAC-007: Rechazar un documento compuesto solo por espacios")
    void shouldRejectPatientWithBlankDocument() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Paciente("   ", "Ana", "Pérez", "987654321", "ana@mail.com")
        );
    }

    @Test
    @DisplayName("PAC-008: Rechazar nombres vacíos")
    void shouldRejectPatientWithEmptyNames() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Paciente("12345678", "", "Pérez", "987654321", "ana@mail.com")
        );
    }

    @Test
    @DisplayName("PAC-009: Rechazar apellidos vacíos")
    void shouldRejectPatientWithEmptyLastNames() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Paciente("12345678", "Ana", "", "987654321", "ana@mail.com")
        );
    }

    @Test
    @DisplayName("PAC-012: Aceptar un correo opcional con valor nulo")
    void shouldAcceptPatientWithNullEmail() {
        Paciente paciente = new Paciente("12345678", "Ana", "Pérez", "987654321", null);

        assertNotNull(paciente);
        assertNull(paciente.getCorreo());
    }

    @Test
    @DisplayName("GEN-003: Dos pacientes con datos distintos conservan su información")
    void shouldKeepIndependentDataForTwoPatients() {
        Paciente primero = new Paciente(
                "12345678", "Ana", "Pérez", "987654321", "ana@mail.com");
        Paciente segundo = new Paciente(
                "87654321", "Luis", "Gómez", "912345678", "luis@mail.com");

        assertEquals("12345678", primero.getDocumento());
        assertEquals("Ana", primero.getNombres());
        assertEquals("ana@mail.com", primero.getCorreo());

        assertEquals("87654321", segundo.getDocumento());
        assertEquals("Luis", segundo.getNombres());
        assertEquals("luis@mail.com", segundo.getCorreo());
    }
}
