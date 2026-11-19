package com.eszalud.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EspecialidadTest {
    @Test
    @DisplayName("ESP-001: Crear especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData(){
        Especialidad especialidad = new Especialidad (
                "ESP001",
                "Cardiología"
        );
        assertNotNull(especialidad);
        assertEquals("ESP001", especialidad.getCodigo());
        assertEquals("Cardiología", especialidad.getNombre());
    }

    @Test
    @DisplayName("ESP-002: Crear especialidad sin nombre")
    void shouldRejectSpecialtyWithNullName() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Especialidad(
                    "ESP001",
                    null
            );
        });
    }

    @Test
    @DisplayName("ESP-003: Verificar atributos de la especialidad")
    void shouldReturnCorrectSpecialtyAttributes() {

        Especialidad especialidad = new Especialidad(
                "ESP002",
                "Neurología"
        );

        assertAll(
                () -> assertEquals("ESP002", especialidad.getCodigo()),
                () -> assertEquals("Neurología", especialidad.getNombre())
        );
    }

}
