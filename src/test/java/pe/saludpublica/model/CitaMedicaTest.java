package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    @Test
    @DisplayName("Crear cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        CitaMedica cita = new CitaMedica(
                "PAC-123",
                "DOC-456",
                "ESP-001",
                "2026-11-20 10:00",
                "Consulta general",
                "PROGRAMADA"
        );

        assertNotNull(cita);
        assertEquals("PAC-123", cita.getPaciente());
        assertEquals("DOC-456", cita.getDoctor());
        assertEquals("ESP-001", cita.getEspecialidad());
        assertEquals("2026-11-20 10:00", cita.getFechaHora());
        assertEquals("Consulta general", cita.getMotivo());
        assertEquals("PROGRAMADA", cita.getEstado());
    }
}
