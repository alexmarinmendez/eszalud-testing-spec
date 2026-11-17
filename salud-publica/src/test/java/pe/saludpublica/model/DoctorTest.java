package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
