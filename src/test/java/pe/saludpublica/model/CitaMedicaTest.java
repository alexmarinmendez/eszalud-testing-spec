package pe.saludpublica.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class CitaMedicaTest {

    private static final LocalDateTime FECHA_HORA =
            LocalDateTime.of(2026, 11, 25, 10, 30);

    @Test
    void cit001_createsAppointmentWithValidData() {
        CitaMedica cita = new CitaMedica(
                "PAC-001",
                "DOC-001",
                "ESP-001",
                FECHA_HORA,
                "Consulta de control",
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);
        assertAll(
                () -> assertEquals("PAC-001", cita.getPacienteId()),
                () -> assertEquals("DOC-001", cita.getDoctorId()),
                () -> assertEquals("ESP-001", cita.getEspecialidadId()),
                () -> assertEquals(FECHA_HORA, cita.getFechaHora()),
                () -> assertEquals("Consulta de control", cita.getMotivo()),
                () -> assertEquals(EstadoCita.PROGRAMADA, cita.getEstado())
        );
    }

    @Test
    void cit002_throwsExceptionWhenPatientIdIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica(
                        null,
                        "DOC-001",
                        "ESP-001",
                        FECHA_HORA,
                        "Consulta de control",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    @Test
    void cit003_throwsExceptionWhenDoctorIdIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica(
                        "PAC-001",
                        null,
                        "ESP-001",
                        FECHA_HORA,
                        "Consulta de control",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    @Test
    void cit004_throwsExceptionWhenSpecialtyIdIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica(
                        "PAC-001",
                        "DOC-001",
                        null,
                        FECHA_HORA,
                        "Consulta de control",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    @Test
    void cit005_throwsExceptionWhenDateTimeIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica(
                        "PAC-001",
                        "DOC-001",
                        "ESP-001",
                        null,
                        "Consulta de control",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    @Test
    void cit006_assignsScheduledStatusWhenStatusIsNull() {
        CitaMedica cita = new CitaMedica(
                "PAC-001",
                "DOC-001",
                "ESP-001",
                FECHA_HORA,
                "Consulta de control",
                null
        );

        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }
}
