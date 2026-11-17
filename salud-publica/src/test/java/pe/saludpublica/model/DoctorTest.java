package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoctorTest {

    @Test
    @DisplayName("Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {

        Doctor doctor = new Doctor(
                "45678912",
                "Luis",
                "Ramírez",
                "12345",
                "specialty-001"
        );

        assertNotNull(doctor);
        assertEquals("45678912", doctor.getDocument());
        assertEquals("Luis", doctor.getNames());
        assertEquals("Ramírez", doctor.getSurnames());
        assertEquals("12345", doctor.getLicenseNumber());
        assertEquals("specialty-001", doctor.getSpecialty());
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Doctor(
                   null,
                   "Luis",
                   "Ramírez",
                   "12345",
                   "specialty-001"
            );
        });
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin nombres")
    void shouldRejectDoctorWithoutNames() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Doctor(
                    "45678912",
                    null,
                    "Ramírez",
                    "12345",
                    "specialty-001"
            );
        });
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin apellidos")
    void shouldRejectDoctorWithoutSurnames() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Doctor(
                    "45678912",
                    "Luis",
                    null,
                    "12345",
                    "specialty-001"
            );
        });
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin colegiatura")
    void shouldRejectDoctorWithoutLicenseNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Doctor(
                    "45678912",
                    "Luis",
                    "Ramírez",
                    null,
                    "specialty-001"
            );
        });
    }
}
