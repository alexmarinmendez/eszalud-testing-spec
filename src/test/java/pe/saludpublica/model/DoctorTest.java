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

    @Test
    @DisplayName("Rechazar doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor(
                        null, "Carlos", "Gómez",
                        "CMP12345", "Cardiología"
                )
        );
    }


    @Test
    @DisplayName("Rechazar doctor sin nombres")
    void shouldRejectDoctorWithoutFirstName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor(
                        "87654321", null, "Gómez",
                        "CMP12345", "Cardiología"
                )
        );
    }
}