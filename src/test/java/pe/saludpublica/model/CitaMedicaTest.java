package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {

        CitaMedica cita = new CitaMedica(
                "6af71f49501cca046a16604b",
                "6af73013901d08b4673bfa5",
                "6af71da3501cca046a166048",
                LocalDateTime.of(2026, 11, 26, 10, 5),
                "Acné excesivo",
                "PROGRAMADA"
        );

        assertNotNull(cita);
        assertEquals("6af71f49501cca046a16604b", cita.getPaciente());
        assertEquals("6af73013901d08b4673bfa5", cita.getDoctor());
        assertEquals("6af71da3501cca046a166048", cita.getEspecialidad());
        assertEquals(LocalDateTime.of(2026, 11, 26, 10, 5), cita.getFechaHora());
        assertEquals("Acné excesivo", cita.getMotivo());
        assertEquals("PROGRAMADA", cita.getEstado());
    }

    @Test
    @DisplayName("Rechazar una cita médica cuando el paciente es nulo")
    void shouldThrowExceptionWhenPatientIsNull() {

        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica(
                        null,
                        "6af73013901d08b4673bfa5",
                        "6af71da3501cca046a166048",
                        LocalDateTime.of(2026, 11, 26, 10, 5),
                        "Acné excesivo",
                        "PROGRAMADA"
                )
        );
    }
    @Test
    @DisplayName("Rechazar una cita médica cuando el doctor es nulo")
    void shouldThrowExceptionWhenDoctorIsNull() {

        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica(
                        "6af71f49501cca046a16604b",
                        null,
                        "6af71da3501cca046a166048",
                        LocalDateTime.of(2026, 11, 26, 10, 5),
                        "Acné excesivo",
                        "PROGRAMADA"
                )
        );
    }
    @Test
    @DisplayName("Rechazar una cita médica cuando la especialidad es nula")
    void shouldThrowExceptionWhenSpecialtyIsNull() {

        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica(
                        "6af71f49501cca046a16604b",
                        "6af73013901d08b4673bfa5",
                        null,
                        LocalDateTime.of(2026, 11, 26, 10, 5),
                        "Acné excesivo",
                        "PROGRAMADA"
                )
        );
    }
    @Test
    @DisplayName("Rechazar una cita médica cuando la fecha y hora son nulas")
    void shouldThrowExceptionWhenDateTimeIsNull() {

        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica(
                        "6af71f49501cca046a16604b",
                        "6af73013901d08b4673bfa5",
                        "6af71da3501cca046a166048",
                        null,
                        "Acné excesivo",
                        "PROGRAMADA"
                )
        );
    }
}