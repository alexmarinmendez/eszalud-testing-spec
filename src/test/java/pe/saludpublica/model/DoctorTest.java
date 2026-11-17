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
}
