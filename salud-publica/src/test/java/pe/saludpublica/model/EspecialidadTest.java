package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EspecialidadTest {

    @Test
    @DisplayName("Construir una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {
        Especialidad especialidad = new Especialidad(
                "Medicina General",
                "Atencion Primaria"
        );

        assertNotNull(especialidad);
        assertEquals("Medicina General", especialidad.getNombre());
        assertEquals("Atencion Primaria", especialidad.getDescripcion());
    }

    @Test
    @DisplayName("Rechazar la creacion de una especialidad")
    void shouldRejectSpecialtyWithoutName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Especialidad(
                        null,
                        "Atención Primaria"
                )
        );
    }

}
