package pe.saludpublica.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.Test;

class PacienteTest {

    @Test
    void pac001_createsPatientWithValidData() {
        Paciente paciente = new Paciente(
                "74859632",
                "Ana María",
                "Pérez Salazar",
                "987654321",
                "ana.perez@email.com"
        );

        assertNotNull(paciente);
        assertAll(
                () -> assertEquals("74859632", paciente.getDocumento()),
                () -> assertEquals("Ana María", paciente.getNombres()),
                () -> assertEquals("Pérez Salazar", paciente.getApellidos()),
                () -> assertEquals("987654321", paciente.getTelefono()),
                () -> assertEquals("ana.perez@email.com", paciente.getCorreo())
        );
    }

    @Test
    void pac002_throwsExceptionWhenDocumentIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Paciente(
                        null,
                        "Ana María",
                        "Pérez Salazar",
                        "987654321",
                        "ana.perez@email.com"
                )
        );
    }

    @Test
    void pac003_throwsExceptionWhenNamesAreNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Paciente(
                        "74859632",
                        null,
                        "Pérez Salazar",
                        "987654321",
                        "ana.perez@email.com"
                )
        );
    }

}
