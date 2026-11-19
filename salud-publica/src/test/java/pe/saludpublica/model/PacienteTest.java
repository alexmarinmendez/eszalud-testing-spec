package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Pruebas del modelo Paciente")
class PacienteTest {

    // PAC-001
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

    // PAC-002
    @Test
    @DisplayName("Rechazar la creación de un paciente sin documento")
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

    // PAC-003
    @Test
    @DisplayName("Rechazar la creación de un paciente sin nombres")
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

    // PAC-004
    @Test
    @DisplayName("Rechazar la creación de un paciente sin apellidos")
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

    // PAC-005
    @Test
    @DisplayName("Verificar que cada atributo conserve su valor después de construir el paciente")
    void shouldKeepEachAttributeWhenPatientIsCreated() {
        Paciente paciente = new Paciente(
                "87654321",
                "Luis Alberto",
                "Gómez Torres",
                "912345678",
                "luis.gomez@mail.com"
        );

        assertAll(
                () -> assertEquals("87654321", paciente.getDocumento(), "documento"),
                () -> assertEquals("Luis Alberto", paciente.getNombres(), "nombres"),
                () -> assertEquals("Gómez Torres", paciente.getApellidos(), "apellidos"),
                () -> assertEquals("912345678", paciente.getTelefono(), "telefono"),
                () -> assertEquals("luis.gomez@mail.com", paciente.getCorreo(), "correo")
        );
    }

    // PAC-006 (recomendada)
    @Test
    @DisplayName("Rechazar la creación de un paciente con documento vacío")
    void shouldRejectPatientWithEmptyDocument() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Paciente(
                        "",
                        "Ana",
                        "Pérez",
                        "987654321",
                        "ana@mail.com"
                )
        );
    }

    // PAC-007 (recomendada)
    @Test
    @DisplayName("Rechazar la creación de un paciente con documento compuesto solo por espacios")
    void shouldRejectPatientWithBlankDocument() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Paciente(
                        "   ",
                        "Ana",
                        "Pérez",
                        "987654321",
                        "ana@mail.com"
                )
        );
    }

    // PAC-008 (recomendada)
    @Test
    @DisplayName("Rechazar la creación de un paciente con nombres vacíos")
    void shouldRejectPatientWithEmptyFirstName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Paciente(
                        "12345678",
                        "",
                        "Pérez",
                        "987654321",
                        "ana@mail.com"
                )
        );
    }

    // PAC-009 (recomendada)
    @Test
    @DisplayName("Rechazar la creación de un paciente con apellidos vacíos")
    void shouldRejectPatientWithEmptyLastName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Paciente(
                        "12345678",
                        "Ana",
                        "",
                        "987654321",
                        "ana@mail.com"
                )
        );
    }
}