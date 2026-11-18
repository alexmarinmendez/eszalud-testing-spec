package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EspecialidadTest {

    @Test
    @DisplayName("ESP-001: Crear una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {
        Especialidad especialidad = new Especialidad(
                "Cardiología",
                "Enfermedades del corazón"
        );

        assertNotNull(especialidad);
        assertEquals("Cardiología", especialidad.getNombre());
        assertEquals("Enfermedades del corazón", especialidad.getDescripcion());
    }

    @Test
    @DisplayName("ESP-002: Rechazar especialidad sin nombre")
    void shouldRejectSpecialtyWithoutName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Especialidad(
                        null,
                        "Enfermedades del corazón"
                )
        );
    }

    @Test
    @DisplayName("ESP-003: Verificar atributos después de construir el objeto")
    void shouldKeepAttributesAfterConstruction() {
        Especialidad especialidad = new Especialidad(
                "Pediatría",
                "Atención infantil"
        );

        assertEquals("Pediatría", especialidad.getNombre());
        assertEquals("Atención infantil", especialidad.getDescripcion());
    }
}