package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SpecialtyTest {

    @Test
    @DisplayName("Crear una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {

        Specialty specialty = new Specialty(
                "Cardiología",
                "Diagnóstico y tratamiento de enfermedades del corazón"
        );

        assertNotNull(specialty);
        assertEquals("Cardiología", specialty.getName());
        assertEquals("Diagnóstico y tratamiento de enfermedades del corazón", specialty.getDescription());
    }
}
