package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CitaMedicaTest {

    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 10, 10, 30);

        CitaMedica cita = new CitaMedica(
                "PAC001",
                "DOC001",
                "ESP001",
                fechaHora,
                "Dolor de cabeza",
                EstadoCita.PROGRAMADA
        );

        assertEquals("PAC001", cita.getPacienteId());
        assertEquals("DOC001", cita.getDoctorId());
        assertEquals("ESP001", cita.getEspecialidadId());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("Dolor de cabeza", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Rechazar cita médica sin paciente")
    void shouldThrowExceptionWhenPatientIdIsNull() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 10, 10, 30);

        assertThrows(IllegalArgumentException.class, () -> {
            new CitaMedica(
                    null,
                    "DOC001",
                    "ESP001",
                    fechaHora,
                    "Dolor de cabeza",
                    EstadoCita.PROGRAMADA
            );
        });
    }

    @Test
    @DisplayName("Rechazar cita médica sin doctor")
    void shouldThrowExceptionWhenDoctorIdIsNull() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 10, 10, 30);

        assertThrows(IllegalArgumentException.class, () -> {
            new CitaMedica(
                    "PAC001",
                    null,
                    "ESP001",
                    fechaHora,
                    "Dolor de cabeza",
                    EstadoCita.PROGRAMADA
            );
        });
    }

    @Test
    @DisplayName("Rechazar cita médica sin fecha y hora")
    void shouldThrowExceptionWhenDateTimeIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CitaMedica(
                    "PAC001",
                    "DOC001",
                    "ESP001",
                    null,
                    "Dolor de cabeza",
                    EstadoCita.PROGRAMADA
            );
        });
    }

    @Test
    @DisplayName("Verificar que existan los estados de una cita médica")
    void shouldHaveValidAppointmentStatusValues() throws ClassNotFoundException {

        Class<?> estadoClass = Class.forName("pe.saludpublica.model.EstadoCita");
        assertTrue(estadoClass.isEnum());
        Object[] estados = estadoClass.getEnumConstants();

        assertArrayEquals(
                new String[]{"PROGRAMADA", "ATENDIDA", "CANCELADA"},
                Arrays.stream(estados)
                        .map(Object::toString)
                        .toArray(String[]::new)
        );
    }
}
