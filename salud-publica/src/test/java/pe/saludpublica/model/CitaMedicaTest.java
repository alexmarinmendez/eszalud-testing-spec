package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    private static final LocalDateTime FECHA = LocalDateTime.of(2026, 12, 1, 9, 30);

    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        CitaMedica cita = new CitaMedica(
                "PAC-1", "DOC-1", "ESP-1", FECHA, "Dolor de cabeza",
                EstadoCita.PROGRAMADA);

        assertNotNull(cita);
        assertEquals("PAC-1", cita.getPaciente());
        assertEquals("DOC-1", cita.getDoctor());
        assertEquals("ESP-1", cita.getEspecialidad());
        assertEquals(FECHA, cita.getFechaHora());
        assertEquals("Dolor de cabeza", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin paciente")
    void shouldRejectAppointmentWithoutPatient() {
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica(null, "DOC-1", "ESP-1", FECHA,
                        "Control", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin doctor")
    void shouldRejectAppointmentWithoutDoctor() {
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("PAC-1", null, "ESP-1", FECHA,
                        "Control", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin especialidad")
    void shouldRejectAppointmentWithoutSpecialty() {
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("PAC-1", "DOC-1", null, FECHA,
                        "Control", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin fecha y hora")
    void shouldRejectAppointmentWithoutDateTime() {
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("PAC-1", "DOC-1", "ESP-1", null,
                        "Control", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Asignar el estado PROGRAMADA cuando el estado recibido es null")
    void shouldDefaultToScheduledWhenStatusIsNull() {
        CitaMedica cita = new CitaMedica(
                "PAC-1", "DOC-1", "ESP-1", FECHA, "Control", null);

        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Conservar el estado válido recibido")
    void shouldKeepValidStatus() {
        CitaMedica cita = new CitaMedica(
                "PAC-1", "DOC-1", "ESP-1", FECHA, "Control", EstadoCita.ATENDIDA);

        assertEquals(EstadoCita.ATENDIDA, cita.getEstado());
    }

    @Test
    @DisplayName("Verificar los atributos de la cita después de construirla")
    void shouldKeepAppointmentAttributesAfterConstruction() {
        LocalDateTime fecha = LocalDateTime.of(2027, 1, 15, 14, 0);
        CitaMedica cita = new CitaMedica(
                "PAC-9", "DOC-9", "ESP-9", fecha, "Chequeo general",
                EstadoCita.CANCELADA);

        assertEquals("PAC-9", cita.getPaciente());
        assertEquals("DOC-9", cita.getDoctor());
        assertEquals("ESP-9", cita.getEspecialidad());
        assertEquals(fecha, cita.getFechaHora());
        assertEquals("Chequeo general", cita.getMotivo());
        assertEquals(EstadoCita.CANCELADA, cita.getEstado());
    }
}