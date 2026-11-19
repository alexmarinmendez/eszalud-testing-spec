
package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    @Test
    @DisplayName("Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {

        Especialidad especialidad = new Especialidad(
                "Cardiología",
                "Especialista del corazón"
        );

        Doctor doctor = new Doctor(
                "12345678",
                "Carlos",
                "Ramírez",
                "CMP12345",
                especialidad
        );

        assertNotNull(doctor);

        assertEquals("12345678", doctor.getDocumento());
        assertEquals("Carlos", doctor.getNombres());
        assertEquals("Ramírez", doctor.getApellidos());
        assertEquals("CMP12345", doctor.getNumeroColegiatura());
        assertEquals(especialidad, doctor.getEspecialidad());
    }
}
