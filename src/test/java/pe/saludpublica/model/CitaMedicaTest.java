package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CitaMedicaTest {

    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 10, 10, 30);

        CitaMedica cita = new CitaMedica(
                "PAC001",
                "DOC001",
                "ESP001",
                fechaHora,
                "Dolor de cabeza",
                "PROGRAMADA"
        );

        assertEquals("PAC001", cita.getPacienteId());
        assertEquals("DOC001", cita.getDoctorId());
        assertEquals("ESP001", cita.getEspecialidadId());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("Dolor de cabeza", cita.getMotivo());
        assertEquals("PROGRAMADA", cita.getEstado());
    }

    @Test
    @DisplayName("Rechazar cita médica sin paciente")
    void shouldThrowExceptionWhenPatientIdIsNull() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 10, 10, 30);

        assertThrows(IllegalArgumentException.class, () -> {
            new CitaMedica(
                    null,
                    "DOC001",
                    "ESP001",
                    fechaHora,
                    "Dolor de cabeza",
                    "PROGRAMADA"
            );
        });
    }
}
