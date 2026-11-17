package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EspecialidadTest {

    @Test
    @DisplayName("Crear una especialidad con datos válidos")
    void shouldCreateEspecialidadWithValidData() {
        Especialidad especialidad = new Especialidad(
                "ESP01",
                "Cardiología"
        );

        assertNotNull(especialidad);
        assertEquals("ESP01", especialidad.getCodigo());
        assertEquals("Cardiología", especialidad.getNombre());
    }
}
