package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

}
