package pe.saludpublica.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    @Test
    void shouldCreateAppointmentWithValidData() {
        CitaMedica cita = new CitaMedica(
                "PAC001",
                "DOC001",
                "ESP001",
                LocalDateTime.of(2026, 11, 26, 10, 5),
                "Control medico",
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);
        assertEquals("PAC001", cita.getPaciente());
        assertEquals("DOC001", cita.getDoctor());
        assertEquals("ESP001", cita.getEspecialidad());
        assertEquals(
                LocalDateTime.of(2026, 11, 26, 10, 5),
                cita.getFechaHora()
        );
        assertEquals("Control medico", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    void shouldRejectAppointmentWithoutPatient() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        null,
                        "DOC001",
                        "ESP001",
                        LocalDateTime.of(2026, 11, 26, 10, 5),
                        "Control medico",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    @Test
    void shouldRejectAppointmentWithoutDoctor() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC001",
                        null,
                        "ESP001",
                        LocalDateTime.of(2026, 11, 26, 10, 5),
                        "Control medico",
                        EstadoCita.PROGRAMADA
                )
        );
    }
}