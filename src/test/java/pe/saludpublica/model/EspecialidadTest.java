package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EspecialidadTest {


    @Test
    @DisplayName("Crear una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {
        Especialidad esp = new Especialidad(
                "Cardiología",
                "Enfermedades del corazón"
        );

        assertNotNull(esp);
        assertEquals("Cardiología", esp.getNombre());
    }


    @Test
    @DisplayName("Rechazar especialidad sin nombre")
    void shouldRejectSpecialtyWithoutName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Especialidad(null, "Descripción genérica")
        );
    }
}