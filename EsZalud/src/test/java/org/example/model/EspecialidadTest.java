package org.example.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EspecialidadTest {

    @Test
    @DisplayName("Crear una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {
        Especialidad especialidad = new Especialidad(
                "Cardiología",
                "Salud cardiovascular"
        );

        assertNotNull(especialidad);
        assertEquals("Cardiología", especialidad.getNombre());
        assertEquals("Salud cardiovascular", especialidad.getDescripcion());
    }

    @Test
    @DisplayName("Rechazar la creación de una especialidad sin nombre")
    void shouldRejectSpecialtyWithoutName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Especialidad(null, "Salud cardiovascular")
        );
    }

    @Test
    @DisplayName("Verificar los atributos después de construir la especialidad")
    void shouldReturnExpectedAttributesAfterConstruction() {
        Especialidad especialidad = new Especialidad(
                "Pediatría",
                "Atención de niños y adolescentes"
        );

        assertEquals("Pediatría", especialidad.getNombre());
        assertEquals("Atención de niños y adolescentes", especialidad.getDescripcion());
    }
}