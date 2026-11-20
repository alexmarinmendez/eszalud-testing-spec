package pe.salud.model;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
public class CitaMedicaTest {
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
    @DisplayName("Rechazar la creación de una cita sin identificador de paciente")
    void shouldRejectAppointmentWithoutPatient() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 23, 16, 30);
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(null, "6af7271e501cca046a16604f", "6af71da3501cca046a166045", fechaHora, "Dolor abdominal", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin identificador de doctor")
    void shouldRejectAppointmentWithoutDoctor() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 23, 16, 30);
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica("6af71e0b501cca046a166049", null, "6af71da3501cca046a166045", fechaHora, "Dolor abdominal", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin identificador de especialidad")
    void shouldRejectAppointmentWithoutSpecialty() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 23, 16, 30);
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica("6af71e0b501cca046a166049", "6af7271e501cca046a16604f", null, fechaHora, "Dolor abdominal", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin fecha y hora")
    void shouldRejectAppointmentWithoutDateTime() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica("6af71e0b501cca046a166049", "6af7271e501cca046a16604f", "6af71da3501cca046a166045", null, "Dolor abdominal", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Asignar estado PROGRAMADA por defecto cuando el estado recibido es null")
    void shouldAssignDefaultScheduledStatusWhenStatusIsNull() {
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
    @DisplayName("Conservar el estado válido recibido al crear una cita")
    void shouldPreserveValidAppointmentStatus() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 23, 16, 30);
        CitaMedica cita = new CitaMedica(
                "6af71e0b501cca046a166049",
                "6af7271e501cca046a16604f",
                "6af71da3501cca046a166045",
                fechaHora,
                "Control posterior",
                EstadoCita.ATENDIDA
        );

        assertEquals(EstadoCita.ATENDIDA, cita.getEstado());
    }
}
