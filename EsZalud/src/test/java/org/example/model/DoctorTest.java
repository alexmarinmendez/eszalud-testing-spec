package org.example.model;

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
                "41234567",
                "Carlos",
                "Ramírez",
                "CMP-12345",
                "Cardiología"
        );

        assertNotNull(doctor);
        assertEquals("41234567", doctor.getDocumento());
        assertEquals("Carlos", doctor.getNombres());
        assertEquals("Ramírez", doctor.getApellidos());
        assertEquals("CMP-12345", doctor.getColegiatura());
        assertEquals("Cardiología", doctor.getEspecialidad());
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(null, "Carlos", "Ramírez", "CMP-12345", "Cardiología")
        );
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin nombres")
    void shouldRejectDoctorWithoutFirstName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor("41234567", null, "Ramírez", "CMP-12345", "Cardiología")
        );
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin apellidos")
    void shouldRejectDoctorWithoutLastName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor("41234567", "Carlos", null, "CMP-12345", "Cardiología")
        );
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin colegiatura")
    void shouldRejectDoctorWithoutLicense() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor("41234567", "Carlos", "Ramírez", null, "Cardiología")
        );
    }

    @Test
    @DisplayName("Verificar los atributos después de construir el doctor")
    void shouldReturnExpectedAttributesAfterConstruction() {
        Doctor doctor = new Doctor(
                "41234567",
                "Carlos",
                "Ramírez",
                "CMP-12345",
                "Pediatría"
        );

        assertEquals("41234567", doctor.getDocumento());
        assertEquals("Carlos", doctor.getNombres());
        assertEquals("Ramírez", doctor.getApellidos());
        assertEquals("CMP-12345", doctor.getColegiatura());
        assertEquals("Pediatría", doctor.getEspecialidad());
    }
}