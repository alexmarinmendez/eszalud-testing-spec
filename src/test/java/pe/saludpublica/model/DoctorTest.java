package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    @Test
    @DisplayName("Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {
        Doctor d = new Doctor(
                "87654321",
                "Carlos",
                "Gómez",
                "CMP12345",
                "Cardiología"
        );

        assertNotNull(d);
        assertEquals("87654321", d.getDocumento());
    }
}