package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    @Test
    @DisplayName("Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {

        Doctor doctor = new Doctor(
                "73891245",
                "Miguel Ángel",
                "Gonzales Chávez",
                "CMP 089321",
                "6af71da3501cca046a166045"
        );

        assertNotNull(doctor);
        assertEquals("73891245", doctor.getDocumento());
        assertEquals("Miguel Ángel", doctor.getNombres());
        assertEquals("Gonzales Chávez", doctor.getApellidos());
        assertEquals("CMP 089321", doctor.getColegiatura());
        assertEquals("6af71da3501cca046a166045", doctor.getEspecialidad());
    }

    @Test
    @DisplayName("No permitir crear un doctor con documento nulo")
    void shouldThrowExceptionWhenDocumentIsNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Doctor(
                    null,
                    "Miguel Ángel",
                    "Gonzales Chávez",
                    "CMP 089321",
                    "6af71da3501cca046a166045"
            );
        });
    }
    @Test
    @DisplayName("No permitir crear un doctor con nombres nulos")
    void shouldThrowExceptionWhenNamesAreNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Doctor(
                    "73891245",
                    null,
                    "Gonzales Chávez",
                    "CMP 089321",
                    "6af71da3501cca046a166045"
            );
        });
    }
    @Test
    @DisplayName("No permitir crear un doctor con apellidos nulos")
    void shouldThrowExceptionWhenLastNamesAreNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Doctor(
                    "73891245",
                    "Miguel Ángel",
                    null,
                    "CMP 089321",
                    "6af71da3501cca046a166045"
            );
        });
    }
    @Test
    @DisplayName("No permitir crear un doctor con colegiatura nula")
    void shouldThrowExceptionWhenTuitionIsNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Doctor(
                    "73891245",
                    "Miguel Ángel",
                    "Gonzales Chávez",
                    null,
                    "6af71da3501cca046a166045"
            );
        });
    }
    @Test
    @DisplayName("Obtener correctamente los datos del doctor")
    void shouldReturnCorrectDoctorData() {

        Doctor doctor = new Doctor(
                "73891245",
                "Miguel Ángel",
                "Gonzales Chávez",
                "CMP 089321",
                "6af71da3501cca046a166045"
        );

        assertEquals("73891245", doctor.getDocumento());
        assertEquals("Miguel Ángel", doctor.getNombres());
        assertEquals("Gonzales Chávez", doctor.getApellidos());
        assertEquals("CMP 089321", doctor.getColegiatura());
        assertEquals("6af71da3501cca046a166045", doctor.getEspecialidad());
    }
}