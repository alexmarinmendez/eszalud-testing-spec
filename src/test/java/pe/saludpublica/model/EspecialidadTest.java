package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EspecialidadTest {

    @Test
    @DisplayName("ESP-001: Crear especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {
        Especialidad esp = new Especialidad("Cardiología", "Especialidad del corazón y sistema circulatorio");
        assertNotNull(esp, "La especialidad debe crearse");
        assertEquals("Cardiología", esp.getNombre());
        assertEquals("Especialidad del corazón y sistema circulatorio", esp.getDescripcion());
    }

    @Test
    @DisplayName("ESP-002: Rechazar especialidad sin nombre")
    void shouldRejectSpecialtyWithoutName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Especialidad(null, "Descripción de prueba")
        );
    }

    @Test
    @DisplayName("ESP-003: Verificar valores de atributos")
    void shouldReturnCorrectSpecialtyAttributes() {
        Especialidad esp = new Especialidad("Pediatría", "Atención médica para niños");
        assertAll("Todos los atributos deben conservar su valor",
                () -> assertEquals("Pediatría", esp.getNombre()),
                () -> assertEquals("Atención médica para niños", esp.getDescripcion())
        );
    }
}
