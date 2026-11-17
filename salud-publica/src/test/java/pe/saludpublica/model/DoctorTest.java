package pe.saludpublica.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DoctorTest {

    @Test
    @DisplayName("DOC-001: Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {
        Doctor doctor = new Doctor("40123456", "Carlos", "Ruiz", "CMP12345", "esp-cardiologia");

        assertNotNull(doctor);
        assertEquals("40123456", doctor.getDocumento());
        assertEquals("Carlos", doctor.getNombres());
        assertEquals("Ruiz", doctor.getApellidos());
        assertEquals("CMP12345", doctor.getColegiatura());
        assertEquals("esp-cardiologia", doctor.getEspecialidad());
    }
    @Test
    @DisplayName("DOC-002: Rechazar la creación de un doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {
        assertThrows(IllegalArgumentException.class,
            () -> new Doctor(null, "Carlos", "Ruiz", "CMP12345", "esp-cardiologia"));
    }
    @Test
    @DisplayName("DOC-003: Rechazar la creación de un doctor sin nombres")
    void shouldRejectDoctorWithoutFirstName() {
        assertThrows(IllegalArgumentException.class,
            () -> new Doctor("40123456", null, "Ruiz", "CMP12345", "esp-cardiologia"));
    }
    @Test
    @DisplayName("DOC-004: Rechazar la creación de un doctor sin apellidos")
    void shouldRejectDoctorWithoutLastName() {
        assertThrows(IllegalArgumentException.class,
            () -> new Doctor("40123456", "Carlos", null, "CMP12345", "esp-cardiologia"));
    }
    @Test
    @DisplayName("DOC-005: Rechazar la creación de un doctor sin colegiatura")
    void shouldRejectDoctorWithoutLicense() {
        assertThrows(IllegalArgumentException.class,
            () -> new Doctor("40123456", "Carlos", "Ruiz", null, "esp-cardiologia"));
    }
    @Test
    @DisplayName("DOC-006: Verificar los atributos del doctor mediante sus getters")
    void shouldReturnAllAttributesThroughGetters() {
        Doctor doctor = new Doctor("50987654", "María", "Salas", "CMP67890", "esp-pediatria");

        assertAll(
            () -> assertEquals("50987654", doctor.getDocumento()),
            () -> assertEquals("María", doctor.getNombres()),
            () -> assertEquals("Salas", doctor.getApellidos()),
            () -> assertEquals("CMP67890", doctor.getColegiatura()),
            () -> assertEquals("esp-pediatria", doctor.getEspecialidad())
        );
    }
}
