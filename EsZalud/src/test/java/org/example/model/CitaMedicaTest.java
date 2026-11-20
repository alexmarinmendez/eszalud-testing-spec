package org.example.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CitaMedicaTest {

    private static final LocalDateTime FECHA_VALIDA = LocalDateTime.of(2026, 12, 10, 10, 30);

    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        CitaMedica cita = new CitaMedica(
                "12345678",
                "41234567",
                "Cardiología",
                FECHA_VALIDA,
                "Control general",
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);
        assertEquals("12345678", cita.getPaciente());
        assertEquals("41234567", cita.getDoctor());
        assertEquals("Cardiología", cita.getEspecialidad());
        assertEquals(FECHA_VALIDA, cita.getFechaHora());
        assertEquals("Control general", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin identificador de paciente")
    void shouldRejectAppointmentWithoutPatient() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(null, "41234567", "Cardiología", FECHA_VALIDA, "Control", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin identificador de doctor")
    void shouldRejectAppointmentWithoutDoctor() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica("12345678", null, "Cardiología", FECHA_VALIDA, "Control", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin identificador de especialidad")
    void shouldRejectAppointmentWithoutSpecialty() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica("12345678", "41234567", null, FECHA_VALIDA, "Control", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin fecha y hora")
    void shouldRejectAppointmentWithoutDateTime() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica("12345678", "41234567", "Cardiología", null, "Control", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Aplicar estado predeterminado PROGRAMADA cuando el estado es nulo")
    void shouldAssignProgramadaWhenStatusIsNull() {
        CitaMedica cita = new CitaMedica(
                "12345678",
                "41234567",
                "Cardiología",
                FECHA_VALIDA,
                "Control",
                null
        );

        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Conservar un estado válido en la cita médica")
    void shouldPreserveValidAppointmentStatus() {
        CitaMedica cita = new CitaMedica(
                "12345678",
                "41234567",
                "Cardiología",
                FECHA_VALIDA,
                "Control",
                EstadoCita.ATENDIDA
        );

        assertEquals(EstadoCita.ATENDIDA, cita.getEstado());
    }

    @Test
    @DisplayName("Verificar los atributos después de construir la cita médica")
    void shouldReturnExpectedAttributesAfterConstruction() {
        CitaMedica cita = new CitaMedica(
                "18205786",
                "45987123",
                "Pediatría",
                FECHA_VALIDA,
                "Consulta pediátrica",
                EstadoCita.CANCELADA
        );

        assertEquals("18205786", cita.getPaciente());
        assertEquals("45987123", cita.getDoctor());
        assertEquals("Pediatría", cita.getEspecialidad());
        assertEquals(FECHA_VALIDA, cita.getFechaHora());
        assertEquals("Consulta pediátrica", cita.getMotivo());
        assertEquals(EstadoCita.CANCELADA, cita.getEstado());
    }
}