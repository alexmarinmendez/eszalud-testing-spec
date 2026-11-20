package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CitaMedicaTest {

    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 1, 10, 30);
        CitaMedica cita = new CitaMedica(
                "PAC-01",
                "DOC-01",
                "ESP-01",
                fechaHora,
                "Control general",
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);
        assertEquals("PAC-01", cita.getPaciente());
        assertEquals("DOC-01", cita.getDoctor());
        assertEquals("ESP-01", cita.getEspecialidad());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("Control general", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }
    @Test
    @DisplayName("Rechazar la creación de una cita sin paciente")
    void shouldRejectAppointmentWithoutPatient() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        null,
                        "DOC-01",
                        "ESP-01",
                        LocalDateTime.of(2026, 12, 1, 10, 30),
                        "Control general",
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
                        "PAC-01",
                        null,
                        "ESP-01",
                        LocalDateTime.of(2026, 12, 1, 10, 30),
                        "Control general",
                        EstadoCita.PROGRAMADA
                )
        );
    }
    @Test
    @DisplayName("Rechazar la creación de una cita sin especialidad")
    void shouldRejectAppointmentWithoutSpecialty() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC-01",
                        "DOC-01",
                        null,
                        LocalDateTime.of(2026, 12, 1, 10, 30),
                        "Control general",
                        EstadoCita.PROGRAMADA
                )
        );
    }
    @Test
    @DisplayName("Rechazar la creación de una cita sin fecha y hora")
    void shouldRejectAppointmentWithoutDateTime() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC-01",
                        "DOC-01",
                        "ESP-01",
                        null,
                        "Control general",
                        EstadoCita.PROGRAMADA
                )
        );
    }
    @Test
    @DisplayName("Asignar estado PROGRAMADA por defecto cuando el estado es null")
    void shouldAssignScheduledStatusWhenStatusIsNull() {
        CitaMedica cita = new CitaMedica(
                "PAC-01",
                "DOC-01",
                "ESP-01",
                LocalDateTime.of(2026, 12, 1, 10, 30),
                "Control general",
                null
        );

        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }
    @Test
    @DisplayName("Conservar el estado válido recibido al crear la cita")
    void shouldKeepValidStatusWhenProvided() {
        CitaMedica cita = new CitaMedica(
                "PAC-01",
                "DOC-01",
                "ESP-01",
                LocalDateTime.of(2026, 12, 1, 10, 30),
                "Control general",
                EstadoCita.ATENDIDA
        );

        assertEquals(EstadoCita.ATENDIDA, cita.getEstado());
    }
}