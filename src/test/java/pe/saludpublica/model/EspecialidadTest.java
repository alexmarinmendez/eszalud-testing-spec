package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EspecialidadTest {

    @Test
    @DisplayName("ESP-001: Crear especialidad con datos válidos")
    void shouldCreateSpecialityWithValidData() {
        Especialidad especialidad = new Especialidad(
                "Cardiologia",
                "Especialidad medica del corazon"
        );
        assertNotNull(especialidad);
        assertEquals("Cardiologia", especialidad.getNombre());
        assertEquals("Especialidad medica del corazon", especialidad.getDescripcion());

    }

    @Test
    @DisplayName("ESP-002: Rechazar especialidad sin nombre")
    void shouldRejectSpecialityWithoutName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Especialidad(
                        null,
                        "Especialidad medica del corazon"
                )
        );
    }

    @Test
    @DisplayName("ESP-003: Verificar los atributos de la Especialidad")
    void shouldPreserveSpecialtyAttributesAfterConstruction() {
        Especialidad especialidad = new Especialidad(
                "Neurologia",
                "Especialidad medica del sistema nervioso"
        );
        assertEquals("Neurologia", especialidad.getNombre());
        assertEquals("Especialidad medica del sistema nervioso", especialidad.getDescripcion());
    }
}
