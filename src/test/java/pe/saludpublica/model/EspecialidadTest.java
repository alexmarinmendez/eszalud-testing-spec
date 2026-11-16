
package pe.saludpublica.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class EspecialidadTest {

    @Test
    @DisplayName("ESP-001: Crear especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {

        Especialidad especialidad = new Especialidad(
                "Cardiología",
                "Atención de enfermedades del corazón"
        );

        assertNotNull(especialidad);
        assertEquals("Cardiología", especialidad.getNombre());
        assertEquals(
                "Atención de enfermedades del corazón",
                especialidad.getDescripcion()
        );
    }


    @Test
    @DisplayName("ESP-002: Rechazar especialidad sin nombre")
    void shouldRejectSpecialtyWithoutName() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Especialidad(
                        null,
                        "Atención de enfermedades del corazón"
                )
        );
    }

    @Test
    @DisplayName("ESP-003: Verificar los atributos de la especialidad")
    void shouldPreserveSpecialtyAttributesAfterConstruction() {

        Especialidad especialidad = new Especialidad(
                "Pediatría",
                "Atención médica de niños y adolescentes"
        );

        assertNotNull(especialidad);

        assertEquals(
                "Pediatría",
                especialidad.getNombre()
        );

        assertEquals(
                "Atención médica de niños y adolescentes",
                especialidad.getDescripcion()
        );
    }

}
