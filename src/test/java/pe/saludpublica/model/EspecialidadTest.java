package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EspecialidadTest {

    @Test
    @DisplayName("ESP-001: Crear una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {
        Especialidad especialidad = new Especialidad(
                "Cardiología",
                "Especialidad del corazón"
        );

        assertNotNull(especialidad);
        assertEquals("Cardiología", especialidad.getNombre());
        assertEquals("Especialidad del corazón", especialidad.getDescripcion());
    }

    @Test
    @DisplayName("ESP-003: Verificar los atributos después de construir el objeto")
    void shouldReturnSpecialtyAttributes() {
        Especialidad especialidad = new Especialidad(
                "Pediatría",
                "Atención médica infantil"
        );

        assertEquals("Pediatría", especialidad.getNombre());
        assertEquals("Atención médica infantil", especialidad.getDescripcion());
    }

    @Test
    @DisplayName("ESP-002: Rechazar la creación de una especialidad sin nombre")
    void shouldRejectSpecialtyWithoutName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Especialidad(null, "Especialidad sin nombre")
        );
    }

    @Test
    @DisplayName("ESP-004: Rechazar un nombre vacío")
    void shouldRejectSpecialtyWithEmptyName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Especialidad("", "Especialidad sin nombre")
        );
    }

    @Test
    @DisplayName("ESP-005: Rechazar un nombre compuesto solo por espacios")
    void shouldRejectSpecialtyWithBlankName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Especialidad("   ", "Especialidad sin nombre")
        );
    }

    @Test
    @DisplayName("ESP-006: Aceptar una descripción vacía")
    void shouldAcceptSpecialtyWithEmptyDescription() {
        Especialidad especialidad = new Especialidad("Cardiología", "");

        assertNotNull(especialidad);
        assertEquals("", especialidad.getDescripcion());
    }

    @Test
    @DisplayName("ESP-007: Aceptar una descripción nula")
    void shouldAcceptSpecialtyWithNullDescription() {
        Especialidad especialidad = new Especialidad("Cardiología", null);

        assertNotNull(especialidad);
        assertNull(especialidad.getDescripcion());
    }
}
