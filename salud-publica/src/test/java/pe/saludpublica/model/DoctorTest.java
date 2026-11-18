package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoctorTest {

    @Test
    @DisplayName("DOC-001: Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {
        Doctor d = new Doctor("40123456", "Carlos", "Mendoza",
                "CMP-12345", "esp-001");
        assertNotNull(d);
        assertEquals("40123456", d.getDocumento());
        assertEquals("Carlos", d.getNombres());
        assertEquals("Mendoza", d.getApellidos());
        assertEquals("CMP-12345", d.getColegiatura());
        assertEquals("esp-001", d.getEspecialidad());
    }

    @Test
    @DisplayName("DOC-002: Rechazar doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {
        assertThrows(IllegalArgumentException.class, () ->
                new Doctor(null, "Carlos", "Mendoza", "CMP-12345", "esp-001"));
    }

    @Test
    @DisplayName("DOC-003: Rechazar doctor sin nombres")
    void shouldRejectDoctorWithoutFirstName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Doctor("40123456", null, "Mendoza", "CMP-12345", "esp-001"));
    }

    @Test
    @DisplayName("DOC-004: Rechazar doctor sin apellidos")
    void shouldRejectDoctorWithoutLastName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Doctor("40123456", "Carlos", null, "CMP-12345", "esp-001"));
    }

    @Test
    @DisplayName("DOC-005: Rechazar doctor sin colegiatura")
    void shouldRejectDoctorWithoutLicense() {
        assertThrows(IllegalArgumentException.class, () ->
                new Doctor("40123456", "Carlos", "Mendoza", null, "esp-001"));
    }

    @Test
    @DisplayName("DOC-006: Verificar atributos tras construir el objeto")
    void shouldKeepDoctorAttributesAfterConstruction() {
        Doctor d = new Doctor("41234567", "Rosa", "Quispe",
                "CMP-67890", "esp-002");
        assertEquals("41234567", d.getDocumento());
        assertEquals("Rosa", d.getNombres());
        assertEquals("Quispe", d.getApellidos());
        assertEquals("CMP-67890", d.getColegiatura());
        assertEquals("esp-002", d.getEspecialidad());
    }

}
