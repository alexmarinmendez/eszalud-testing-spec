package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    @DisplayName("Debe lanzar IllegalArgumentException cuando el nombre es nulo")
    void shouldRejectSpecialtyWhenNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Especialidad(
                null,
                "Especialidad sin nombre"
        ));
    }
}
