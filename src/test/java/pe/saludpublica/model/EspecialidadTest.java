package pe.saludpublica.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class EspecialidadTest {

    @Test
    @DisplayName("ESP-001 | Crear especialidad con datos válidos")
    void debeCrearEspecialidadConDatosValidos() {

        Especialidad especialidad = new Especialidad(
                "Medicina general",
                "Atención primaria"
        );

        assertEquals("Medicina general", especialidad.getNombre());
        assertEquals("Atención primaria", especialidad.getDescripcion());
    }


    @Test
    @DisplayName("ESP-002 | Rechazar especialidad con nombre nulo")
    void debeRechazarNombreNulo() {

        assertThrows(IllegalArgumentException.class, () ->
                new Especialidad(
                        null,
                        "Atención primaria"
                )
        );
    }

    @Test
    @DisplayName("ESP-003 | Verificar atributos después de la construcción")
    void debeVerificarTodosLosAtributos() {

        Especialidad especialidad = new Especialidad(
                "Cardiología",
                "Salud cardiovascular"
        );

        assertEquals("Cardiología", especialidad.getNombre());
        assertEquals("Salud cardiovascular", especialidad.getDescripcion());
    }

}