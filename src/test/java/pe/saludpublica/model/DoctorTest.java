package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DoctorTest {

    @Test
    @DisplayName("Debe crear un doctor correctamente cuando todos los datos son válidos")
    void shouldCreateDoctorWhenDataIsValid() {
        Doctor doctor = new Doctor(
                "87654321",
                "María",
                "López",
                "COL12345",
                "ESP01"
        );

        assertNotNull(doctor);
        assertEquals("87654321", doctor.getDocumento());
        assertEquals("María", doctor.getNombres());
        assertEquals("López", doctor.getApellidos());
        assertEquals("COL12345", doctor.getColegiatura());
        assertEquals("ESP01", doctor.getEspecialidad());
    }
}
