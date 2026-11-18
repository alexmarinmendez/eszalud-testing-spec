package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EspecialidadTest {

    @Test
    @DisplayName("Crear una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {
        Especialidad especialidad = new Especialidad("Cardiología",
                "Diagnóstico y tratamiento de enfermedades del corazón");

        assertEquals("Cardiología", especialidad.getNombre());
        assertEquals("Diagnóstico y tratamiento de enfermedades del corazón",
                especialidad.getDescripcion());
    }
    @Test
    @DisplayName("Rechazar la creación de una especialidad sin nombre")
    void shouldRejectSpecialtyWithoutName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Especialidad(null, "Descripción de prueba"));
    }

    @Test
    @DisplayName("Verificar los atributos de la especialidad después de construirla")
    void shouldReturnAllSpecialtyAttributesAfterConstruction() {
        Especialidad especialidad = new Especialidad("Pediatría",
                "Atención médica de niños y adolescentes");

        assertEquals("Pediatría", especialidad.getNombre());
        assertEquals("Atención médica de niños y adolescentes",
                especialidad.getDescripcion());
    }
}