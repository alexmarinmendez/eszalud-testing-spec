package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DoctorTest {

    @Test
    @DisplayName("Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {

        Doctor doctor = new Doctor(
                "40123456",
                "Carlos",
                "Ramírez",
                "CMP-12345",
                "ESP-001"
        );

        assertNotNull(doctor);

        assertEquals("40123456", doctor.getDocumento());
        assertEquals("Carlos", doctor.getNombres());
        assertEquals("Ramírez", doctor.getApellidos());
        assertEquals("CMP-12345", doctor.getColegiatura());
        assertEquals("ESP-001", doctor.getEspecialidad());
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        null,
                        "Carlos",
                        "Ramírez",
                        "CMP-12345",
                        "ESP-001"
                )
        );
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin nombres")
    void shouldRejectDoctorWithoutFirstName() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "40123456",
                        null,
                        "Ramírez",
                        "CMP-12345",
                        "ESP-001"
                )
        );
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin apellidos")
    void shouldRejectDoctorWithoutLastName() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "40123456",
                        "Carlos",
                        null,
                        "CMP-12345",
                        "ESP-001"
                )
        );
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin colegiatura")
    void shouldRejectDoctorWithoutLicense() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "40123456",
                        "Carlos",
                        "Ramírez",
                        null,
                        "ESP-001"
                )
        );
    }

    @Test
    @DisplayName("Verificar los atributos del doctor después de construir el objeto")
    void shouldKeepDoctorAttributesAfterConstruction() {

        Doctor doctor = new Doctor(
                "45678901",
                "Marta",
                "Torres",
                "CMP-67890",
                "ESP-002"
        );

        assertEquals("45678901", doctor.getDocumento());
        assertEquals("Marta", doctor.getNombres());
        assertEquals("Torres", doctor.getApellidos());
        assertEquals("CMP-67890", doctor.getColegiatura());
        assertEquals("ESP-002",doctor.getEspecialidad());
    }
}