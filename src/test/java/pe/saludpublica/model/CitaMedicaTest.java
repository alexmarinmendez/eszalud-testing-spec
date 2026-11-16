package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        LocalDateTime fecha = LocalDateTime.of(2026, 12, 1, 9, 30);
        CitaMedica cita = new CitaMedica(
                "pac1",
                "doc1",
                "esp1",
                fecha,
                "Control",
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);
        assertEquals("pac1", cita.getPaciente());
    }

    @Test
    @DisplayName("Rechazar cita sin paciente")
    void shouldRejectAppointmentWithoutPatient() {
        LocalDateTime fecha = LocalDateTime.of(2026, 12, 1, 9, 30);
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica(null, "doc1", "esp1", fecha, "Control", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Rechazar cita sin doctor")
    void shouldRejectAppointmentWithoutDoctor() {
        LocalDateTime fecha = LocalDateTime.of(2026, 12, 1, 9, 30);
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("pac1", null, "esp1", fecha, "Control", EstadoCita.PROGRAMADA)
        );
    }
}