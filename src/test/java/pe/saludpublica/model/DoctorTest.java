
package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    // DOC-001
    @Test
    @DisplayName("Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {

        Especialidad especialidad = new Especialidad(
                "Cardiología", "Especialista del corazón"
        );

        Doctor doctor = new Doctor(
                "12345678", "Carlos", "Ramírez",
                "CMP12345", especialidad
        );

        assertNotNull(doctor);
        assertEquals("12345678", doctor.getDocumento());
        assertEquals("Carlos", doctor.getNombres());
        assertEquals("Ramírez", doctor.getApellidos());
        assertEquals("CMP12345", doctor.getNumeroColegiatura());
        assertEquals(especialidad, doctor.getEspecialidad());
    }

    // DOC-002
    @Test
    @DisplayName("No permitir documento nulo")
    void shouldThrowExceptionWhenDocumentIsNull() {

        Especialidad especialidad = new Especialidad(
                "Cardiología", "Especialista del corazón"
        );

        assertThrows(IllegalArgumentException.class, () -> {
            new Doctor(null, "Carlos", "Ramírez",
                    "CMP12345", especialidad);
        });
    }

    // DOC-003
    @Test
    @DisplayName("No permitir nombres nulos")
    void shouldThrowExceptionWhenNamesAreNull() {

        Especialidad especialidad = new Especialidad(
                "Cardiología", "Especialista del corazón"
        );

        assertThrows(IllegalArgumentException.class, () -> {
            new Doctor("12345678", null, "Ramírez",
                    "CMP12345", especialidad);
        });
    }

    // DOC-004
    @Test
    @DisplayName("No permitir apellidos nulos")
    void shouldThrowExceptionWhenLastNamesAreNull() {

        Especialidad especialidad = new Especialidad(
                "Cardiología", "Especialista del corazón"
        );

        assertThrows(IllegalArgumentException.class, () -> {
            new Doctor("12345678", "Carlos", null,
                    "CMP12345", especialidad);
        });
    }

    // DOC-005
    @Test
    @DisplayName("No permitir colegiatura nula")
    void shouldThrowExceptionWhenRegistrationIsNull() {

        Especialidad especialidad = new Especialidad(
                "Cardiología", "Especialista del corazón"
        );

        assertThrows(IllegalArgumentException.class, () -> {
            new Doctor("12345678", "Carlos", "Ramírez",
                    null, especialidad);
        });
    }

    // DOC-006
    @Test
    @DisplayName("Verificar todos los atributos del doctor")
    void shouldVerifyAllDoctorAttributes() {

        Especialidad especialidad = new Especialidad(
                "Cardiología", "Especialista del corazón"
        );

        Doctor doctor = new Doctor(
                "12345678", "Carlos", "Ramírez",
                "CMP12345", especialidad
        );

        assertEquals("12345678", doctor.getDocumento());
        assertEquals("Carlos", doctor.getNombres());
        assertEquals("Ramírez", doctor.getApellidos());
        assertEquals("CMP12345", doctor.getNumeroColegiatura());
        assertEquals(especialidad, doctor.getEspecialidad());
    }
}
