package pe.saludpublica.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EspecialidadTest {
    @Test
    void testValidSpecialtyCreation() {
        Especialidad especialidad = new Especialidad("ESP01", "Neumologia");

        assertEquals("ESP01", especialidad.getCodigo());
        assertEquals("Neumologia", especialidad.getNombre());
    }
    @Test
    void testRequiredNameValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Especialidad("ESP01", null);
        });
    }
}
