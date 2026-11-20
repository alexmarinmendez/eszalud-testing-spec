package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas del modelo Doctor")
class DoctorTest {

    @Test
    @DisplayName("Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {
        Doctor doctor = new Doctor("87654321", "Carlos", "Ramírez", "CMP-12345", "esp-001");

        assertNotNull(doctor);
        assertEquals("87654321", doctor.getDocumento());
        assertEquals("Carlos", doctor.getNombres());
        assertEquals("Ramírez", doctor.getApellidos());
        assertEquals("CMP-12345", doctor.getColegiatura());
        assertEquals("esp-001", doctor.getEspecialidad());
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Doctor(null, "Carlos", "Ramírez", "CMP-12345", "esp-001")
        );
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin nombres")
    void shouldRejectDoctorWithoutFirstName() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Doctor("87654321", null, "Ramírez", "CMP-12345", "esp-001")
        );
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin apellidos")
    void shouldRejectDoctorWithoutLastName() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Doctor("87654321", "Carlos", null, "CMP-12345", "esp-001")
        );
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin colegiatura")
    void shouldRejectDoctorWithoutLicense() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Doctor("87654321", "Carlos", "Ramírez", null, "esp-001")
        );
    }

    @Test
    @DisplayName("Verificar los atributos después de construir el doctor")
    void shouldKeepAttributesAfterCreation() {
        Doctor doctor = new Doctor("11223344", "María", "Torres", "CMP-67890", "esp-002");

        assertAll(
            () -> assertEquals("11223344", doctor.getDocumento()),
            () -> assertEquals("María", doctor.getNombres()),
            () -> assertEquals("Torres", doctor.getApellidos()),
            () -> assertEquals("CMP-67890", doctor.getColegiatura()),
            () -> assertEquals("esp-002", doctor.getEspecialidad())
        );
    }
}
