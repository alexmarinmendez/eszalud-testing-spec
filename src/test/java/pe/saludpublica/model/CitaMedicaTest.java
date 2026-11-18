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
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 19, 10, 30);

        CitaMedica cita = new CitaMedica(
                "PAC-001",
                "DOC-001",
                "ESP-001",
                fechaHora,
                "Consulta de control",
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);
        assertEquals("PAC-001", cita.getPaciente());
        assertEquals("DOC-001", cita.getDoctor());
        assertEquals("ESP-001", cita.getEspecialidad());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("Consulta de control", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin identificador de paciente")
    void shouldRejectAppointmentWithoutPatient() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 19, 10, 30);

        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        null,
                        "DOC-001",
                        "ESP-001",
                        fechaHora,
                        "Consulta de control",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin identificador de doctor")
    void shouldRejectAppointmentWithoutDoctor() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 19, 10, 30);

        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC-001",
                        null,
                        "ESP-001",
                        fechaHora,
                        "Consulta de control",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin identificador de especialidad")
    void shouldRejectAppointmentWithoutSpecialty() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 19, 10, 30);

        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC-001",
                        "DOC-001",
                        null,
                        fechaHora,
                        "Consulta de control",
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
                        "Consulta de control",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin estado")
    void shouldRejectAppointmentWithoutStatus() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 19, 10, 30);

        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC-001",
                        "DOC-001",
                        "ESP-001",
                        fechaHora,
                        "Consulta de control",
                        null
                )
        );
    }

    @Test
    @DisplayName("Conservar cada estado válido recibido por la cita")
    void shouldPreserveValidAppointmentStatus() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 19, 10, 30);

        for (EstadoCita estado : EstadoCita.values()) {
            CitaMedica cita = new CitaMedica(
                    "PAC-001",
                    "DOC-001",
                    "ESP-001",
                    fechaHora,
                    "Consulta de control",
                    estado
            );

            assertEquals(estado, cita.getEstado());
        }
    }

    @Test
    @DisplayName("Conservar los atributos de la cita después de construirla")
    void shouldPreserveAppointmentAttributesAfterConstruction() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 20, 15, 45);

        CitaMedica cita = new CitaMedica(
                "PAC-002",
                "DOC-002",
                "ESP-002",
                fechaHora,
                "Revisión de resultados",
                EstadoCita.ATENDIDA
        );

        assertEquals("PAC-002", cita.getPaciente());
        assertEquals("DOC-002", cita.getDoctor());
        assertEquals("ESP-002", cita.getEspecialidad());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("Revisión de resultados", cita.getMotivo());
        assertEquals(EstadoCita.ATENDIDA, cita.getEstado());
    }
}
