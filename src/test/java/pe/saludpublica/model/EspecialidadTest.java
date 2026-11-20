package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EspecialidadTest {

    @Test
    @DisplayName("Crear una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {
        Especialidad especialidad = new Especialidad(
                "Cardiología",
                "Salud cardiovascular"
        );

        assertNotNull(especialidad);
        assertEquals("Cardiología", especialidad.getNombre());
        assertEquals("Salud cardiovascular", especialidad.getDescripcion());
    }

    @Test
    @DisplayName("Permitir descripción nula o en blanco")
    void shouldAllowOptionalDescriptionWhenNullOrBlank() {
        Especialidad conNull = new Especialidad("Pediatría", null);
        Especialidad conEspacios = new Especialidad("Dermatología", "   ");

        assertEquals("Pediatría", conNull.getNombre());
        assertNull(conNull.getDescripcion());

        assertEquals("Dermatología", conEspacios.getNombre());
        assertEquals("   ", conEspacios.getDescripcion());
    }

    @Test
    @DisplayName("Rechazar la creación de una especialidad sin nombre")
    void shouldRejectSpecialtyWithoutName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Especialidad(null, "Atención primaria")
        );
        assertThrows(IllegalArgumentException.class, () ->
                new Especialidad("", "Atención primaria")
        );
        assertThrows(IllegalArgumentException.class, () ->
                new Especialidad("   ", "Atención primaria")
        );
    }
}