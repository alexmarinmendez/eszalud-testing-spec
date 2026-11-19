package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pe.saludpublica.model.Especialidad;
import static org.junit.jupiter.api.Assertions.*;


public class EspecialidadTest {

    @Test
    @DisplayName("Crear una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {
        Especialidad especialidad = new Especialidad("Cardiología", "Atención del sistema cardiovascular");

        assertNotNull(especialidad);
        assertEquals("Cardiología", especialidad.getNombre());
        assertEquals("Atención del sistema cardiovascular", especialidad.getDescripcion());
    }

    @Test
    @DisplayName("Rechazar la creación de una especialidad sin nombre")
    void shouldRejectSpecialtyWithoutName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Especialidad(null, "Atención del sistema cardiovascular"));
        assertThrows(IllegalArgumentException.class,
                () -> new Especialidad("   ", "Atención del sistema cardiovascular"));
    }

    @Test
    @DisplayName("Conservar cada atributo de la especialidad después de construir el objeto")
    void shouldKeepEachAttributeAfterConstruction() {
        Especialidad especialidad = new Especialidad("Pediatría", "Atención médica infantil");

        assertEquals("Pediatría", especialidad.getNombre());
        assertEquals("Atención médica infantil", especialidad.getDescripcion());
    }

    @Test
    @DisplayName("Permitir crear una especialidad con descripción opcional")
    void shouldAllowSpecialtyWithOptionalDescription() {
        Especialidad especialidad = new Especialidad("Dermatología", null);

        assertEquals("Dermatología", especialidad.getNombre());
        assertNull(especialidad.getDescripcion());
    }
}
