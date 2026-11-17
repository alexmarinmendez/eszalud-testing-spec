package pe.saludpublica.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class EspecialidadTest {

    @Test
    @DisplayName("Crear una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {
        Especialidad especialidad = new Especialidad("ESP01", "Cardiología");

        assertNotNull(especialidad);
        assertEquals("ESP01", especialidad.getCodigo());
        assertEquals("Cardiología", especialidad.getNombre());
    }
    @Test
    @DisplayName("Rechazar la creación de una especialidad sin nombre")
    void shouldRejectSpecialtyWithoutName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Especialidad("ESP01", null)
        );
    }
    @Test
    @DisplayName("ESP-004 y ESP-005: Rechazar nombre vacío o con espacios")
    void shouldRejectEmptyName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Especialidad("ESP01", ""));
        assertThrows(IllegalArgumentException.class,
                () -> new Especialidad("ESP01", "   "));
    }

    @Test
    @DisplayName("ESP-006 y ESP-007: Aceptar descripción nula o vacía (opcional)")
    void shouldAcceptNullOrEmptyDescription() {
        // Probamos un nuevo constructor que acepta 3 parámetros
        Especialidad esp1 = new Especialidad("ESP01", "Cardiología", null);
        Especialidad esp2 = new Especialidad("ESP01", "Neurología", "");

        assertNull(esp1.getDescripcion());
        assertEquals("", esp2.getDescripcion());
    }
}