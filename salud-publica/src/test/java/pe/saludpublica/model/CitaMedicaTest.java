package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CitaMedicaTest {

    @Test
    @DisplayName("Crear una Cita medica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        CitaMedica cita = new CitaMedica(
                "12345678",
                "87654321",
                "Pediatría",
                "2026-11-23 16:30",
                "Dolor abdominal",
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);
        assertEquals("12345678", cita.getPaciente());
        assertEquals("87654321", cita.getDoctor());
        assertEquals("Pediatría", cita.getEspecialidad());
        assertEquals("2026-11-23 16:30", cita.getFechaHora());
        assertEquals("Dolor abdominal", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin fecha y hora")
    void shouldRejectAppointmentWithoutDateTime() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "12345678",
                        "87654321",
                        "Pediatría",
                        null,
                        "Dolor abdominal",
                        EstadoCita.PROGRAMADA
                )
        );
    }
    @Test
    @DisplayName("Rechazar la creación de una cita sin doctor")
    void shouldRejectAppointmentWithoutDoctor() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "12345678",
                        null,
                        "Pediatría",
                        "2026-11-23 16:30",
                        "Dolor abdominal",
                        EstadoCita.PROGRAMADA
                )
        );
    }
    @Test
    @DisplayName("Rechazar la creación de una cita sin paciente")
    void shouldRejectAppointmentWithoutPatient() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        null,
                        "87654321",
                        "Pediatría",
                        "2026-11-23 16:30",
                        "Dolor abdominal",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    @Test
    @DisplayName("Conservar los estados validos de la cita y asignar PROGRAMADA cuando es null")
    void shouldHandleAppointmentStatusValues() {

        CitaMedica citaAtendida = new CitaMedica("12345678", "87654321", "Pediatría", "2026-11-23 16:30", "Dolor abdominal", EstadoCita.ATENDIDA);
        CitaMedica citaCancelada = new CitaMedica("12345678", "87654321", "Pediatría", "2026-11-23 16:30", "Dolor abdominal", EstadoCita.CANCELADA);
        CitaMedica citaPorDefecto = new CitaMedica("12345678", "87654321", "Pediatría", "2026-11-23 16:30", "Dolor abdominal", null);

        assertEquals(EstadoCita.ATENDIDA, citaAtendida.getEstado());
        assertEquals(EstadoCita.CANCELADA, citaCancelada.getEstado());
        assertEquals(EstadoCita.PROGRAMADA, citaPorDefecto.getEstado());
    }

}
