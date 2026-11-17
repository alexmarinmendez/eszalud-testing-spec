package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    @Test
    @DisplayName("Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {
        Doctor doctor = new Doctor(
                "87654321", "Luis", "Gómez", "CMP-12345", "CARDIOLOGIA");

        assertNotNull(doctor);
        assertEquals("87654321", doctor.getDocumento());
        assertEquals("Luis", doctor.getNombres());
        assertEquals("Gómez", doctor.getApellidos());
        assertEquals("CMP-12345", doctor.getColegiatura());
        assertEquals("CARDIOLOGIA", doctor.getEspecialidad());
    }
}