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
                "12345678", "Carlos", "Pérez", "CMP12345", "especialidad-1");

        assertNotNull(doctor);
        assertEquals("12345678", doctor.getDocumento());
        assertEquals("Carlos", doctor.getNombres());
        assertEquals("Pérez", doctor.getApellidos());
        assertEquals("CMP12345", doctor.getColegiatura());
        assertEquals("especialidad-1", doctor.getEspecialidad());
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {
        assertThrows(IllegalArgumentException.class, () -> new Doctor(
                null, "Carlos", "Pérez", "CMP12345", "especialidad-1"));
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin nombres")
    void shouldRejectDoctorWithoutFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Doctor(
                "12345678", null, "Pérez", "CMP12345", "especialidad-1"));
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin apellidos")
    void shouldRejectDoctorWithoutLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Doctor(
                "12345678", "Carlos", null, "CMP12345", "especialidad-1"));
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin colegiatura")
    void shouldRejectDoctorWithoutLicense() {
        assertThrows(IllegalArgumentException.class, () -> new Doctor(
                "12345678", "Carlos", "Pérez", null, "especialidad-1"));
    }

    @Test
    @DisplayName("Conservar los atributos de un doctor después de construirlo")
    void shouldReturnDoctorAttributesAfterConstruction() {
        Doctor doctor = new Doctor(
                "87654321", "Lucía", "Gómez", "CMP54321", "especialidad-2");

        assertEquals("87654321", doctor.getDocumento());
        assertEquals("Lucía", doctor.getNombres());
        assertEquals("Gómez", doctor.getApellidos());
        assertEquals("CMP54321", doctor.getColegiatura());
        assertEquals("especialidad-2", doctor.getEspecialidad());
    }
}
