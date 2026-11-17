package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EspecialidadTest {
    @Test
    @DisplayName("Crear una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {
        Especialidad especialidad = new Especialidad("Cardiología", "Atención del corazón");

        assertNotNull(especialidad);
        assertEquals("Cardiología", especialidad.getNombre());
        assertEquals("Atención del corazón", especialidad.getDescripcion());
    }
}
