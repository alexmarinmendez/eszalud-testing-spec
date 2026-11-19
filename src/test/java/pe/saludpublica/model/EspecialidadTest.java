
package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EspecialidadTest {

    // ESP-001: Crear especialidad con datos válidos
    @Test
    @DisplayName("Crear una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {

        Especialidad especialidad = new Especialidad(
                "Cardiología",
                "Especialista del corazón"
        );

        assertNotNull(especialidad);
        assertEquals("Cardiología", especialidad.getNombre());
        assertEquals("Especialista del corazón", especialidad.getDescripcion());
    }

    // ESP-002: Nombre nulo
    @Test
    @DisplayName("No permitir nombre de especialidad nulo")
    void shouldThrowExceptionWhenNameIsNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Especialidad(
                    null,
                    "Especialista del corazón"
            );
        });
    }

    // ESP-003: Verificar los atributos
    @Test
    @DisplayName("Verificar los atributos de una especialidad")
    void shouldReturnAllSpecialtyAttributes() {

        Especialidad especialidad = new Especialidad(
                "Cardiología",
                "Especialista del corazón"
        );

        assertEquals("Cardiología", especialidad.getNombre());
        assertEquals("Especialista del corazón", especialidad.getDescripcion());
    }
}
