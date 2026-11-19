package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Pruebas del modelo Especialidad")
class EspecialidadTest {

    // ESP-001
    @Test
    @DisplayName("Crear una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {
        Especialidad especialidad = new Especialidad(
                "Cardiología",
                "Diagnóstico y tratamiento de enfermedades del corazón"
        );

        assertNotNull(especialidad);
        assertEquals("Cardiología", especialidad.getNombre());
        assertEquals("Diagnóstico y tratamiento de enfermedades del corazón",
                especialidad.getDescripcion());
    }

    // ESP-002
    @Test
    @DisplayName("Rechazar la creación de una especialidad sin nombre")
    void shouldRejectSpecialtyWithoutName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Especialidad(
                        null,
                        "Diagnóstico y tratamiento de enfermedades del corazón"
                )
        );
    }
}