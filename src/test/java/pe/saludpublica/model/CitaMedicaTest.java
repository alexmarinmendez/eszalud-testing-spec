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

    @Test
    @DisplayName("Rechazar la creación de una cita sin paciente")
    void shouldRejectAppointmentWithoutPatient() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        null,
                        "DOC-456",
                        "ESP-001",
                        "2026-11-20 10:00",
                        "Consulta general",
                        "PROGRAMADA"
                )
        );
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin doctor")
    void shouldRejectAppointmentWithoutDoctor() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC-123",
                        null,
                        "ESP-001",
                        "2026-11-20 10:00",
                        "Consulta general",
                        "PROGRAMADA"
                )
        );
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin especialidad")
    void shouldRejectAppointmentWithoutSpecialty() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC-123",
                        "DOC-456",
                        null,
                        "2026-11-20 10:00",
                        "Consulta general",
                        "PROGRAMADA"
                )
        );
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin fecha y hora")
    void shouldRejectAppointmentWithoutDate() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC-123",
                        "DOC-456",
                        "ESP-001",
                        null,
                        "Consulta general",
                        "PROGRAMADA"
                )
        );
    }
}
