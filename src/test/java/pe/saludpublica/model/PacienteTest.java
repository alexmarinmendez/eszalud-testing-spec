package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    @Test
    void shouldCreatePatientWithValidData() {
        Paciente paciente = new Paciente(
                "18205786",
                "Alex Américo",
                "Marín Méndez",
                "942270712",
                "alexmarinmendez@gmail.com"
        );

        assertNotNull(paciente);
        assertEquals("18205786", paciente.getDocumento());
        assertEquals("Alex Américo", paciente.getNombres());
        assertEquals("Marín Méndez", paciente.getApellidos());
        assertEquals("942270712", paciente.getTelefono());
        assertEquals("alexmarinmendez@gmail.com", paciente.getCorreo());
    }

    @Test
    void shouldThrowExceptionWhenDniIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Paciente(
                null,
                "Alex Américo",
                "Marín Méndez",
                "942270712",
                "alexmarinmendez@gmail.com"
        ));
    }

    @Test
    @DisplayName("Rechazar la creación de un paciente sin nombres")
    void shouldRejectPatientWithoutFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Paciente(
                "18205786",
                null,
                "Marín Méndez",
                "942270712",
                "alexmarinmendez@gmail.com"
        ));
    }

    @Test
    @DisplayName("Rechazar la creación de un paciente sin apellidos")
    void shouldRejectPatientWithoutLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Paciente(
                "18205786",
                "Alex Américo",
                null,
                "942270712",
                "alexmarinmendez@gmail.com"
        ));
    }


    @Test
    @DisplayName("Verificar los atributos después de construir el objeto paciente")
    void shouldPreserveAllAttributesAfterCreation() {
        Paciente paciente = new Paciente(
                "  45678912  ",
                "  Carlos Eduardo  ",
                "  Ramírez Torres  ",
                "  987654321  ",
                "  carlos.ramirez@example.com  "
        );

        assertAll(
                () -> assertEquals("45678912", paciente.getDocumento()),
                () -> assertEquals("Carlos Eduardo", paciente.getNombres()),
                () -> assertEquals("Ramírez Torres", paciente.getApellidos()),
                () -> assertEquals("987654321", paciente.getTelefono()),
                () -> assertEquals("carlos.ramirez@example.com", paciente.getCorreo())
        );
    }


}
