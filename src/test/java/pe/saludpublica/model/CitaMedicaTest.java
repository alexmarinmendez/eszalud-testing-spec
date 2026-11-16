package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CitaMedicaTest {

    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {

        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 1, 9, 30);

        CitaMedica cita = new CitaMedica(
                "PAC-001",
                "DOC-001",
                "ESP-001",
                fechaHora,
                "Control de rutina",
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);

        assertEquals("PAC-001", cita.getPaciente());
        assertEquals("DOC-001", cita.getDoctor());
        assertEquals("ESP-001", cita.getEspecialidad());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("Control de rutina", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }
    @Test
    @DisplayName("Rechazar la creación de una cita sin identificador de paciente")
    void shouldRejectAppointmentWithoutPatient() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        null,
                        "DOC-001",
                        "ESP-001",
                        LocalDateTime.of(2026, 12, 1, 9, 30),
                        "Control de rutina",
                        EstadoCita.PROGRAMADA
                )
        );
    }
    @Test
    @DisplayName("Rechazar la creación de una cita sin identificador de doctor")
    void shouldRejectAppointmentWithoutDoctor() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC-001",
                        null,
                        "ESP-001",
                        LocalDateTime.of(2026, 12, 1, 9, 30),
                        "Control de rutina",
                        EstadoCita.PROGRAMADA
                )
        );
    }
    @Test
    @DisplayName("Rechazar la creación de una cita sin identificador de especialidad")
    void shouldRejectAppointmentWithoutSpecialty() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC-001",
                        "DOC-001",
                        null,
                        LocalDateTime.of(2026, 12, 1, 9, 30),
                        "Control de rutina",
                        EstadoCita.PROGRAMADA
                )
        );
    }
    @Test
    @DisplayName("Rechazar la creación de una cita sin fecha y hora")
    void shouldRejectAppointmentWithoutDateTime() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC-001",
                        "DOC-001",
                        "ESP-001",
                        null,
                        "Control de rutina",
                        EstadoCita.PROGRAMADA
                )
        );
    }
    @Test
    @DisplayName("Asignar el estado PROGRAMADA cuando el estado recibido es nulo")
    void shouldAssignScheduledStatusWhenStatusIsNull() {

        CitaMedica cita = new CitaMedica(
                "PAC-001",
                "DOC-001",
                "ESP-001",
                LocalDateTime.of(2026, 12, 1, 9, 30),
                "Control de rutina",
                null
        );

        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }
    @Test
    @DisplayName("Conservar el estado válido recibido al crear una cita")
    void shouldKeepValidStatusWhenCreatingAppointment() {

        CitaMedica cita = new CitaMedica(
                "PAC-001",
                "DOC-001",
                "ESP-001",
                LocalDateTime.of(2026, 12, 1, 9, 30),
                "Control de rutina",
                EstadoCita.ATENDIDA
        );

        assertEquals(EstadoCita.ATENDIDA, cita.getEstado());
    }
}
