package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoctorTest {

    @Test
    @DisplayName("Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {

        Doctor doctor = new Doctor(
                "246897531",
                "Marcelo",
                "Gonzalez",
                "COPR12345",
                "ESP123"
        );

        assertNotNull(doctor);

        assertEquals("246897531", doctor.getDocumento());
        assertEquals("Marcelo", doctor.getNombres());
        assertEquals("Gonzalez", doctor.getApellidos());
        assertEquals("COPR12345", doctor.getColegiatura());
        assertEquals("ESP123", doctor.getEspecialidad());
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Doctor(
                    null,
                    "Marcelo",
                    "Gonzalez",
                    "COPR12345",
                    "ESP123"
            );
        });
    }


    @Test
    @DisplayName("Rechazar la creación de un doctor sin nombres")
    void shouldRejectDoctorWithoutNames() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Doctor(
                    "246897531",
                    null,
                    "Gonzalez",
                    "COPR12345",
                    "ESP123"
            );
        });
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin apellidos")
    void shouldRejectDoctorWithoutLastNames() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Doctor(
                    "246897531",
                    "Marcelo",
                    null,
                    "COPR12345",
                    "ESP123"
            );
        });
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin colegiatura")
    void shouldRejectDoctorWithoutLicense() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Doctor(
                    "246897531",
                    "Marcelo",
                    "Gonzalez",
                    null,
                    "ESP123"
            );
        });
    }

    @Test
    @DisplayName("Verificar atributos del doctor")
    void shouldReturnCorrectDoctorAttributes(){

        Doctor doctor = new Doctor(
                "135798642",
                "Luisa",
                "Sanchez",
                "COPR6789",
                "ESP456"
        );

        assertEquals("135798642", doctor.getDocumento());
        assertEquals("Luisa", doctor.getNombres());
        assertEquals("Sanchez", doctor.getApellidos());
        assertEquals("COPR6789", doctor.getColegiatura());
        assertEquals("ESP456", doctor.getEspecialidad());

    }

}
