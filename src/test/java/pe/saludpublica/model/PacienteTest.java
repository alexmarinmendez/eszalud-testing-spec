package pe.saludpublica.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    @Test
    @DisplayName("PAC-001 y PAC-005: Crear paciente con datos válidos")
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
    @DisplayName("PAC-002: Rechazar paciente sin documento (null)")
    void shouldRejectPatientWithoutDocument() {
        assertThrows(IllegalArgumentException.class,
                () -> new Paciente(null, "Ana", "Pérez", "987654321", "ana@mail.com"));
    }

    @Test
    @DisplayName("PAC-003: Rechazar paciente sin nombres (null)")
    void shouldRejectPatientWithoutFirstName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Paciente("12345678", null, "Pérez", "987654321", "ana@mail.com"));
    }

    @Test
    @DisplayName("PAC-004: Rechazar paciente sin apellidos (null)")
    void shouldRejectPatientWithoutLastName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Paciente("12345678", "Ana", null, "987654321", "ana@mail.com"));
    }

    @Test
    @DisplayName("PAC-006 y PAC-007: Rechazar documento vacío o con espacios")
    void shouldRejectEmptyDocument() {
        assertThrows(IllegalArgumentException.class,
                () -> new Paciente("", "Ana", "Pérez", "987654321", "ana@mail.com"));
        assertThrows(IllegalArgumentException.class,
                () -> new Paciente("   ", "Ana", "Pérez", "987654321", "ana@mail.com"));
    }

    @Test
    @DisplayName("PAC-008 y PAC-009: Rechazar nombres o apellidos vacíos")
    void shouldRejectEmptyNamesAndSurnames() {
        assertThrows(IllegalArgumentException.class,
                () -> new Paciente("12345678", "", "Pérez", "987654321", "ana@mail.com"));
        assertThrows(IllegalArgumentException.class,
                () -> new Paciente("12345678", "Ana", "   ", "987654321", "ana@mail.com"));
    }

    @Test
    @DisplayName("PAC-012: Aceptar correo opcional con valor null")
    void shouldAcceptNullEmail() {
        Paciente paciente = new Paciente("12345678", "Ana", "Pérez", "987654321", null);
        assertNull(paciente.getCorreo());
    }
    @Test
    @DisplayName("GEN-003: Crear dos objetos con información diferente sin interferencia")
    void shouldMaintainIndependentDataForMultipleInstances() {
        Paciente paciente1 = new Paciente("11111111", "Ana", "Pérez", "987654321", "ana@mail.com");
        Paciente paciente2 = new Paciente("22222222", "Luis", "Gómez", "912345678", "luis@mail.com");

        // Verificamos que los datos del paciente 1 no se hayan sobreescrito
        assertEquals("11111111", paciente1.getDocumento());
        assertEquals("Ana", paciente1.getNombres());

        // Verificamos que los datos del paciente 2 sean suyos
        assertEquals("22222222", paciente2.getDocumento());
        assertEquals("Luis", paciente2.getNombres());
    }

    @Test
    @DisplayName("GEN-004: Verificar equals() y hashCode() basados en el documento")
    void shouldEvaluateEqualityBasedOnDocument() {
        Paciente pacienteA = new Paciente("12345678", "Ana", "Pérez", "987654321", "ana@mail.com");
        // Paciente B tiene el mismo documento, para el sistema ES LA MISMA PERSONA
        Paciente pacienteB = new Paciente("12345678", "Ana María", "Pérez", "987654321", "ana.maria@mail.com");
        Paciente pacienteDiferente = new Paciente("87654321", "Carlos", "Ruiz", "999888777", "carlos@mail.com");

        assertEquals(pacienteA, pacienteB); // Deben ser iguales por tener el mismo DNI
        assertNotEquals(pacienteA, pacienteDiferente); // Deben ser diferentes
        assertEquals(pacienteA.hashCode(), pacienteB.hashCode()); // Sus hashCodes deben coincidir
    }
}