package pe.saludpublica.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    @Test
    void shouldCreateDoctorWithValidData() {
        Doctor doctor = new Doctor(
                "12345678",
                "Juan",
                "Perez",
                "CMP12345",
                "Cardiologia"
        );

        assertNotNull(doctor);
        assertEquals("12345678", doctor.getDocumento());
        assertEquals("Juan", doctor.getNombres());
        assertEquals("Perez", doctor.getApellidos());
        assertEquals("CMP12345", doctor.getColegiatura());
        assertEquals("Cardiologia", doctor.getEspecialidad());
    }
}