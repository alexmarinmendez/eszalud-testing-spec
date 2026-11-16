package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class EspecialidadTest {
    @Test
    @DisplayName("Crear una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {

        Especialidad especialidad = new Especialidad(
                "Cardiología",
                "Atención de enfermedades del corazón"
        );

        assertNotNull(especialidad);
        assertEquals("Cardiología", especialidad.getNombre());
        assertEquals("Atención de enfermedades del corazón", especialidad.getDescripcion());
    }
    @Test
    @DisplayName("Rechazar la creación de una especialidad sin nombre")
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
    @DisplayName("Verificar los atributos de la especialidad después de construir el objeto")
    void shouldKeepSpecialtyAttributesAfterConstruction() {

        Especialidad especialidad = new Especialidad(
                "Pediatría",
                "Atención médica de niños y adolescentes"
        );

        assertEquals("Pediatría", especialidad.getNombre());
        assertEquals("Atención médica de niños y adolescentes", especialidad.getDescripcion());
    }
}
