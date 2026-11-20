package pe.salud.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EspecialidadTest {
    @Test
    @DisplayName("Crear una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {
        Especialidad especialidad = new Especialidad(
                "Medicina general",
                "Atención primaria"
        );

        assertNotNull(especialidad);
        assertEquals("Medicina general", especialidad.getNombre());
        assertEquals("Atención primaria", especialidad.getDescripcion());
    }
    @Test
    @DisplayName("Rechazar la creación de una especialidad sin nombre")
    void shouldRejectSpecialtyWithoutName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Especialidad(null, "Atención primaria")
        );
    }
}
