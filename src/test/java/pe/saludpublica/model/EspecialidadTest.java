package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EspecialidadTest {

    @Test
    @DisplayName("Crear una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {

        Especialidad especialidad = new Especialidad(
                "Dermatología",
                "Enfermedades de la piel"
        );

        assertNotNull(especialidad);
        assertEquals("Dermatología", especialidad.getNombre());
        assertEquals("Enfermedades de la piel", especialidad.getDescripcion());
    }
    @Test
    @DisplayName("No permitir crear una especialidad con nombre nulo")
    void shouldThrowExceptionWhenNameIsNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Especialidad(
                    null,
                    "Enfermedades de la piel"
            );
        });
    }
    @Test
    @DisplayName("Obtener correctamente los datos de la especialidad")
    void shouldReturnCorrectSpecialtyData() {

        Especialidad especialidad = new Especialidad(
                "Dermatología",
                "Enfermedades de la piel"
        );

        assertEquals("Dermatología", especialidad.getNombre());
        assertEquals("Enfermedades de la piel", especialidad.getDescripcion());
    }
}
