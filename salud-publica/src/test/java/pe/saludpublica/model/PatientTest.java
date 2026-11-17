package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pe.saludpublica.model.Patient;

import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {

    @Test
    @DisplayName("Crear un paciente con datos válidos")
    void shouldCreatePatientWithValidData() {

        Patient patient = new Patient(
                "12345678",
                "Carlos",
                "Pérez",
                "987654321",
                "carlosperez@gmail.com"
        );

        assertNotNull(patient);
        assertEquals("12345678", patient.getDocument());
        assertEquals("Carlos", patient.getNames());
        assertEquals("Pérez", patient.getSurnames());
        assertEquals("987654321", patient.getPhone());
        assertEquals("carlosperez@gmail.com", patient.getEmail());
    }

    @Test
    @DisplayName("Rechazar la creación de un paciente sin documento")
    void shouldRejectPatientWithoutDocument() {
         assertThrows(IllegalArgumentException.class, () -> {
             new Patient(
                     null,
                     "Carlos",
                     "Pérez",
                     "987654321",
                     "carlosperez@gmail.com"
             );
         });
    }

    @Test
    @DisplayName("Rechazar la creación de un paciente sin nombres")
    void shouldRejectPatientWithoutNames() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Patient(
                    "12345678",
                    null,
                    "Pérez",
                    "987654321",
                    "carlosperez@gmail.com"
            );
        });
    }
}
