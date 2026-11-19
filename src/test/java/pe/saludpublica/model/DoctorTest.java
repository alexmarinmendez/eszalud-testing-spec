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

    @Test
    void doc005_throwsExceptionWhenMedicalLicenseIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Doctor(
                        "45678912",
                        "Carlos Eduardo",
                        "Ramírez Torres",
                        null,
                        "Cardiología"
                )
        );
    }

    @Test
    void doc006_returnsValuesThroughGettersAfterConstruction() {
        Doctor doctor = new Doctor(
                "12345678",
                "Lucía Elena",
                "Flores Rojas",
                "CMP-12345",
                "Neurología"
        );

        assertAll(
                () -> assertEquals("12345678", doctor.getDocumento()),
                () -> assertEquals("Lucía Elena", doctor.getNombres()),
                () -> assertEquals("Flores Rojas", doctor.getApellidos()),
                () -> assertEquals("CMP-12345", doctor.getColegiatura()),
                () -> assertEquals("Neurología", doctor.getEspecialidad())
        );
    }
}
