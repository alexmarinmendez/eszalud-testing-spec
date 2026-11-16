
package pe.saludpublica.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class CitaMedicaTest {

    @Test
    @DisplayName("CIT-001: Crear cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {

        LocalDateTime fecha = LocalDateTime.of(
                2026, 12, 10, 10, 30
        );

        CitaMedica cita = new CitaMedica(
                "PAC001",
                "DOC001",
                "ESP001",
                fecha,
                "Consulta general",
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);
        assertEquals("PAC001", cita.getPaciente());
        assertEquals("DOC001", cita.getDoctor());
        assertEquals("ESP001", cita.getEspecialidad());
        assertEquals(fecha, cita.getFechaHora());
        assertEquals("Consulta general", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }
}
