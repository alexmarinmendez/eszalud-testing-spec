package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Pruebas del modelo CitaMedica")
class CitaMedicaTest {

    // CIT-001
    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 15, 9, 30);

        CitaMedica cita = new CitaMedica(
                "pac-001",
                "doc-001",
                "esp-001",
                fechaHora,
                "Control de presión arterial",
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);
        assertEquals("pac-001", cita.getPaciente());
        assertEquals("doc-001", cita.getDoctor());
        assertEquals("esp-001", cita.getEspecialidad());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("Control de presión arterial", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }
}