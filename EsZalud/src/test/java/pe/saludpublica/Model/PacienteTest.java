package pe.saludpublica.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PacienteTest {
    @Test
    @DisplayName("Crear un paciente con datos válidos")
    void shouldCreatePatientWithValidData() {
        Paciente paciente = new Paciente("12345678","Ana","Pérez","987654321","ana@mail.com");
        assertNotNull(paciente);
        assertEquals("12345678", paciente.getDocumento());
        assertEquals("Ana", paciente.getNombres());
        assertEquals("Pérez", paciente.getApellidos());
        assertEquals("987654321", paciente.getTelefono());
        assertEquals("ana@mail.com", paciente.getCorreo());
    }
    @Test
    @DisplayName("Rechazar la creación de un paciente sin documento")
    void shouldRejectPatientWithoutDocument() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Paciente(
                        null,
                        "Ana",
                        "Perez",
                        "987654321",
                        "ana@mail.com"
                )
        );
    }
    @Test
    @DisplayName("Rechazar la creación de un paciente sin nombres")
    void shouldRejectPatientWithoutNames() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Paciente(
                        "12345678",
                        null,
                        "Perez",
                        "987654321",
                        "ana@mail.com"
                )
        );
    }
    @Test
    @DisplayName("Rechazar la creación de un paciente sin apellidos")
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
    @DisplayName("Verificar los atributos después de construir el paciente")
    void shouldPreserveAllAttributesAfterConstruction() {
        Paciente paciente = new Paciente(
                "87654321",
                "Carlos",
                "Ramirez",
                "912345678",
                "carlos@mail.com"
        );

        assertAll(
                () -> assertEquals("87654321", paciente.getDocumento()),
                () -> assertEquals("Carlos", paciente.getNombres()),
                () -> assertEquals("Ramirez", paciente.getApellidos()),
                () -> assertEquals("912345678", paciente.getTelefono()),
                () -> assertEquals("carlos@mail.com", paciente.getCorreo())
        );
    }
}
