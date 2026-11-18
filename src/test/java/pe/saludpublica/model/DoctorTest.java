package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DoctorTest {

    @Test
    @DisplayName("DOC-001: Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {
        Doctor doctor = new Doctor(
                "44556677",
                "Carlos",
                "Ramos",
                "CMP-12345",
                "ESP-001"
        );

        assertNotNull(doctor);
        assertEquals("44556677", doctor.getDocumento());
        assertEquals("Carlos", doctor.getNombres());
        assertEquals("Ramos", doctor.getApellidos());
        assertEquals("CMP-12345", doctor.getColegiatura());
        assertEquals("ESP-001", doctor.getEspecialidad());
    }

    @Test
    @DisplayName("DOC-006: Verificar los atributos después de construir el objeto")
    void shouldReturnDoctorAttributes() {
        Doctor doctor = new Doctor(
                "11223344",
                "María",
                "Torres",
                "CMP-67890",
                "ESP-002"
        );

        assertEquals("11223344", doctor.getDocumento());
        assertEquals("María", doctor.getNombres());
        assertEquals("Torres", doctor.getApellidos());
        assertEquals("CMP-67890", doctor.getColegiatura());
        assertEquals("ESP-002", doctor.getEspecialidad());
    }

    @Test
    @DisplayName("DOC-002: Rechazar la creación de un doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(null, "Carlos", "Ramos", "CMP-12345", "ESP-001")
        );
    }

    @Test
    @DisplayName("DOC-003: Rechazar la creación de un doctor sin nombres")
    void shouldRejectDoctorWithoutNames() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor("44556677", null, "Ramos", "CMP-12345", "ESP-001")
        );
    }

    @Test
    @DisplayName("DOC-004: Rechazar la creación de un doctor sin apellidos")
    void shouldRejectDoctorWithoutLastNames() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor("44556677", "Carlos", null, "CMP-12345", "ESP-001")
        );
    }

    @Test
    @DisplayName("DOC-005: Rechazar la creación de un doctor sin colegiatura")
    void shouldRejectDoctorWithoutLicense() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor("44556677", "Carlos", "Ramos", null, "ESP-001")
        );
    }

    @Test
    @DisplayName("DOC-007: Rechazar un documento vacío")
    void shouldRejectDoctorWithEmptyDocument() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor("", "Carlos", "Ramos", "CMP-12345", "ESP-001")
        );
    }

    @Test
    @DisplayName("DOC-008: Rechazar nombres vacíos")
    void shouldRejectDoctorWithEmptyNames() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor("44556677", "", "Ramos", "CMP-12345", "ESP-001")
        );
    }

    @Test
    @DisplayName("DOC-008: Rechazar apellidos vacíos")
    void shouldRejectDoctorWithEmptyLastNames() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor("44556677", "Carlos", "", "CMP-12345", "ESP-001")
        );
    }

    @Test
    @DisplayName("DOC-009: Rechazar colegiatura vacía")
    void shouldRejectDoctorWithEmptyLicense() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor("44556677", "Carlos", "Ramos", "", "ESP-001")
        );
    }

    @Test
    @DisplayName("DOC-011: Aceptar un identificador de especialidad vacío")
    void shouldAcceptDoctorWithEmptySpecialty() {
        Doctor doctor = new Doctor("44556677", "Carlos", "Ramos", "CMP-12345", "");

        assertNotNull(doctor);
        assertEquals("", doctor.getEspecialidad());
    }

    @Test
    @DisplayName("DOC-012: Aceptar un identificador de especialidad nulo")
    void shouldAcceptDoctorWithNullSpecialty() {
        Doctor doctor = new Doctor("44556677", "Carlos", "Ramos", "CMP-12345", null);

        assertNotNull(doctor);
        assertNull(doctor.getEspecialidad());
    }
}
