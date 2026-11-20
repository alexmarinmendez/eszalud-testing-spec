package com.eszalud.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EspecialidadTest {

    @Test
    @DisplayName("Crear una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {
        Especialidad especialidad = new Especialidad(
                "CARD001", "Cardiología"
        );

        assertNotNull(especialidad);
        assertEquals("CARD001", especialidad.getCodigo());
        assertEquals("Cardiología", especialidad.getNombre());
    }

    @Test
    @DisplayName("Rechazar especialidad sin nombre")
    void shouldRejectSpecialtyWithoutName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Especialidad("CARD001", null)
        );
    }

    @Test
    @DisplayName("Verificar los atributos de la especialidad")
    void shouldReturnCorrectSpecialtyAttributes() {
        Especialidad especialidad = new Especialidad(
                "CARD001", "Cardiología"
        );

        assertAll(
                () -> assertEquals("CARD001", especialidad.getCodigo()),
                () -> assertEquals("Cardiología", especialidad.getNombre())
        );
    }
}