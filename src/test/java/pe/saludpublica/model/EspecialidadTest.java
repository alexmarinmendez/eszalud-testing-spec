package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas del modelo Especialidad")
class EspecialidadTest {

    @Test
    @DisplayName("Crear una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {
        Especialidad especialidad = new Especialidad("Cardiología", "Atención de enfermedades del corazón");

        assertNotNull(especialidad);
        assertEquals("Cardiología", especialidad.getNombre());
        assertEquals("Atención de enfermedades del corazón", especialidad.getDescripcion());
    }

    @Test
    @DisplayName("Rechazar la creación de una especialidad sin nombre")
    void shouldRejectSpecialtyWithoutName() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Especialidad(null, "Atención de enfermedades del corazón")
        );
    }

    @Test
    @DisplayName("Verificar los atributos después de construir la especialidad")
    void shouldKeepAttributesAfterCreation() {
        Especialidad especialidad = new Especialidad("Pediatría", "Atención médica de niños");

        assertAll(
            () -> assertEquals("Pediatría", especialidad.getNombre()),
            () -> assertEquals("Atención médica de niños", especialidad.getDescripcion())
        );
    }
}
