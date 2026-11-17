package pe.saludpublica.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EspecialidadTest {

    @Test
    @DisplayName("ESP-001: Crear una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {
        Especialidad especialidad = new Especialidad("Cardiología", "Especialidad del corazón");

        assertNotNull(especialidad);
        assertEquals("Cardiología", especialidad.getNombre());
        assertEquals("Especialidad del corazón", especialidad.getDescripcion());
    }
    @Test
    @DisplayName("ESP-002: Rechazar la creación de una especialidad sin nombre")
    void shouldRejectSpecialtyWithoutName() {
        assertThrows(IllegalArgumentException.class,
            () -> new Especialidad(null, "Especialidad del corazón"));
    }
    @Test
    @DisplayName("ESP-003: Verificar los atributos de la especialidad mediante sus getters")
    void shouldReturnAllAttributesThroughGetters() {
        Especialidad especialidad = new Especialidad("Pediatría", "Atención médica infantil");

        assertAll(
            () -> assertEquals("Pediatría", especialidad.getNombre()),
            () -> assertEquals("Atención médica infantil", especialidad.getDescripcion())
        );
    }
}
