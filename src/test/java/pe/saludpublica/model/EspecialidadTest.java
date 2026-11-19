package pe.saludpublica.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class EspecialidadTest {

    @Test
    void esp001_createsSpecialtyWithValidData() {
        Especialidad especialidad = new Especialidad(
                "Cardiología",
                "Diagnóstico y tratamiento de enfermedades del corazón"
        );

        assertNotNull(especialidad);
        assertAll(
                () -> assertEquals("Cardiología", especialidad.getNombre()),
                () -> assertEquals(
                        "Diagnóstico y tratamiento de enfermedades del corazón",
                        especialidad.getDescripcion()
                )
        );
    }

    @Test
    void esp002_throwsExceptionWhenNameIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Especialidad(
                        null,
                        "Diagnóstico y tratamiento de enfermedades del corazón"
                )
        );
    }
}
