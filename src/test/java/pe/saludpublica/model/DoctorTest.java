package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.print.Doc;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    @Test
    @DisplayName("DOC-001: Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {
        Doctor doctor = new Doctor("12345678", "María", "Rojas", "CMP12345", "CARDIOLOGIA");

        assertNotNull(doctor);
        assertEquals("12345678", doctor.getDocumento());
        assertEquals("María", doctor.getNombres());
        assertEquals("Rojas", doctor.getApellidos());
        assertEquals("CMP12345", doctor.getColegiatura());
        assertEquals("CARDIOLOGIA", doctor.getEspecialidad());
    }

    @Test
    @DisplayName("DOC-002: Rechazar doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        null,
                        "María",
                        "Rojas",
                        "CMP12345",
                        "CARDIOLOGIA"
                )
        );
    }

    @Test
    @DisplayName("DOC-003: Rechazar un doctor sin nombres")
    void shouldRejectDoctorWithoutFirstName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "12345678",
                        null,
                        "Rojas",
                        "CMP12345",
                        "CARDIOLOGIA"

                )
        );
    }

    @Test
    @DisplayName("DOC-004: Rechazar doctor sin apellidos")
    void shouldRejectDoctorWithoutLastName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "12345678",
                        "Maria",
                        null,
                        "CMP12345",
                        "CARDIOLOGIA"

                )
        );
    }

    @Test
    @DisplayName("DOC-005: Rechazar Doctor sin colegiatura")
    void shouldRejectDoctorWithoutLicense() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "12345678",
                        "Maria",
                        "Rojas",
                        null,
                        "CARDIOLOGIA"
                )
        );
    }

    @Test
    @DisplayName("DOC-006: Verificar los Atributos del Doctor")
    void shouldPreserveDoctorAttributesAfterConstruction() {
        Doctor doctor = new Doctor(
                "87654321",
                "Carlos",
                "Ramirez",
                "CMP67890",
                "PEDIATRIA"
        );
        assertEquals("87654321", doctor.getDocumento());
        assertEquals("Carlos",doctor.getNombres());
        assertEquals("Ramirez",doctor.getApellidos());
        assertEquals("CMP67890",doctor.getColegiatura());
        assertEquals("PEDIATRIA",doctor.getEspecialidad());
    }

}
