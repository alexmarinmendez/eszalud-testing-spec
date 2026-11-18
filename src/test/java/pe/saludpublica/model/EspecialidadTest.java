package pe.saludpublica.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EspecialidadTest {

    @Test
    void shouldCreateSpecialtyWithValidData() {
        Especialidad especialidad = new Especialidad(
                "Cardiologia",
                "Especialidad del corazón"
        );

        assertNotNull(especialidad);
        assertEquals("Cardiologia", especialidad.getNombre());
        assertEquals("Especialidad del corazón", especialidad.getDescripcion());
    }
}