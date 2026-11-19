package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EspecialidadTest {

    @Test
    @DisplayName("Crear una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {
        Especialidad especialidad = new Especialidad("Cardiología", "Enfermedades del corazón");
        assertNotNull(especialidad);
        assertEquals("Cardiología", especialidad.getNombre());
        assertEquals("Enfermedades del corazón", especialidad.getDescripcion());
    }

    @Test
    @DisplayName("Conservar los atributos después de construir la especialidad")
    void shouldKeepAttributesAfterConstruction() {
        Especialidad especialidad = new Especialidad("Pediatría", "Atención de niños");
        assertEquals("Pediatría", especialidad.getNombre());
        assertEquals("Atención de niños", especialidad.getDescripcion());
    }
}