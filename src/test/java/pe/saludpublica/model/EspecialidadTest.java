package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EspecialidadTest {

    @Test
    @DisplayName("Crear una especialidad con datos válidos")
    void shouldCreateEspecialidadWithValidData() {
        Especialidad especialidad = new Especialidad(
                "ESP01",
                "Cardiología"
        );

        assertNotNull(especialidad);
        assertEquals("ESP01", especialidad.getCodigo());
        assertEquals("Cardiología", especialidad.getNombre());
    }

    @Test
    @DisplayName("Rechazar la creación de una especialidad sin nombre")
    void shouldRejectEspecialidadWithoutNombre() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Especialidad(
                        "ESP01",
                        null
                )
        );
    }
    @Test
    @DisplayName("Verificar los atributos después de construir el objeto")
    void shouldVerifyAttributesAfterConstruction() {
        Especialidad especialidad = new Especialidad(
                "ESP01",
                "Cardiología"
        );

        assertNotNull(especialidad);
        assertEquals("ESP01", especialidad.getCodigo());
        assertEquals("Cardiología", especialidad.getNombre());
    }
}
