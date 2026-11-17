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
                "P1", "D1", "CARDIOLOGIA", fecha, "Control general", EstadoCita.PROGRAMADA);

        assertNotNull(cita);
        assertEquals("P1", cita.getPaciente());
        assertEquals("D1", cita.getDoctor());
        assertEquals("CARDIOLOGIA", cita.getEspecialidad());
        assertEquals(fecha, cita.getFechaHora());
        assertEquals("Control general", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }
    @Test
    @DisplayName("Rechazar la creación de una cita sin paciente")
    void shouldRejectAppointmentWithoutPatient() {
        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica(null, "D1", "CARDIOLOGIA",
                        LocalDateTime.of(2026, 12, 1, 9, 30), "Control general", EstadoCita.PROGRAMADA));
    }
    @Test
    @DisplayName("Rechazar la creación de una cita sin doctor")
    void shouldRejectAppointmentWithoutDoctor() {
        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica("P1", null, "CARDIOLOGIA",
                        LocalDateTime.of(2026, 12, 1, 9, 30), "Control general", EstadoCita.PROGRAMADA));
    }
    @Test
    @DisplayName("Rechazar la creación de una cita sin especialidad")
    void shouldRejectAppointmentWithoutSpecialty() {
        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica("P1", "D1", null,
                        LocalDateTime.of(2026, 12, 1, 9, 30), "Control general", EstadoCita.PROGRAMADA));
    }
    @Test
    @DisplayName("Rechazar la creación de una cita sin fecha y hora")
    void shouldRejectAppointmentWithoutDateTime() {
        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica("P1", "D1", "CARDIOLOGIA",
                        null, "Control general", EstadoCita.PROGRAMADA));
    }
}