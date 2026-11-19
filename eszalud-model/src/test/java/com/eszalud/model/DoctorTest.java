package com.eszalud.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DoctorTest {

    @Test
    @DisplayName("DOC-001: Crear doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {

        Doctor doctor = new Doctor(
                "12345678",
                "Carlos",
                "Ramírez",
                "CMP12345"
        );

        assertNotNull(doctor);
        assertEquals("12345678", doctor.getDocumento());
        assertEquals("Carlos", doctor.getNombres());
        assertEquals("Ramírez", doctor.getApellidos());
        assertEquals("CMP12345", doctor.getColegiatura());


    }

    @Test
    @DisplayName("DOC-002: Crear doctor sin documento")
    void shouldRejectDoctorWithNullDocument() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Doctor(
                    null,
                    "Carlos",
                    "Ramírez",
                    "CMP12345"
            );
        });
    }

    @Test
    @DisplayName("DOC-003: Crear doctor sin nombres")
    void shouldRejectDoctorWithNullNames() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Doctor(
                    "12345678",
                    null,
                    "Ramírez",
                    "CMP12345"
            );
        });
    }

    @Test
    @DisplayName("DOC-004: Crear doctor sin apellidos")
    void shouldRejectDoctorWithNullLastNames() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Doctor(
                    "12345678",
                    "Carlos",
                    null,
                    "CMP12345"
            );
        });
    }


    @Test
    @DisplayName("DOC-005: Crear doctor sin colegiatura")
    void shouldRejectDoctorWithNullColegiatura() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Doctor(
                    "12345678",
                    "Carlos",
                    "Ramírez",
                    null
            );
        });
    }

    @Test
    @DisplayName("DOC-006: Verificar atributos del doctor")
    void shouldReturnCorrectDoctorAttributes() {

        Doctor doctor = new Doctor(
                "87654321",
                "Luis",
                "García",
                "CMP98765"
        );

        assertAll(
                () -> assertEquals("87654321", doctor.getDocumento()),
                () -> assertEquals("Luis", doctor.getNombres()),
                () -> assertEquals("García", doctor.getApellidos()),
                () -> assertEquals("CMP98765", doctor.getColegiatura())
        );
    }





}
