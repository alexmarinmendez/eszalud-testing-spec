package pe.saludpublica.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {
    @Test
    void testValidDoctorCreation() {
        Doctor doctor = new Doctor("12345678", "Bianka", "Ataegina", "CMP12345", "Dermatologia");

        assertEquals("12345678", doctor.getDocumento());
        assertEquals("CMP12345", doctor.getColegiatura());
        assertEquals("Bianka", doctor.getNombres());
        assertEquals("Ataegina", doctor.getApellidos());
        assertEquals("Dermatologia", doctor.getEspecialidad());
    }
    @Test
    void testRequiredDocumentValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Doctor(null, "Bianka", "Ataegina", "CMP12345", "Dermatologia");
        });
    }
    @Test
    void testRequiredLicenseValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Doctor("12345678", "Bianka", "Ataegina", null, "Dermatologia");
        });
    }
    @Test
    void testRequiredFirstNameValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Doctor("12345678", null, "Ataegina", "CMP12345", "Dermatologia");
        });
    }
}
