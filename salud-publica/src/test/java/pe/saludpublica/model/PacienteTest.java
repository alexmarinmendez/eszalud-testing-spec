package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PacienteTest {

    @Test
    @DisplayName("Crear un paciente con datos válidos")
    void shouldCreatePatientWithValidData() {
        Paciente p = new Paciente("12345678", "Ana", "Pérez",
                "987654321", "ana@mail.com");
        assertNotNull(p);
        assertEquals("12345678", p.getDocumento());
        assertEquals("Ana", p.getNombres());
        assertEquals("Pérez", p.getApellidos());
        assertEquals("987654321", p.getTelefono());
        assertEquals("ana@mail.com", p.getCorreo());
    }

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

    @Test
    @DisplayName("Rechazar la creación de un paciente sin nombres")
    void shouldRejectPatientWithoutFirstName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Paciente("73891245", null, "Flores Chávez", "978123456", "pedro.flores@mail.com"));
    }

    @Test
    @DisplayName("Rechazar la creación de un paciente sin apellidos")
    void shouldRejectPatientWithoutLastName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Paciente("80123456", "Lucía Isabel", null, "956781234", "lucia.vargas@mail.com"));
    }

    @Test
    @DisplayName("Verificar atributos tras construir el objeto")
    void shouldKeepPatientAttributesAfterConstruction() {
        Paciente p = new Paciente("87654321", "Luis", "Ramos",
                "912345678", "luis@mail.com");
        assertEquals("87654321", p.getDocumento());
        assertEquals("Luis", p.getNombres());
        assertEquals("Ramos", p.getApellidos());
        assertEquals("912345678", p.getTelefono());
        assertEquals("luis@mail.com", p.getCorreo());
    }


}
