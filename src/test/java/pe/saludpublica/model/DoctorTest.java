package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    @Test
    @DisplayName("Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {
        Doctor doctor = new Doctor("12345678", "Luis", "Gómez", "CMP12345", "esp001");

        assertNotNull(doctor);
        assertEquals("12345678", doctor.getDocumento());
        assertEquals("Luis", doctor.getNombres());
        assertEquals("Gómez", doctor.getApellidos());
        assertEquals("CMP12345", doctor.getColegiatura());
        assertEquals("esp001", doctor.getEspecialidad());
    }

    @Test
    @DisplayName("Conservar cada atributo del doctor después de construirlo")
    void shouldKeepAttributesAfterConstruction() {
        Doctor doctor = new Doctor("87654321", "María Elena", "Torres Ríos", "CMP98765", "esp002");

        assertEquals("87654321", doctor.getDocumento());
        assertEquals("María Elena", doctor.getNombres());
        assertEquals("Torres Ríos", doctor.getApellidos());
        assertEquals("CMP98765", doctor.getColegiatura());
        assertEquals("esp002", doctor.getEspecialidad());
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor(null, "Luis", "Gómez", "CMP12345", "esp001"));
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin nombres")
    void shouldRejectDoctorWithoutFirstName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("12345678", null, "Gómez", "CMP12345", "esp001"));
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin apellidos")
    void shouldRejectDoctorWithoutLastName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("12345678", "Luis", null, "CMP12345", "esp001"));
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin colegiatura")
    void shouldRejectDoctorWithoutLicense() {
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("12345678", "Luis", "Gómez", null, "esp001"));
    }
}