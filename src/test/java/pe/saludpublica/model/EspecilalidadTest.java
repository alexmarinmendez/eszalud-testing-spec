package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EspecilalidadTest {

    @Test
    @DisplayName("Crear una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {

        Especialidad especialidad = new Especialidad(
                "Cardiología",
                "Especialidad médica del corazón"
        );

        assertEquals("Cardiología", especialidad.getNombre());
        assertEquals("Especialidad médica del corazón", especialidad.getDescripcion());
    }

    @Test
    @DisplayName("Rechazar especialidad con nombre nulo")
    void shouldThrowExceptionWhenNameIsNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Especialidad(null, "Especialidad médica del corazón");
        });
    }
}
