
package pe.saludpublica.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class PacienteTest {

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
    void shouldRejectPatientWithoutNames() {

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
    void shouldRejectPatientWithoutLastNames() {

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
    @DisplayName("PAC-005: Verificar los atributos del paciente")
    void shouldPreservePatientAttributesAfterConstruction() {

        Paciente paciente = new Paciente(
                "87654321",
                "Carlos",
                "García",
                "912345678",
                "carlos@mail.com"
        );

        assertEquals("87654321", paciente.getDocumento());
        assertEquals("Carlos", paciente.getNombres());
        assertEquals("García", paciente.getApellidos());
        assertEquals("912345678", paciente.getTelefono());
        assertEquals("carlos@mail.com", paciente.getCorreo());
    }


}
