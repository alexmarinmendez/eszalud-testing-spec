package com.eszalud.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        Paciente paciente = new Paciente(
                "12345678", "Ana", "Pérez", "987654321", "ana@mail.com"
        );

        Doctor doctor = new Doctor(
                "87654321", "Luis", "García", "CMP12345", "CARD001"
        );

        Especialidad especialidad = new Especialidad(
                "CARD001", "Cardiología"
        );

        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 10, 10, 0);

        CitaMedica cita = new CitaMedica(
                paciente, doctor, especialidad, fechaHora, "PROGRAMADA"
        );

        assertNotNull(cita);
        assertEquals(paciente, cita.getPaciente());
        assertEquals(doctor, cita.getDoctor());
        assertEquals(especialidad, cita.getEspecialidad());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("PROGRAMADA", cita.getEstado());
    }

    @Test
    @DisplayName("Rechazar cita sin paciente")
    void shouldRejectAppointmentWithoutPatient() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        null,
                        new Doctor("87654321", "Luis", "García", "CMP12345", "CARD001"),
                        new Especialidad("CARD001", "Cardiología"),
                        LocalDateTime.of(2026, 12, 10, 10, 0),
                        "PROGRAMADA"
                )
        );
    }

    @Test
    @DisplayName("Rechazar cita sin doctor")
    void shouldRejectAppointmentWithoutDoctor() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        new Paciente("12345678", "Ana", "Pérez", "987654321", "ana@mail.com"),
                        null,
                        new Especialidad("CARD001", "Cardiología"),
                        LocalDateTime.of(2026, 12, 10, 10, 0),
                        "PROGRAMADA"
                )
        );
    }

    @Test
    @DisplayName("Rechazar cita sin especialidad")
    void shouldRejectAppointmentWithoutSpecialty() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        new Paciente("12345678", "Ana", "Pérez", "987654321", "ana@mail.com"),
                        new Doctor("87654321", "Luis", "García", "CMP12345", "CARD001"),
                        null,
                        LocalDateTime.of(2026, 12, 10, 10, 0),
                        "PROGRAMADA"
                )
        );
    }

    @Test
    @DisplayName("Rechazar cita sin fecha y hora")
    void shouldRejectAppointmentWithoutDateTime() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        new Paciente("12345678", "Ana", "Pérez", "987654321", "ana@mail.com"),
                        new Doctor("87654321", "Luis", "García", "CMP12345", "CARD001"),
                        new Especialidad("CARD001", "Cardiología"),
                        null,
                        "PROGRAMADA"
                )
        );
    }
    @Test
    @DisplayName("Rechazar cita sin estado")
    void shouldRejectAppointmentWithoutStatus() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        new Paciente("12345678", "Ana", "Pérez", "987654321", "ana@mail.com"),
                        new Doctor("87654321", "Luis", "García", "CMP12345", "CARD001"),
                        new Especialidad("CARD001", "Cardiología"),
                        LocalDateTime.of(2026, 12, 10, 10, 0),
                        null
                )
        );
    }

    @Test
    @DisplayName("Crear cita con estado válido")
    void shouldCreateAppointmentWithValidStatus() {
        CitaMedica cita = new CitaMedica(
                new Paciente("12345678", "Ana", "Pérez", "987654321", "ana@mail.com"),
                new Doctor("87654321", "Luis", "García", "CMP12345", "CARD001"),
                new Especialidad("CARD001", "Cardiología"),
                LocalDateTime.of(2026, 12, 10, 10, 0),
                "PROGRAMADA"
        );

        assertEquals("PROGRAMADA", cita.getEstado());
    }

    @Test
    @DisplayName("Verificar los atributos de la cita médica")
    void shouldReturnCorrectAppointmentAttributes() {
        Paciente paciente = new Paciente(
                "12345678", "Ana", "Pérez", "987654321", "ana@mail.com"
        );
        Doctor doctor = new Doctor(
                "87654321", "Luis", "García", "CMP12345", "CARD001"
        );
        Especialidad especialidad = new Especialidad("CARD001", "Cardiología");
        LocalDateTime fecha = LocalDateTime.of(2026, 12, 10, 10, 0);

        CitaMedica cita = new CitaMedica(
                paciente, doctor, especialidad, fecha, "PROGRAMADA"
        );

        assertAll(
                () -> assertEquals(paciente, cita.getPaciente()),
                () -> assertEquals(doctor, cita.getDoctor()),
                () -> assertEquals(especialidad, cita.getEspecialidad()),
                () -> assertEquals(fecha, cita.getFechaHora()),
                () -> assertEquals("PROGRAMADA", cita.getEstado())
        );
    }
}