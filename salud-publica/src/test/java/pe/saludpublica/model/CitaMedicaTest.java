package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CitaMedicaTest {

    @Test
    @DisplayName("Crear una Cita medica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        CitaMedica cita = new CitaMedica(
                "12345678",
                "87654321",
                "Pediatría",
                "2026-11-23 16:30",
                "Dolor abdominal",
                "PROGRAMADA"
        );

        assertNotNull(cita);
        assertEquals("12345678", cita.getPaciente());
        assertEquals("87654321", cita.getDoctor());
        assertEquals("Pediatría", cita.getEspecialidad());
        assertEquals("2026-11-23 16:30", cita.getFechaHora());
        assertEquals("Dolor abdominal", cita.getMotivo());
        assertEquals("PROGRAMADA", cita.getEstado());
    }

}
