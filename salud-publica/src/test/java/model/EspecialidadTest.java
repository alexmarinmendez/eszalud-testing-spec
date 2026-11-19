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
}
