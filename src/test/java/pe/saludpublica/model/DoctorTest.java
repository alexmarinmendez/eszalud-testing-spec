package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DoctorTest {

    @Test
    @DisplayName("Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {
        Doctor doctor = new Doctor(
                "87654321",
                "María",
                "Rodríguez",
                "COL12345",
                "Cardiología"
        );

        assertNotNull(doctor);
        assertEquals("87654321", doctor.getDocumento());
        assertEquals("María", doctor.getNombres());
        assertEquals("Rodríguez", doctor.getApellidos());
        assertEquals("COL12345", doctor.getColegiatura());
        assertEquals("Cardiología", doctor.getEspecialidad());
    }
}