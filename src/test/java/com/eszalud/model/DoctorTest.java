
package com.eszalud.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    @Test
    @DisplayName("Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {

        Doctor doctor = new Doctor(
                "87654321",
                "Luis",
                "García",
                "CMP12345",
                "CARD001"
        );

        assertNotNull(doctor);
        assertEquals("87654321", doctor.getDocumento());
        assertEquals("Luis", doctor.getNombres());
        assertEquals("García", doctor.getApellidos());
        assertEquals("CMP12345", doctor.getColegiatura());
        assertEquals("CARD001", doctor.getEspecialidad());
    }

    //2

    @Test
    @DisplayName("Rechazar doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        null,
                        "Luis",
                        "García",
                        "CMP12345",
                        "CARD001"
                )
        );
    }



    @Test
    @DisplayName("Rechazar doctor sin nombres")
    void shouldRejectDoctorWithoutFirstName() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "87654321",
                        null,
                        "García",
                        "CMP12345",
                        "CARD001"
                )
        );
    }



    @Test
    @DisplayName("Rechazar doctor sin apellidos")
    void shouldRejectDoctorWithoutLastName() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "87654321",
                        "Luis",
                        null,
                        "CMP12345",
                        "CARD001"
                )
        );
    }



    @Test
    @DisplayName("Rechazar doctor sin colegiatura")
    void shouldRejectDoctorWithoutLicense() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "87654321",
                        "Luis",
                        "García",
                        null,
                        "CARD001"
                )
        );
    }

    @Test
    @DisplayName("Verificar los atributos del doctor")
    void shouldReturnCorrectDoctorAttributes() {
        Doctor doctor = new Doctor(
                "87654321", "Luis", "García", "CMP12345", "CARD001"
        );

        assertAll(
                () -> assertEquals("87654321", doctor.getDocumento()),
                () -> assertEquals("Luis", doctor.getNombres()),
                () -> assertEquals("García", doctor.getApellidos()),
                () -> assertEquals("CMP12345", doctor.getColegiatura()),
                () -> assertEquals("CARD001", doctor.getEspecialidad())
        );
    }

}