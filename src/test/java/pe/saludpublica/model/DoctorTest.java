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

    @Test
    @DisplayName("Rechazar la creación de un doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        null,
                        "María",
                        "Rodríguez",
                        "COL12345",
                        "Cardiología"
                )
        );
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin nombres")
    void shouldRejectDoctorWithoutFirstName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "87654321",
                        null,
                        "Rodríguez",
                        "COL12345",
                        "Cardiología"
                )
        );
    }
    @Test
    @DisplayName("Rechazar la creación de un doctor sin apellidos")
    void shouldRejectDoctorWithoutLastName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "87654321",
                        "María",
                        null,
                        "COL12345",
                        "Cardiología"
                )
        );
    }
}