package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    @Test
    @DisplayName("Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {
        Doctor doctor = new Doctor(
                "87654321",
                "Carlos",
                "Mendoza",
                "CMP-12345",
                "Cardiología"
        );

        assertNotNull(doctor);
        assertEquals("87654321", doctor.getDocumento());
        assertEquals("Carlos", doctor.getNombres());
        assertEquals("Mendoza", doctor.getApellidos());
        assertEquals("CMP-12345", doctor.getColegiatura());
        assertEquals("Cardiología", doctor.getEspecialidad());
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(null, "Carlos", "Mendoza", "CMP-12345", "Cardiología")
        );
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin nombres")
    void shouldRejectDoctorWithoutFirstName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor("87654321", null, "Mendoza", "CMP-12345", "Cardiología")
        );
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin apellidos")
    void shouldRejectDoctorWithoutLastName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor("87654321", "Carlos", null, "CMP-12345", "Cardiología")
        );
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin colegiatura")
    void shouldRejectDoctorWithoutLicense() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor("87654321", "Carlos", "Mendoza", null, "Cardiología")
        );
    }
}

