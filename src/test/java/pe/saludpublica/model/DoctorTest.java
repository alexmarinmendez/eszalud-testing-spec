package pe.saludpublica.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DoctorTest {

    @Test
    void doc001_createsDoctorWithValidData() {
        Doctor doctor = new Doctor(
                "45678912",
                "Carlos Eduardo",
                "Ramírez Torres",
                "CMP-45678",
                "Cardiología"
        );

        assertNotNull(doctor);
        assertAll(
                () -> assertEquals("45678912", doctor.getDocumento()),
                () -> assertEquals("Carlos Eduardo", doctor.getNombres()),
                () -> assertEquals("Ramírez Torres", doctor.getApellidos()),
                () -> assertEquals("CMP-45678", doctor.getColegiatura()),
                () -> assertEquals("Cardiología", doctor.getEspecialidad())
        );
    }

    @Test
    void doc002_throwsExceptionWhenDocumentIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Doctor(
                        null,
                        "Carlos Eduardo",
                        "Ramírez Torres",
                        "CMP-45678",
                        "Cardiología"
                )
        );
    }

    @Test
    void doc003_throwsExceptionWhenNamesAreNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Doctor(
                        "45678912",
                        null,
                        "Ramírez Torres",
                        "CMP-45678",
                        "Cardiología"
                )
        );
    }

    @Test
    void doc004_throwsExceptionWhenLastNamesAreNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Doctor(
                        "45678912",
                        "Carlos Eduardo",
                        null,
                        "CMP-45678",
                        "Cardiología"
                )
        );
    }
}
