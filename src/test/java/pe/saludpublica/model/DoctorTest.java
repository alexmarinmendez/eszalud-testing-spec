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
                "12345678",
                "Ana",
                "Pérez",
                "CMP12345",
                "ESP-001"
        );

        assertNotNull(doctor);
        assertEquals("12345678", doctor.getDocumento());
        assertEquals("Ana", doctor.getNombres());
        assertEquals("Pérez", doctor.getApellidos());
        assertEquals("CMP12345", doctor.getColegiatura());
        assertEquals("ESP-001", doctor.getEspecialidad());
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        null,
                        "Ana",
                        "Pérez",
                        "CMP12345",
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
                        "12345678",
                        null,
                        "Pérez",
                        "CMP12345",
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
                        "12345678",
                        "Ana",
                        null,
                        "CMP12345",
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
                        "12345678",
                        "Ana",
                        "Pérez",
                        null,
                        "ESP-001"
                )
        );
    }

    @Test
    @DisplayName("Conservar los atributos del doctor después de construirlo")
    void shouldPreserveDoctorAttributesAfterConstruction() {
        Doctor doctor = new Doctor(
                "87654321",
                "Luis",
                "Torres",
                "CMP67890",
                "ESP-002"
        );

        assertEquals("87654321", doctor.getDocumento());
        assertEquals("Luis", doctor.getNombres());
        assertEquals("Torres", doctor.getApellidos());
        assertEquals("CMP67890", doctor.getColegiatura());
        assertEquals("ESP-002", doctor.getEspecialidad());
    }
}
