package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CitaMedicaTest {

    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {

        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 1, 10, 30);

        CitaMedica cita = new CitaMedica(
                "PAC-001",
                "DOC-001",
                "ESP-001",
                fechaHora,
                "Control general",
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);

        assertEquals("PAC-001", cita.getPaciente());
        assertEquals("DOC-001", cita.getDoctor());
        assertEquals("ESP-001", cita.getEspecialidad());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("Control general", cita.getMotivo());
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
                        LocalDateTime.of(2026, 12, 1, 10, 30),
                        "Control general",
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
                        LocalDateTime.of(2026, 12, 1, 10, 30),
                        "Control general",
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
                        LocalDateTime.of(2026, 12, 1, 10, 30),
                        "Control general",
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
                        "Control general",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    @Test
    @DisplayName("Asignar el estado PROGRAMADA cuando la cita se crea sin estado")
    void shouldAssignScheduledStatusWhenStatusIsNull() {

        CitaMedica cita = new CitaMedica(
                "PAC-001",
                "DOC-001",
                "ESP-001",
                LocalDateTime.of(2026, 12, 1, 10, 30),
                "Control general",
                null
        );

        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Conservar el estado recibido cuando es válido")
    void shouldKeepValidAppointmentStatus() {

        CitaMedica cita = new CitaMedica(
                "PAC-001",
                "DOC-001",
                "ESP-001",
                LocalDateTime.of(2026, 12, 1, 10, 30),
                "Control general",
                EstadoCita.ATENDIDA
        );

        assertEquals(EstadoCita.ATENDIDA, cita.getEstado());
    }

    @Test
    @DisplayName("Verificar los atributos de la cita después de construir el objeto")
    void shouldKeepAppointmentAttributesAfterConstruction() {

        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 5, 15, 0);

        CitaMedica cita = new CitaMedica(
                "PAC-002",
                "DOC-002",
                "ESP-002",
                fechaHora,
                "Dolor de cabeza",
                EstadoCita.CANCELADA
        );

        assertEquals("PAC-002", cita.getPaciente());
        assertEquals("DOC-002", cita.getDoctor());
        assertEquals("ESP-002", cita.getEspecialidad());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("Dolor de cabeza", cita.getMotivo());
        assertEquals(EstadoCita.CANCELADA, cita.getEstado());
    }
}