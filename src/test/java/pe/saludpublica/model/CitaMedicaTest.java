package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CitaMedicaTest {

    @Test
    @DisplayName("Debe crear una cita médica correctamente cuando los datos son válidos")
    void shouldCreateAppointmentWhenDataIsValid() {
        LocalDateTime now = LocalDateTime.now();
        CitaMedica cita = new CitaMedica(
                "PAC-001",
                "DOC-001",
                "ESP-001",
                now,
                "Control general",
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);
        assertEquals("PAC-001", cita.getPaciente());
        assertEquals("DOC-001", cita.getDoctor());
        assertEquals("ESP-001", cita.getEspecialidad());
        assertEquals(now, cita.getFechaHora());
        assertEquals("Control general", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Debe lanzar IllegalArgumentException cuando el paciente es nulo")
    void shouldRejectAppointmentWhenPatientIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new CitaMedica(
                null,
                "DOC-001",
                "ESP-001",
                LocalDateTime.now(),
                "Control general",
                EstadoCita.PROGRAMADA
        ));
    }

    @Test
    @DisplayName("Debe lanzar IllegalArgumentException cuando el doctor es nulo")
    void shouldRejectAppointmentWhenDoctorIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new CitaMedica(
                "PAC-001",
                null,
                "ESP-001",
                LocalDateTime.now(),
                "Control general",
                EstadoCita.PROGRAMADA
        ));
    }

    @Test
    @DisplayName("Debe lanzar IllegalArgumentException cuando la especialidad es nula")
    void shouldRejectAppointmentWhenSpecialtyIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new CitaMedica(
                "PAC-001",
                "DOC-001",
                null,
                LocalDateTime.now(),
                "Control general",
                EstadoCita.PROGRAMADA
        ));
    }

    @Test
    @DisplayName("Debe lanzar IllegalArgumentException cuando la fecha y hora son nulas")
    void shouldRejectAppointmentWhenDateTimeIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new CitaMedica(
                "PAC-001",
                "DOC-001",
                "ESP-001",
                null,
                "Control general",
                EstadoCita.PROGRAMADA
        ));
    }

    @Test
    @DisplayName("Debe asignar EstadoCita.PROGRAMADA por defecto cuando el estado es nulo")
    void shouldAssignDefaultProgramadaStateWhenStateIsNull() {
        LocalDateTime now = LocalDateTime.now();
        CitaMedica cita = new CitaMedica(
                "PAC-001",
                "DOC-001",
                "ESP-001",
                now,
                "Control general",
                null
        );

        assertNotNull(cita);
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }
}
