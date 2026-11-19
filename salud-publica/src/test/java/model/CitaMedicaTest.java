package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pe.saludpublica.model.CitaMedica;
import pe.saludpublica.model.EstadoCita;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CitaMedicaTest {

    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 25, 10, 30);
        CitaMedica cita = new CitaMedica("12345678", "87654321", "ESP-01", fechaHora, "Control general", EstadoCita.PROGRAMADA);

        assertNotNull(cita);
        assertEquals("12345678", cita.getPaciente());
        assertEquals("87654321", cita.getDoctor());
        assertEquals("ESP-01", cita.getEspecialidad());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("Control general", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }
}
