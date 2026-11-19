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
        CitaMedica cita = new CitaMedica("P001", "D001", "E001", FECHA, "Dolor de cabeza", EstadoCita.PROGRAMADA);
        assertNotNull(cita);
        assertEquals("P001", cita.getPaciente());
        assertEquals("D001", cita.getDoctor());
        assertEquals("E001", cita.getEspecialidad());
        assertEquals(FECHA, cita.getFechaHora());
        assertEquals("Dolor de cabeza", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Conservar el estado válido recibido")
    void shouldKeepValidStatus() {
        CitaMedica cita = new CitaMedica("P001", "D001", "E001", FECHA, "Control", EstadoCita.CANCELADA);
        assertEquals(EstadoCita.CANCELADA, cita.getEstado());
    }

    @Test
    @DisplayName("Conservar los atributos después de construir la cita")
    void shouldKeepAttributesAfterConstruction() {
        LocalDateTime otra = LocalDateTime.of(2026, 12, 5, 15, 0);
        CitaMedica cita = new CitaMedica("P002", "D002", "E002", otra, "Chequeo general", EstadoCita.ATENDIDA);
        assertEquals("P002", cita.getPaciente());
        assertEquals("D002", cita.getDoctor());
        assertEquals("E002", cita.getEspecialidad());
        assertEquals(otra, cita.getFechaHora());
        assertEquals("Chequeo general", cita.getMotivo());
        assertEquals(EstadoCita.ATENDIDA, cita.getEstado());
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin paciente")
    void shouldRejectAppointmentWithoutPatient() {
        assertThrows(IllegalArgumentException.class,
            () -> new CitaMedica(null, "D001", "E001", FECHA, "Control", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin doctor")
    void shouldRejectAppointmentWithoutDoctor() {
        assertThrows(IllegalArgumentException.class,
            () -> new CitaMedica("P001", null, "E001", FECHA, "Control", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin especialidad")
    void shouldRejectAppointmentWithoutSpecialty() {
        assertThrows(IllegalArgumentException.class,
            () -> new CitaMedica("P001", "D001", null, FECHA, "Control", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin fecha y hora")
    void shouldRejectAppointmentWithoutDateTime() {
        assertThrows(IllegalArgumentException.class,
            () -> new CitaMedica("P001", "D001", "E001", null, "Control", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Asignar el estado PROGRAMADA cuando el estado recibido es null")
    void shouldDefaultToScheduledWhenStatusIsNull() {
        CitaMedica cita = new CitaMedica("P001", "D001", "E001", FECHA, "Control", null);
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }
}