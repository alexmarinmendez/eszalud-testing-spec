package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    // DOC-001: Crear doctor con datos válidos
    @Test
    @DisplayName("Crear doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {

        Doctor doctor = new Doctor(
                "45678912",
                "Roberto",
                "Salazar",
                "CMP 085432",
                "ESP-001"
        );

        assertNotNull(doctor);

        assertAll(
                () -> assertEquals("45678912", doctor.getDocumento()),
                () -> assertEquals("Roberto", doctor.getNombres()),
                () -> assertEquals("Salazar", doctor.getApellidos()),
                () -> assertEquals("CMP 085432", doctor.getColegiatura()),
                () -> assertEquals("ESP-001", doctor.getEspecialidad())
        );
    }

    // DOC-002: Documento null
    @Test
    @DisplayName("Rechazar doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {

        assertThrows(IllegalArgumentException.class,
                () -> new Doctor(null, "Roberto", "Salazar",
                        "CMP 085432", "ESP-001"));
    }

    // DOC-003: Nombres null
    @Test
    @DisplayName("Rechazar doctor sin nombres")
    void shouldRejectDoctorWithoutFirstName() {

        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("45678912", null, "Salazar",
                        "CMP 085432", "ESP-001"));
    }

    // DOC-004: Apellidos null
    @Test
    @DisplayName("Rechazar doctor sin apellidos")
    void shouldRejectDoctorWithoutLastName() {

        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("45678912", "Roberto", null,
                        "CMP 085432", "ESP-001"));
    }

    // DOC-005: Colegiatura null
    @Test
    @DisplayName("Rechazar doctor sin colegiatura")
    void shouldRejectDoctorWithoutLicense() {

        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("45678912", "Roberto", "Salazar",
                        null, "ESP-001"));
    }

    // DOC-006: Verificar atributos
    @Test
    @DisplayName("Verificar atributos del doctor después de construirlo")
    void shouldReturnCorrectValuesAfterDoctorCreation() {

        Doctor doctor = new Doctor(
                "72345681",
                "Patricia",
                "Vargas",
                "CMP 092718",
                "ESP-002"
        );

        assertAll(
                () -> assertEquals("72345681", doctor.getDocumento()),
                () -> assertEquals("Patricia", doctor.getNombres()),
                () -> assertEquals("Vargas", doctor.getApellidos()),
                () -> assertEquals("CMP 092718", doctor.getColegiatura()),
                () -> assertEquals("ESP-002", doctor.getEspecialidad())
        );
    }
}
