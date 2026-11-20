package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EspecialidadTest {

    @Test
    @DisplayName("Crear una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {
        Especialidad especialidad = new Especialidad("Cardiología", "Enfermedades del corazón");

        assertNotNull(especialidad);
        assertEquals("Cardiología", especialidad.getNombre());
        assertEquals("Enfermedades del corazón", especialidad.getDescripcion());
    }

    @Test
    @DisplayName("Conservar cada atributo de la especialidad después de construirla")
    void shouldKeepAttributesAfterConstruction() {
        Especialidad especialidad = new Especialidad("Pediatría", "Atención médica de niños");

        assertEquals("Pediatría", especialidad.getNombre());
        assertEquals("Atención médica de niños", especialidad.getDescripcion());
    }

    @Test
    @DisplayName("Rechazar la creación de una especialidad sin nombre")
    void shouldRejectSpecialtyWithoutName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Especialidad(null, "Enfermedades del corazón"));
    }
}