package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PatientTest {

    @Test
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
}
