package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 1, 9, 30);

        CitaMedica cita = new CitaMedica("pac-001", "doc-001", "esp-001",
                fechaHora, "Control general", EstadoCita.PROGRAMADA);

        assertEquals("pac-001", cita.getPaciente());
        assertEquals("doc-001", cita.getDoctor());
        assertEquals("esp-001", cita.getEspecialidad());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("Control general", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin paciente")
    void shouldRejectAppointmentWithoutPatient() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 1, 9, 30);

        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica(null, "doc-001", "esp-001",
                        fechaHora, "Control general", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin doctor")
    void shouldRejectAppointmentWithoutDoctor() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 1, 9, 30);

        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("pac-001", null, "esp-001",
                        fechaHora, "Control general", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin especialidad")
    void shouldRejectAppointmentWithoutSpecialty() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 1, 9, 30);

        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("pac-001", "doc-001", null,
                        fechaHora, "Control general", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin fecha y hora")
    void shouldRejectAppointmentWithoutDateTime() {
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("pac-001", "doc-001", "esp-001",
                        null, "Control general", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin estado")
    void shouldRejectAppointmentWithoutStatus() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 1, 9, 30);

        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("pac-001", "doc-001", "esp-001",
                        fechaHora, "Control general", null));
    }

    @Test
    @DisplayName("Conservar el estado válido recibido")
    void shouldKeepValidStatus() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 1, 9, 30);

        CitaMedica cita = new CitaMedica("pac-001", "doc-001", "esp-001",
                fechaHora, "Control general", EstadoCita.CANCELADA);

        assertEquals(EstadoCita.CANCELADA, cita.getEstado());
    }

    @Test
    @DisplayName("Verificar los atributos de la cita después de construirla")
    void shouldReturnAllAppointmentAttributesAfterConstruction() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 15, 14, 0);

        CitaMedica cita = new CitaMedica("pac-002", "doc-002", "esp-002",
                fechaHora, "Dolor de cabeza", EstadoCita.ATENDIDA);

        assertEquals("pac-002", cita.getPaciente());
        assertEquals("doc-002", cita.getDoctor());
        assertEquals("esp-002", cita.getEspecialidad());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("Dolor de cabeza", cita.getMotivo());
        assertEquals(EstadoCita.ATENDIDA, cita.getEstado());
    }
}