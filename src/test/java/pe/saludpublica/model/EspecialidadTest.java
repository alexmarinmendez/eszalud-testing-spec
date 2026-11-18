package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EspecialidadTest {

    @Test
    @DisplayName("Crear una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {
        Especialidad especialidad = new Especialidad("Cardiología", "Atención del corazón");

        assertNotNull(especialidad);
        assertEquals("Cardiología", especialidad.getNombre());
        assertEquals("Atención del corazón", especialidad.getDescripcion());
    }

    @Test
    @DisplayName("Rechazar la creación de una especialidad sin nombre")
    void shouldRejectSpecialtyWithoutName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Especialidad(null, "Atención del corazón"));
    }

    @Test
    @DisplayName("Verificar los atributos después de construir la especialidad")
    void shouldExposeAllAttributesAfterCreation() {
        Especialidad especialidad = new Especialidad("Pediatría", "Atención de niños");

        assertAll(
                () -> assertEquals("Pediatría", especialidad.getNombre()),
                () -> assertEquals("Atención de niños", especialidad.getDescripcion())
        );
    }

    @Test
    @DisplayName("Rechazar la creación de una especialidad con nombre vacío")
    void shouldRejectSpecialtyWithBlankName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Especialidad("", "Atención del corazón"));
    }

    @Test
    @DisplayName("Rechazar la creación de una especialidad con nombre compuesto solo por espacios")
    void shouldRejectSpecialtyWithWhitespaceOnlyName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Especialidad("   ", "Atención del corazón"));
    }

    @Test
    @DisplayName("Aceptar una especialidad sin descripción")
    void shouldAcceptSpecialtyWithoutDescription() {
        Especialidad especialidad = new Especialidad("Cardiología", null);

        assertNull(especialidad.getDescripcion());
    }

    @Test
    @DisplayName("Aceptar una especialidad con descripción vacía")
    void shouldAcceptSpecialtyWithBlankDescription() {
        Especialidad especialidad = new Especialidad("Cardiología", "");

        assertEquals("", especialidad.getDescripcion());
    }
}
