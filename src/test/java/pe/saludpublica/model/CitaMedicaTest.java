package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);
        assertEquals("6af71e0b501cca046a166049", cita.getPaciente());
        assertEquals("6af7271e501cca046a16604f", cita.getDoctor());
        assertEquals("6af71da3501cca046a166045", cita.getEspecialidad());
        assertEquals("2026-11-23 16:30", cita.getFechaHora());
        assertEquals("Dolor abdominal", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Verificar los atributos después de construir la cita médica")
    void shouldExposeAllAttributesAfterCreation() {
        CitaMedica cita = new CitaMedica(
                "6af71f6a501cca046a16604b",
                "6af7301390f1d08b4673bfa5",
                "6af71da3501cca046a166048",
                "2026-11-26 10:05",
                "Acné excesivo",
                EstadoCita.ATENDIDA
        );

        assertAll(
                () -> assertEquals("6af71f6a501cca046a16604b", cita.getPaciente()),
                () -> assertEquals("6af7301390f1d08b4673bfa5", cita.getDoctor()),
                () -> assertEquals("6af71da3501cca046a166048", cita.getEspecialidad()),
                () -> assertEquals("2026-11-26 10:05", cita.getFechaHora()),
                () -> assertEquals("Acné excesivo", cita.getMotivo()),
                () -> assertEquals(EstadoCita.ATENDIDA, cita.getEstado())
        );
    }

    @Test
    @DisplayName("Rechazar la creación de una cita médica sin identificador de paciente")
    void shouldRejectAppointmentWithoutPatientReference() {
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica(null, "6af7271e501cca046a16604f", "6af71da3501cca046a166045",
                        "2026-11-23 16:30", "Dolor abdominal", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Rechazar la creación de una cita médica sin identificador de doctor")
    void shouldRejectAppointmentWithoutDoctorReference() {
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("6af71e0b501cca046a166049", null, "6af71da3501cca046a166045",
                        "2026-11-23 16:30", "Dolor abdominal", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Rechazar la creación de una cita médica sin identificador de especialidad")
    void shouldRejectAppointmentWithoutSpecialtyReference() {
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("6af71e0b501cca046a166049", "6af7271e501cca046a16604f", null,
                        "2026-11-23 16:30", "Dolor abdominal", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Asignar el estado PROGRAMADA cuando la cita se crea sin estado")
    void shouldDefaultStatusToScheduledWhenStatusIsNull() {
        CitaMedica cita = new CitaMedica(
                "6af71e0b501cca046a166049",
                "6af7271e501cca046a16604f",
                "6af71da3501cca046a166045",
                "2026-11-23 16:30",
                "Dolor abdominal",
                null
        );

        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @ParameterizedTest
    @EnumSource(EstadoCita.class)
    @DisplayName("Conservar el estado recibido cuando la cita se crea con un estado válido")
    void shouldKeepReceivedStatus(EstadoCita estado) {
        CitaMedica cita = new CitaMedica(
                "6af71e0b501cca046a166049",
                "6af7271e501cca046a16604f",
                "6af71da3501cca046a166045",
                "2026-11-23 16:30",
                "Dolor abdominal",
                estado
        );

        assertEquals(estado, cita.getEstado());
    }

    @Test
    @DisplayName("Rechazar la creación de una cita médica sin fecha y hora")
    void shouldRejectAppointmentWithoutDate() {
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("6af71e0b501cca046a166049", "6af7271e501cca046a16604f",
                        "6af71da3501cca046a166045", null, "Dolor abdominal", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Rechazar la creación de una cita médica con fecha y hora de formato inválido")
    void shouldRejectAppointmentWithInvalidDateFormat() {
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("6af71e0b501cca046a166049", "6af7271e501cca046a16604f",
                        "6af71da3501cca046a166045", "23/11/2026 16:30", "Dolor abdominal", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Rechazar la creación de una cita médica con una fecha inexistente")
    void shouldRejectAppointmentWithNonExistentDate() {
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("6af71e0b501cca046a166049", "6af7271e501cca046a16604f",
                        "6af71da3501cca046a166045", "2026-02-30 10:00", "Dolor abdominal", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Rechazar la creación de una cita médica con motivo vacío")
    void shouldRejectAppointmentWithBlankReason() {
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("6af71e0b501cca046a166049", "6af7271e501cca046a16604f",
                        "6af71da3501cca046a166045", "2026-11-23 16:30", "", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Rechazar la creación de una cita médica con motivo compuesto solo por espacios")
    void shouldRejectAppointmentWithWhitespaceOnlyReason() {
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("6af71e0b501cca046a166049", "6af7271e501cca046a16604f",
                        "6af71da3501cca046a166045", "2026-11-23 16:30", "   ", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Rechazar la creación de una cita médica sin motivo")
    void shouldRejectAppointmentWithoutReason() {
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("6af71e0b501cca046a166049", "6af7271e501cca046a16604f",
                        "6af71da3501cca046a166045", "2026-11-23 16:30", null, EstadoCita.PROGRAMADA));
    }
}
