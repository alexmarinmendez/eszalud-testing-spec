package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertAll;
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

    // CIT-008
    @Test
    @DisplayName("Verificar que cada atributo conserve su valor después de construir la cita")
    void shouldKeepEachAttributeWhenAppointmentIsCreated() {
        LocalDateTime fechaHora = LocalDateTime.of(2027, 1, 20, 11, 45);

        CitaMedica cita = new CitaMedica(
                "pac-077",
                "doc-042",
                "esp-003",
                fechaHora,
                "Evaluación pediátrica de rutina",
                EstadoCita.CANCELADA
        );

        assertAll(
                () -> assertEquals("pac-077", cita.getPaciente(), "paciente"),
                () -> assertEquals("doc-042", cita.getDoctor(), "doctor"),
                () -> assertEquals("esp-003", cita.getEspecialidad(), "especialidad"),
                () -> assertEquals(fechaHora, cita.getFechaHora(), "fechaHora"),
                () -> assertEquals("Evaluación pediátrica de rutina", cita.getMotivo(), "motivo"),
                () -> assertEquals(EstadoCita.CANCELADA, cita.getEstado(), "estado")
        );
    }

    // CIT-009 (recomendada, regla documentada en DECISIONES.md)
    @Test
    @DisplayName("Aceptar una cita con motivo vacío porque el motivo es opcional")
    void shouldAcceptAppointmentWithEmptyReasonWhenReasonIsOptional() {
        CitaMedica cita = new CitaMedica(
                "pac-001",
                "doc-001",
                "esp-001",
                LocalDateTime.of(2026, 12, 15, 9, 30),
                "",
                EstadoCita.PROGRAMADA
        );

        assertEquals("", cita.getMotivo());
    }

    // CIT-010 (recomendada)
    @Test
    @DisplayName("Rechazar una fecha y hora inválidas antes de crear la cita")
    void shouldRejectInvalidDateTimeBeforeCreatingAppointment() {
        assertThrows(
                DateTimeException.class,
                () -> new CitaMedica(
                        "pac-001",
                        "doc-001",
                        "esp-001",
                        LocalDateTime.of(2026, 2, 30, 10, 0),
                        "Control de presión arterial",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    // CIT-011 (recomendada, regla documentada en DECISIONES.md)
    @Test
    @DisplayName("Aceptar una cita con fecha pasada porque se permite registrar el historial")
    void shouldAcceptAppointmentWithPastDateWhenHistoryIsAllowed() {
        LocalDateTime fechaPasada = LocalDateTime.of(2020, 3, 10, 8, 0);

        CitaMedica cita = new CitaMedica(
                "pac-001",
                "doc-001",
                "esp-001",
                fechaPasada,
                "Control anual",
                EstadoCita.ATENDIDA
        );

        assertEquals(fechaPasada, cita.getFechaHora());
    }

    // CIT-016 (recomendada, regla documentada en DECISIONES.md)
    @Test
    @DisplayName("Aceptar una cita con motivo compuesto solo por espacios porque el motivo es opcional")
    void shouldAcceptAppointmentWithBlankReasonWhenReasonIsOptional() {
        CitaMedica cita = new CitaMedica(
                "pac-001",
                "doc-001",
                "esp-001",
                LocalDateTime.of(2026, 12, 15, 9, 30),
                "   ",
                EstadoCita.PROGRAMADA
        );

        assertEquals("   ", cita.getMotivo());
    }
}