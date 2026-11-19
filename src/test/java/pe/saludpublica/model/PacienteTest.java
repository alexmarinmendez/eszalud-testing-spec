package pe.saludpublica.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
