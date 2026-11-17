package pe.saludpublica.model;

import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CitaMedicaTest {
    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        LocalDateTime fechaHora = LocalDateTime.of(2027, 1, 15, 10, 30);
        CitaMedica cita = new CitaMedica(
                "paciente-1", "doctor-1", "especialidad-1", fechaHora,
                "Consulta general", EstadoCita.PROGRAMADA);

        assertNotNull(cita);
        assertEquals("paciente-1", cita.getPaciente());
        assertEquals("doctor-1", cita.getDoctor());
        assertEquals("especialidad-1", cita.getEspecialidad());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("Consulta general", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }
}
