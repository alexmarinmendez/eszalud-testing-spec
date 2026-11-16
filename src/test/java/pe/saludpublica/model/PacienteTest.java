package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    @Test
    @DisplayName("Crear un paciente con datos válidos")
    void shouldCreatePatientWithValidData() {
        Paciente p = new Paciente(
                "12345678",
                "Ana",
                "Pérez",
                "987654321",
                "ana@mail.com"
        );

        assertNotNull(p);
        assertEquals("12345678", p.getDocumento());
    }

    @Test
    @DisplayName("Rechazar paciente sin documento")
    void shouldRejectPatientWithoutDocument() {
        assertThrows(IllegalArgumentException.class,
                () -> new Paciente(
                        null, "Ana", "Pérez",
                        "987654321", "ana@mail.com"
                )
        );
    }

    @Test
    @DisplayName("Rechazar paciente sin nombres")
    void shouldRejectPatientWithoutFirstName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Paciente(
                        "12345678", null, "Pérez",
                        "987654321", "ana@mail.com"
                )
        );
    }

    @Test
    @DisplayName("Rechazar paciente sin apellidos")
    void shouldRejectPatientWithoutLastName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Paciente(
                        "12345678", "Ana", null,
                        "987654321", "ana@mail.com"
                )
        );
    }

    @Test
    @DisplayName("Conservar los valores de los atributos después de la construcción")
    void shouldKeepAttributeValuesAfterConstruction() {
        Paciente p = new Paciente(
                "12345678",
                "Ana",
                "Pérez",
                "987654321",
                "ana@mail.com"
        );

        assertEquals("12345678", p.getDocumento());
        assertEquals("Ana", p.getNombres());
        assertEquals("Pérez", p.getApellidos());
        assertEquals("987654321", p.getTelefono());
        assertEquals("ana@mail.com", p.getCorreo());
    }


}