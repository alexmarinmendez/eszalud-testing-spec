package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Pruebas del modelo CitaMedica")
class CitaMedicaTest {

    // CIT-001
    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 15, 9, 30);

        CitaMedica cita = new CitaMedica(
                "pac-001",
                "doc-001",
                "esp-001",
                fechaHora,
                "Control de presión arterial",
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);
        assertEquals("pac-001", cita.getPaciente());
        assertEquals("doc-001", cita.getDoctor());
        assertEquals("esp-001", cita.getEspecialidad());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("Control de presión arterial", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    // CIT-002
    @Test
    @DisplayName("Rechazar la creación de una cita sin paciente")
    void shouldRejectAppointmentWithoutPatient() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        null,
                        "doc-001",
                        "esp-001",
                        LocalDateTime.of(2026, 12, 15, 9, 30),
                        "Control de presión arterial",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    // CIT-003
    @Test
    @DisplayName("Rechazar la creación de una cita sin doctor")
    void shouldRejectAppointmentWithoutDoctor() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "pac-001",
                        null,
                        "esp-001",
                        LocalDateTime.of(2026, 12, 15, 9, 30),
                        "Control de presión arterial",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    // CIT-004
    @Test
    @DisplayName("Rechazar la creación de una cita sin especialidad")
    void shouldRejectAppointmentWithoutSpecialty() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "pac-001",
                        "doc-001",
                        null,
                        LocalDateTime.of(2026, 12, 15, 9, 30),
                        "Control de presión arterial",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    // CIT-005
    @Test
    @DisplayName("Rechazar la creación de una cita sin fecha y hora")
    void shouldRejectAppointmentWithoutDateTime() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "pac-001",
                        "doc-001",
                        "esp-001",
                        null,
                        "Control de presión arterial",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    // CIT-006 (regla documentada en DECISIONES.md)
    @Test
    @DisplayName("Asignar el estado PROGRAMADA cuando la cita se crea sin estado")
    void shouldAssignScheduledStatusWhenStatusIsNull() {
        CitaMedica cita = new CitaMedica(
                "pac-001",
                "doc-001",
                "esp-001",
                LocalDateTime.of(2026, 12, 15, 9, 30),
                "Control de presión arterial",
                null
        );

        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    // CIT-007
    @Test
    @DisplayName("Conservar el estado válido recibido al crear la cita")
    void shouldKeepValidStatusWhenAppointmentIsCreated() {
        CitaMedica cita = new CitaMedica(
                "pac-001",
                "doc-001",
                "esp-001",
                LocalDateTime.of(2026, 11, 10, 16, 0),
                "Control de presión arterial",
                EstadoCita.ATENDIDA
        );

        assertEquals(EstadoCita.ATENDIDA, cita.getEstado());
    }
}