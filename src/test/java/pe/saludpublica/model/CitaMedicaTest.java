package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        CitaMedica cita = new CitaMedica(
                "6af71e0b501cca046a166049",
                "6af7271e501cca046a16604f",
                "6af71da3501cca046a166045",
                "2026-11-23 16:30",
                "Dolor abdominal",
                EstadoCita.ATENDIDA
        );

        assertNotNull(cita);
        assertEquals("6af71e0b501cca046a166049", cita.getPaciente());
        assertEquals("6af7271e501cca046a16604f", cita.getDoctor());
        assertEquals("6af71da3501cca046a166045", cita.getEspecialidad());
        assertEquals("2026-11-23 16:30", cita.getFechaHora());
        assertEquals("Dolor abdominal", cita.getMotivo());
        assertEquals(EstadoCita.ATENDIDA, cita.getEstado());
    }

    @Test
    @DisplayName("Asignar estado PROGRAMADA cuando el estado es nulo")
    void shouldDefaultEstadoToProgramadaWhenNull() {
        CitaMedica cita = new CitaMedica(
                "6af71e0b501cca046a166049",
                "6af7271e501cca046a16604f",
                "6af71da3501cca046a166045",
                "2026-11-23 16:30",
                null,
                null
        );

        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
        assertNull(cita.getMotivo());
    }

    @Test
    @DisplayName("Conservar los distintos estados válidos de la cita")
    void shouldPreserveValidAppointmentStatuses() {
        CitaMedica programada = new CitaMedica(
                "PAC-1", "DOC-1", "ESP-1", "2026-12-01 09:00", "Control", EstadoCita.PROGRAMADA
        );
        CitaMedica atendida = new CitaMedica(
                "PAC-1", "DOC-1", "ESP-1", "2026-12-01 09:00", "Control", EstadoCita.ATENDIDA
        );
        CitaMedica cancelada = new CitaMedica(
                "PAC-1", "DOC-1", "ESP-1", "2026-12-01 09:00", "Control", EstadoCita.CANCELADA
        );

        assertEquals(EstadoCita.PROGRAMADA, programada.getEstado());
        assertEquals(EstadoCita.ATENDIDA, atendida.getEstado());
        assertEquals(EstadoCita.CANCELADA, cancelada.getEstado());
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin paciente")
    void shouldRejectAppointmentWithoutPatient() {
        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica(null, "DOC-1", "ESP-1", "2026-12-01 09:00", "Consulta", EstadoCita.PROGRAMADA)
        );
        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica("   ", "DOC-1", "ESP-1", "2026-12-01 09:00", "Consulta", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin doctor")
    void shouldRejectAppointmentWithoutDoctor() {
        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica("PAC-1", null, "ESP-1", "2026-12-01 09:00", "Consulta", EstadoCita.PROGRAMADA)
        );
        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica("PAC-1", "  ", "ESP-1", "2026-12-01 09:00", "Consulta", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin especialidad")
    void shouldRejectAppointmentWithoutSpecialty() {
        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica("PAC-1", "DOC-1", null, "2026-12-01 09:00", "Consulta", EstadoCita.PROGRAMADA)
        );
        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica("PAC-1", "DOC-1", "", "2026-12-01 09:00", "Consulta", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin fecha y hora")
    void shouldRejectAppointmentWithoutDateTime() {
        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica("PAC-1", "DOC-1", "ESP-1", null, "Consulta", EstadoCita.PROGRAMADA)
        );
        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica("PAC-1", "DOC-1", "ESP-1", "   ", "Consulta", EstadoCita.PROGRAMADA)
        );
    }
}