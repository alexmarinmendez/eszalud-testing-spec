package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EspecialidadTest {

    @Test
    @DisplayName("Debe crear una especialidad correctamente cuando los datos son válidos")
    void shouldCreateSpecialtyWhenDataIsValid() {
        Especialidad especialidad = new Especialidad(
                "Cardiología",
                "Especialidad dedicada al corazón y aparato circulatorio"
        );

        assertNotNull(especialidad);
        assertEquals("Cardiología", especialidad.getNombre());
        assertEquals("Especialidad dedicada al corazón y aparato circulatorio", especialidad.getDescripcion());
    }
}
