
package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EspecialidadTest {

    @Test
    @DisplayName("ESP-001: Crear especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {

        Especialidad especialidad = new Especialidad(
                "Cardiología",
                "Diagnóstico y tratamiento de enfermedades del corazón"
        );

        assertNotNull(especialidad);
        assertEquals("Cardiología", especialidad.getNombre());
        assertEquals(
                "Diagnóstico y tratamiento de enfermedades del corazón",
                especialidad.getDescripcion()
        );
    }

    @Test
    @DisplayName("ESP-002: Crear especialidad sin nombre")
    void shouldRejectSpecialtyWithoutName() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Especialidad(
                        null,
                        "Diagnóstico y tratamiento de enfermedades del corazón"
                )
        );
    }

    @Test
    @DisplayName("ESP-003: Verificar los atributos de la especialidad")
    void shouldReturnCorrectSpecialtyAttributes() {

        Especialidad especialidad = new Especialidad(
                "Pediatría",
                "Atención médica de niños y adolescentes"
        );

        assertAll(
                () -> assertEquals(
                        "Pediatría",
                        especialidad.getNombre()
                ),
                () -> assertEquals(
                        "Atención médica de niños y adolescentes",
                        especialidad.getDescripcion()
                )
        );
    }

}