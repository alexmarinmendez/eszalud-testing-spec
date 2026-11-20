package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    @Test
    @DisplayName("CIT-001: Crear cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        CitaMedica cita = new CitaMedica(
                "PAC-001",
                "DOC-001",
                "ESP-001",
                "2026-11-23 16:30",
                "Dolor abdominal",
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);
        assertAll(
                () -> assertEquals("PAC-001", cita.getPaciente()),
                () -> assertEquals("DOC-001", cita.getDoctor()),
                () -> assertEquals("ESP-001", cita.getEspecialidad()),
                () -> assertEquals("2026-11-23 16:30", cita.getFechaHora()),
                () -> assertEquals("Dolor abdominal", cita.getMotivo()),
                () -> assertEquals(EstadoCita.PROGRAMADA, cita.getEstado())
        );
    }

    @Test
    @DisplayName("CIT-002: Rechazar paciente nulo")
    void shouldRejectNullPatient() {
        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica(null, "DOC-001", "ESP-001",
                        "2026-11-23 16:30", "Dolor abdominal",
                        EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("CIT-003: Rechazar doctor nulo")
    void shouldRejectNullDoctor() {
        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica("PAC-001", null, "ESP-001",
                        "2026-11-23 16:30", "Dolor abdominal",
                        EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("CIT-004: Rechazar especialidad nula")
    void shouldRejectNullSpecialty() {
        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica("PAC-001", "DOC-001", null,
                        "2026-11-23 16:30", "Dolor abdominal",
                        EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("CIT-005: Rechazar fecha y hora nula")
    void shouldRejectNullDateTime() {
        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica("PAC-001", "DOC-001", "ESP-001",
                        null, "Dolor abdominal",
                        EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("CIT-006: Rechazar estado nulo")
    void shouldRejectNullStatus() {
        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica("PAC-001", "DOC-001", "ESP-001",
                        "2026-11-23 16:30", "Dolor abdominal", null)
        );
    }

    @Test
    @DisplayName("CIT-007: Aceptar estado ATENDIDA")
    void shouldAcceptAttendedStatus() {
        CitaMedica cita = new CitaMedica(
                "PAC-001",
                "DOC-001",
                "ESP-001",
                "2026-11-23 16:30",
                "Dolor abdominal",
                EstadoCita.ATENDIDA
        );

        assertEquals(EstadoCita.ATENDIDA, cita.getEstado());
    }

    @Test
    @DisplayName("CIT-008: Verificar atributos de la cita")
    void shouldExposeAppointmentAttributesThroughGetters() {
        CitaMedica cita = new CitaMedica(
                "PAC-002",
                "DOC-002",
                "ESP-002",
                "2026-11-24 10:00",
                "Control médico",
                EstadoCita.CANCELADA
        );

        assertAll(
                () -> assertEquals("PAC-002", cita.getPaciente()),
                () -> assertEquals("DOC-002", cita.getDoctor()),
                () -> assertEquals("ESP-002", cita.getEspecialidad()),
                () -> assertEquals("2026-11-24 10:00", cita.getFechaHora()),
                () -> assertEquals("Control médico", cita.getMotivo()),
                () -> assertEquals(EstadoCita.CANCELADA, cita.getEstado())
        );
    }
}