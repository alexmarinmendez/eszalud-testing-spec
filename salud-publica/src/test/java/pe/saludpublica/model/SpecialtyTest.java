package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("Rechazar la creación de una especialidad sin nombre")
    void shouldRejectSpecialtyWithoutName() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Specialty(
                    null,
                    "Diagnóstico y tratamiento de enfermedades del corazón"
            );
        });
    }
}
