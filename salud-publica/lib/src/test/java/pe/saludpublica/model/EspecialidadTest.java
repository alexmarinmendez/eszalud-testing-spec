package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EspecialidadTest {

    // ESP-001: Crear especialidad válida
    @Test
    @DisplayName("Crear especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {

        Especialidad especialidad = new Especialidad(
                "Cardiología",
                "Salud cardiovascular"
        );

        assertNotNull(especialidad);

        assertAll(
                () -> assertEquals("Cardiología", especialidad.getNombre()),
                () -> assertEquals("Salud cardiovascular", especialidad.getDescripcion())
        );
    }

    // ESP-002: Nombre null
    @Test
    @DisplayName("Rechazar especialidad sin nombre")
    void shouldRejectSpecialtyWithoutName() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Especialidad(null, "Salud cardiovascular")
        );
    }

    // ESP-003: Verificar atributos
    @Test
    @DisplayName("Verificar atributos después de construir especialidad")
    void shouldReturnCorrectValuesAfterSpecialtyCreation() {

        Especialidad especialidad = new Especialidad(
                "Pediatría",
                "Atención de niños y adolescentes"
        );

        assertAll(
                () -> assertEquals("Pediatría", especialidad.getNombre()),
                () -> assertEquals(
                        "Atención de niños y adolescentes",
                        especialidad.getDescripcion()
                )
        );
    }
}
