package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    private final LocalDateTime fechaValida = LocalDateTime.of(2026, 12, 10, 10, 30);

    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        CitaMedica cita = new CitaMedica(
                "12345678",
                "87654321",
                "Cardiología",
                fechaValida,
                "Chequeo general",
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);
        assertEquals("12345678", cita.getPaciente());
        assertEquals("87654321", cita.getDoctor());
        assertEquals("Cardiología", cita.getEspecialidad());
        assertEquals(fechaValida, cita.getFechaHora());
        assertEquals("Chequeo general", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin paciente")
    void shouldRejectAppointmentWithoutPatient() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(null, "87654321", "Cardiología", fechaValida, "Consulta", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin doctor")
    void shouldRejectAppointmentWithoutDoctor() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica("12345678", null, "Cardiología", fechaValida, "Consulta", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin especialidad")
    void shouldRejectAppointmentWithoutSpecialty() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica("12345678", "87654321", null, fechaValida, "Consulta", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin fecha y hora")
    void shouldRejectAppointmentWithoutDateTime() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica("12345678", "87654321", "Cardiología", null, "Consulta", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Asignar estado PROGRAMADA por defecto cuando el estado recibido es null")
    void shouldAssignDefaultStatusWhenStatusIsNull() {
        CitaMedica cita = new CitaMedica(
                "12345678",
                "87654321",
                "Cardiología",
                fechaValida,
                "Consulta",
                null
        );

        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Conservar el estado válido recibido al crear la cita")
    void shouldKeepValidStatusWhenProvided() {
        CitaMedica cita = new CitaMedica(
                "12345678",
                "87654321",
                "Cardiología",
                fechaValida,
                "Control",
                EstadoCita.ATENDIDA
        );

        assertEquals(EstadoCita.ATENDIDA, cita.getEstado());
    }
}
