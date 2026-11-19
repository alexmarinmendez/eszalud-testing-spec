package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pe.saludpublica.model.Doctor;

import static org.junit.jupiter.api.Assertions.*;

public class DoctorTest {

    @Test
    @DisplayName("Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {
        Doctor doctor = new Doctor("12345678", "Carlos", "Mendoza", "CMP-12345", "ESP-01");

        assertNotNull(doctor);
        assertEquals("12345678", doctor.getDocumento());
        assertEquals("Carlos", doctor.getNombres());
        assertEquals("Mendoza", doctor.getApellidos());
        assertEquals("CMP-12345", doctor.getColegiatura());
        assertEquals("ESP-01", doctor.getEspecialidad());
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor(null, "Carlos", "Mendoza", "CMP-12345", "ESP-01"));
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("   ", "Carlos", "Mendoza", "CMP-12345", "ESP-01"));
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin nombres")
    void shouldRejectDoctorWithoutFirstName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("12345678", null, "Mendoza", "CMP-12345", "ESP-01"));
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("12345678", "   ", "Mendoza", "CMP-12345", "ESP-01"));
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin apellidos")
    void shouldRejectDoctorWithoutLastName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("12345678", "Carlos", null, "CMP-12345", "ESP-01"));
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("12345678", "Carlos", "   ", "CMP-12345", "ESP-01"));
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin colegiatura")
    void shouldRejectDoctorWithoutLicense() {
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("12345678", "Carlos", "Mendoza", null, "ESP-01"));
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("12345678", "Carlos", "Mendoza", "   ", "ESP-01"));
    }

    @Test
    @DisplayName("Conservar cada atributo del doctor después de construir el objeto")
    void shouldKeepEachAttributeAfterConstruction() {
        Doctor doctor = new Doctor("87654321", "Elena", "Ríos", "CMP-67890", "ESP-02");

        assertEquals("87654321", doctor.getDocumento());
        assertEquals("Elena", doctor.getNombres());
        assertEquals("Ríos", doctor.getApellidos());
        assertEquals("CMP-67890", doctor.getColegiatura());
        assertEquals("ESP-02", doctor.getEspecialidad());
    }
}
