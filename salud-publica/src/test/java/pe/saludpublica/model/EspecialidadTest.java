package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
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

    // ESP-003
    @Test
    @DisplayName("Verificar que cada atributo conserve su valor después de construir la especialidad")
    void shouldKeepEachAttributeWhenSpecialtyIsCreated() {
        Especialidad especialidad = new Especialidad(
                "Pediatría",
                "Atención médica de bebés, niños y adolescentes"
        );

        assertAll(
                () -> assertEquals("Pediatría", especialidad.getNombre(), "nombre"),
                () -> assertEquals("Atención médica de bebés, niños y adolescentes",
                        especialidad.getDescripcion(), "descripcion")
        );
    }

    // ESP-004 (recomendada)
    @Test
    @DisplayName("Rechazar la creación de una especialidad con nombre vacío")
    void shouldRejectSpecialtyWithEmptyName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Especialidad(
                        "",
                        "Diagnóstico y tratamiento de enfermedades del corazón"
                )
        );
    }

    // ESP-005 (recomendada)
    @Test
    @DisplayName("Rechazar la creación de una especialidad con nombre compuesto solo por espacios")
    void shouldRejectSpecialtyWithBlankName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Especialidad(
                        "   ",
                        "Diagnóstico y tratamiento de enfermedades del corazón"
                )
        );
    }

    // ESP-006 (recomendada, regla documentada en DECISIONES.md)
    @Test
    @DisplayName("Aceptar una especialidad con descripción vacía porque la descripción es opcional")
    void shouldAcceptSpecialtyWithEmptyDescriptionWhenDescriptionIsOptional() {
        Especialidad especialidad = new Especialidad("Dermatología", "");

        assertEquals("", especialidad.getDescripcion());
    }

    // ESP-007 (recomendada, regla documentada en DECISIONES.md)
    @Test
    @DisplayName("Aceptar una especialidad sin descripción porque la descripción es opcional")
    void shouldAcceptSpecialtyWithoutDescriptionWhenDescriptionIsOptional() {
        Especialidad especialidad = new Especialidad("Dermatología", null);

        assertNull(especialidad.getDescripcion());
    }
}