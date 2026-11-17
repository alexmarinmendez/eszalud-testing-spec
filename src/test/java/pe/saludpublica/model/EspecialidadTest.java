package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EspecialidadTest {

    @Test
    @DisplayName("ESP-001: Crear especialidad con datos válidos")
    void shouldCreateSpecialityWithValidData() {
        Especialidad especialidad = new Especialidad("Cardiología", "Atención del corazón");

        assertNotNull(especialidad);
        assertEquals("Cardiología", especialidad.getNombre());
        assertEquals("Atención del corazón", especialidad.getDescripcion());
    }

    @Test
    @DisplayName("ESP-002: Rechazar creación sin nombre (null)")
    void shouldRejectSpecialityWithoutName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Especialidad(null, "Atención general")
        );
    }

    @Test
    @DisplayName("ESP-003: Permitir crear especialidad sin descripción (null)")
    void shouldAllowSpecialityWithoutDescription() {
        Especialidad especialidad = new Especialidad("Pediatría", null);

        assertNotNull(especialidad);
        assertEquals("Pediatría", especialidad.getNombre());
        assertNull(especialidad.getDescripcion());
    }
}