package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CitaMedicaTest {

    @Test
    @DisplayName("Crear cita médica con datos válidos")
    void shouldCreateCitaMedicaWithValidData() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 20, 10, 30);

        CitaMedica cita = new CitaMedica(
                "PAC-001",
                "DOC-001",
                "ESP-01",
                fechaHora,
                "PROGRAMADA"
        );

        assertNotNull(cita);
        assertEquals("PAC-001", cita.getPacienteId());
        assertEquals("DOC-001", cita.getDoctorId());
        assertEquals("ESP-01", cita.getEspecialidadId());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("PROGRAMADA", cita.getEstado());
    }
}