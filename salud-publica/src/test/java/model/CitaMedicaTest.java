package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pe.saludpublica.model.CitaMedica;
import pe.saludpublica.model.EstadoCita;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class CitaMedicaTest {

    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 25, 10, 30);
        CitaMedica cita = new CitaMedica("12345678", "87654321", "ESP-01", fechaHora, "Control general", EstadoCita.PROGRAMADA);

        assertNotNull(cita);
        assertEquals("12345678", cita.getPaciente());
        assertEquals("87654321", cita.getDoctor());
        assertEquals("ESP-01", cita.getEspecialidad());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("Control general", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin identificador de paciente")
    void shouldRejectAppointmentWithoutPatient() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 25, 10, 30);
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica(null, "87654321", "ESP-01", fechaHora, "Control general", EstadoCita.PROGRAMADA));
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("   ", "87654321", "ESP-01", fechaHora, "Control general", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin identificador de doctor")
    void shouldRejectAppointmentWithoutDoctor() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 25, 10, 30);
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("12345678", null, "ESP-01", fechaHora, "Control general", EstadoCita.PROGRAMADA));
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("12345678", "   ", "ESP-01", fechaHora, "Control general", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin identificador de especialidad")
    void shouldRejectAppointmentWithoutSpecialty() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 25, 10, 30);
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("12345678", "87654321", null, fechaHora, "Control general", EstadoCita.PROGRAMADA));
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("12345678", "87654321", "   ", fechaHora, "Control general", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin fecha y hora")
    void shouldRejectAppointmentWithoutDateTime() {
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("12345678", "87654321", "ESP-01", null, "Control general", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Asignar estado PROGRAMADA por defecto cuando el estado recibido es null")
    void shouldAssignScheduledStatusByDefaultWhenStatusIsNull() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 25, 10, 30);
        CitaMedica cita = new CitaMedica("12345678", "87654321", "ESP-01", fechaHora, "Control general", null);

        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Conservar los estados válidos recibidos en la cita")
    void shouldKeepValidStatusesWhenProvided() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 25, 10, 30);

        CitaMedica programada = new CitaMedica("12345678", "87654321", "ESP-01", fechaHora, "Control", EstadoCita.PROGRAMADA);
        CitaMedica atendida = new CitaMedica("12345678", "87654321", "ESP-01", fechaHora, "Control", EstadoCita.ATENDIDA);
        CitaMedica cancelada = new CitaMedica("12345678", "87654321", "ESP-01", fechaHora, "Control", EstadoCita.CANCELADA);

        assertEquals(EstadoCita.PROGRAMADA, programada.getEstado());
        assertEquals(EstadoCita.ATENDIDA, atendida.getEstado());
        assertEquals(EstadoCita.CANCELADA, cancelada.getEstado());
    }

    @Test
    @DisplayName("Conservar cada atributo de la cita después de construir el objeto")
    void shouldKeepEachAttributeAfterConstruction() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 1, 15, 0);
        CitaMedica cita = new CitaMedica("99887766", "11223344", "ESP-03", fechaHora, "Seguimiento", EstadoCita.ATENDIDA);

        assertEquals("99887766", cita.getPaciente());
        assertEquals("11223344", cita.getDoctor());
        assertEquals("ESP-03", cita.getEspecialidad());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("Seguimiento", cita.getMotivo());
        assertEquals(EstadoCita.ATENDIDA, cita.getEstado());
    }
}
