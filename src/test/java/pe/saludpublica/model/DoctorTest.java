package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    @Test
    @DisplayName("Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {
        Doctor doctor = new Doctor(
                "87654321",
                "Carlos",
                "García",
                "CMP12345",
                "ESP-01"
        );

        assertNotNull(doctor);
        assertEquals("87654321", doctor.getDocumento());
        assertEquals("Carlos", doctor.getNombres());
        assertEquals("García", doctor.getApellidos());
        assertEquals("CMP12345", doctor.getColegiatura());
        assertEquals("ESP-01", doctor.getEspecialidad());
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        null,
                        "Carlos",
                        "García",
                        "CMP12345",
                        "ESP-01"
                )
        );
    }
}