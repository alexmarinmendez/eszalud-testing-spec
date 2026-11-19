package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    @Test
    @DisplayName("DOC-001: Crear doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {
        Doctor doctor = new Doctor(
                "43219876",
                "Carlos",
                "Ruiz",
                "CMP-12345",
                "esp-cardiologia-01"
        );
        assertNotNull(doctor, "El doctor debe crearse");
        assertEquals("43219876", doctor.getDocumento());
        assertEquals("Carlos", doctor.getNombres());
        assertEquals("Ruiz", doctor.getApellidos());
        assertEquals("CMP-12345", doctor.getColegiatura());
        assertEquals("esp-cardiologia-01", doctor.getEspecialidad());
    }

    @Test
    @DisplayName("DOC-002: Rechazar doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {
        assertThrows(IllegalArgumentException.class, () ->
                new Doctor(null, "Carlos", "Ruiz", "CMP-12345", "esp-01")
        );
    }

    @Test
    @DisplayName("DOC-003: Rechazar doctor sin nombres")
    void shouldRejectDoctorWithoutNombres() {
        assertThrows(IllegalArgumentException.class, () ->
                new Doctor("43219876", null, "Ruiz", "CMP-12345", "esp-01")
        );
    }

    @Test
    @DisplayName("DOC-004: Rechazar doctor sin apellidos")
    void shouldRejectDoctorWithoutApellidos() {
        assertThrows(IllegalArgumentException.class, () ->
                new Doctor("43219876", "Carlos", null, "CMP-12345", "esp-01")
        );
    }

    @Test
    @DisplayName("DOC-005: Rechazar doctor sin colegiatura")
    void shouldRejectDoctorWithoutLicense() {
        assertThrows(IllegalArgumentException.class, () ->
                new Doctor("43219876", "Carlos", "Ruiz", null, "esp-01")
        );
    }

    @Test
    @DisplayName("DOC-006: Verificar valores de atributos")
    void shouldReturnCorrectDoctorAttributes() {
        Doctor doctor = new Doctor(
                "11223344",
                "María",
                "Díaz",
                "CMP-98765",
                "esp-pediatria-02"
        );
        assertAll("Todos los atributos deben conservar su valor",
                () -> assertEquals("11223344", doctor.getDocumento()),
                () -> assertEquals("María", doctor.getNombres()),
                () -> assertEquals("Díaz", doctor.getApellidos()),
                () -> assertEquals("CMP-98765", doctor.getColegiatura()),
                () -> assertEquals("esp-pediatria-02", doctor.getEspecialidad())
        );
    }
}
