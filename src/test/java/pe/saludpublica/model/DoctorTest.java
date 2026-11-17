package pe.saludpublica.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    @Test
    @DisplayName("Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {
        Doctor doctor = new Doctor("76543210", "Carlos", "Mendoza", "CMP12345", "Cardiología");

        assertNotNull(doctor);
        assertEquals("76543210", doctor.getDocumento());
        assertEquals("Carlos", doctor.getNombres());
        assertEquals("Mendoza", doctor.getApellidos());
        assertEquals("CMP12345", doctor.getColegiatura());
        assertEquals("Cardiología", doctor.getEspecialidad());
    }
    @Test
    @DisplayName("Rechazar la creación de un doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(null, "Carlos", "Mendoza", "CMP12345", "Cardiología")
        );
    }
    @Test
    @DisplayName("Rechazar la creación de un doctor sin colegiatura")
    void shouldRejectDoctorWithoutColegiatura() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor("76543210", "Carlos", "Mendoza", null, "Cardiología")
        );
    }
    @Test
    @DisplayName("Rechazar la creación de un doctor sin nombres")
    void shouldRejectDoctorWithoutFirstName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor("76543210", null, "Mendoza", "CMP12345", "Cardiología")
        );
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin apellidos")
    void shouldRejectDoctorWithoutLastName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor("76543210", "Carlos", null, "CMP12345", "Cardiología")
        );
    }
    @Test
    @DisplayName("DOC-007: Rechazar documento vacío o con espacios")
    void shouldRejectEmptyDocument() {
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("", "Carlos", "Mendoza", "CMP12345", "Cardiología"));
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("   ", "Carlos", "Mendoza", "CMP12345", "Cardiología"));
    }

    @Test
    @DisplayName("DOC-008: Rechazar nombres o apellidos vacíos")
    void shouldRejectEmptyNamesAndSurnames() {
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("76543210", "", "Mendoza", "CMP12345", "Cardiología"));
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("76543210", "Carlos", "   ", "CMP12345", "Cardiología"));
    }

    @Test
    @DisplayName("DOC-009: Rechazar colegiatura vacía o con espacios")
    void shouldRejectEmptyColegiatura() {
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("76543210", "Carlos", "Mendoza", "", "Cardiología"));
    }

    @Test
    @DisplayName("DOC-011 y DOC-012: Rechazar especialidad nula o vacía")
    void shouldRejectNullOrEmptyEspecialidad() {
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("76543210", "Carlos", "Mendoza", "CMP12345", null));
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("76543210", "Carlos", "Mendoza", "CMP12345", "   "));
    }
}
