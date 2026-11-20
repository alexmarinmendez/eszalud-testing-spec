package pe.saludpublica.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class DoctorTest {


    @Test
    @DisplayName("Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {
        Doctor doctor = new Doctor(
                "12345678",
                "Carlos",
                "Ramirez",
                "CMP12345",
                "CARDIOLOGIA"
        );

        assertNotNull(doctor);

        assertEquals("12345678", doctor.getDocumento());
        assertEquals("Carlos", doctor.getNombres());
        assertEquals("Ramirez", doctor.getApellidos());
        assertEquals("CMP12345", doctor.getColegiatura());
        assertEquals("CARDIOLOGIA", doctor.getEspecialidad());
    }
}
