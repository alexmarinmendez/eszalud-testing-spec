package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 23, 16, 30);
        CitaMedica cita = new CitaMedica(
                "6af71e0b501cca046a166049",
                "6af7271e501cca046a16604f",
                "6af71da3501cca046a166045",
                fechaHora,
                "Dolor abdominal",
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);
        assertEquals("6af71e0b501cca046a166049", cita.getPaciente());
        assertEquals("6af7271e501cca046a16604f", cita.getDoctor());
        assertEquals("6af71da3501cca046a166045", cita.getEspecialidad());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("Dolor abdominal", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin paciente")
    void shouldRejectAppointmentWithoutPatient() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 23, 16, 30);
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(null, "6af7271e501cca046a16604f", "6af71da3501cca046a166045", fechaHora, "Dolor abdominal", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin doctor")
    void shouldRejectAppointmentWithoutDoctor() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 23, 16, 30);
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica("6af71e0b501cca046a166049", null, "6af71da3501cca046a166045", fechaHora, "Dolor abdominal", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin especialidad")
    void shouldRejectAppointmentWithoutSpecialty() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 23, 16, 30);
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica("6af71e0b501cca046a166049", "6af7271e501cca046a16604f", null, fechaHora, "Dolor abdominal", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin fecha y hora")
    void shouldRejectAppointmentWithoutDate() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica("6af71e0b501cca046a166049", "6af7271e501cca046a16604f", "6af71da3501cca046a166045", null, "Dolor abdominal", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Conservar el estado válido asignado a la cita médica")
    void shouldKeepValidAppointmentStatus() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 10, 28, 11, 35);
        CitaMedica citaAtendida = new CitaMedica(
                "6af71f49501cca046a16604a",
                "6af730a190f1d08b4673bfa7",
                "6af71da3501cca046a166045",
                fechaHora,
                "Control posterior a consulta de emergencia",
                EstadoCita.ATENDIDA
        );
        CitaMedica citaCancelada = new CitaMedica(
                "6af71f49501cca046a16604a",
                "6af730a190f1d08b4673bfa7",
                "6af71da3501cca046a166045",
                fechaHora,
                "Control posterior",
                EstadoCita.CANCELADA
        );

        assertEquals(EstadoCita.ATENDIDA, citaAtendida.getEstado());
        assertEquals(EstadoCita.CANCELADA, citaCancelada.getEstado());
    }

    @Test
    @DisplayName("Asignar estado PROGRAMADA por defecto cuando el estado recibido es null")
    void shouldAssignDefaultStatusWhenStatusIsNull() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 23, 16, 30);
        CitaMedica cita = new CitaMedica(
                "6af71e0b501cca046a166049",
                "6af7271e501cca046a16604f",
                "6af71da3501cca046a166045",
                fechaHora,
                "Dolor abdominal",
                null
        );

        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Rechazar cita médica con referencias de paciente, doctor o especialidad en blanco")
    void shouldRejectAppointmentWithBlankRequiredFields() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 23, 16, 30);
        assertThrows(IllegalArgumentException.class, () -> new CitaMedica("  ", "6af7271e501cca046a16604f", "6af71da3501cca046a166045", fechaHora, "Dolor abdominal", EstadoCita.PROGRAMADA));
        assertThrows(IllegalArgumentException.class, () -> new CitaMedica("6af71e0b501cca046a166049", "", "6af71da3501cca046a166045", fechaHora, "Dolor abdominal", EstadoCita.PROGRAMADA));
        assertThrows(IllegalArgumentException.class, () -> new CitaMedica("6af71e0b501cca046a166049", "6af7271e501cca046a16604f", "   ", fechaHora, "Dolor abdominal", EstadoCita.PROGRAMADA));
    }

}