package com.eszalud.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
public class CitaMedicaTest {
    @Test
    @DisplayName("CIT-001: Crear cita médica con datos válidos")
    void shouldCreateMedicalAppointmentWithValidData() {

        LocalDateTime fechaHora =
                LocalDateTime.of(2026, 11, 23, 16, 30);

        CitaMedica cita = new CitaMedica(
                "PAC001",
                "DOC001",
                "ESP001",
                fechaHora,
                "PROGRAMADA"
        );

        assertNotNull(cita);

        assertAll(
                () -> assertEquals("PAC001", cita.getIdPaciente()),
                () -> assertEquals("DOC001", cita.getIdDoctor()),
                () -> assertEquals("ESP001", cita.getIdEspecialidad()),
                () -> assertEquals(fechaHora, cita.getFechaHora()),
                () -> assertEquals("PROGRAMADA", cita.getEstado())
        );
    }

    @Test
    @DisplayName("CIT-002: Crear cita sin identificador de paciente")
    void shouldRejectMedicalAppointmentWithNullPatientId() {

        LocalDateTime fechaHora =
                LocalDateTime.of(2026, 11, 23, 16, 30);

        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        null,
                        "DOC001",
                        "ESP001",
                        fechaHora,
                        "PROGRAMADA"
                )
        );
    }

    @Test
    @DisplayName("CIT-003: Crear cita sin identificador de doctor")
    void shouldRejectMedicalAppointmentWithNullDoctorId() {

        LocalDateTime fechaHora =
                LocalDateTime.of(2026, 11, 23, 16, 30);

        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC001",
                        null,
                        "ESP001",
                        fechaHora,
                        "PROGRAMADA"
                )
        );
    }


    @Test
    @DisplayName("CIT-004: Crear cita sin identificador de especialidad")
    void shouldRejectMedicalAppointmentWithNullSpecialtyId() {

        LocalDateTime fechaHora =
                LocalDateTime.of(2026, 11, 23, 16, 30);

        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC001",
                        "DOC001",
                        null,
                        fechaHora,
                        "PROGRAMADA"
                )
        );
    }

    @Test
    @DisplayName("CIT-005: Crear cita sin fecha y hora")
    void shouldRejectMedicalAppointmentWithNullDateTime() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC001",
                        "DOC001",
                        "ESP001",
                        null,
                        "PROGRAMADA"
                )
        );
    }

    @Test
    @DisplayName("CIT-006: Crear cita con estado null")
    void shouldAssignDefaultStateWhenStateIsNull() {

        LocalDateTime fechaHora =
                LocalDateTime.of(2026, 11, 23, 16, 30);

        CitaMedica cita = new CitaMedica(
                "PAC001",
                "DOC001",
                "ESP001",
                fechaHora,
                null
        );

        assertNotNull(cita);
        assertEquals("PROGRAMADA", cita.getEstado());
    }

    @Test
    @DisplayName("CIT-007: Crear cita médica con estado válido")
    void shouldPreserveValidAppointmentState() {

        LocalDateTime fechaHora =
                LocalDateTime.of(2026, 11, 23, 16, 30);

        CitaMedica cita = new CitaMedica(
                "PAC001",
                "DOC001",
                "ESP001",
                fechaHora,
                "ATENDIDA"
        );

        assertNotNull(cita);
        assertEquals("ATENDIDA", cita.getEstado());
    }

    @Test
    @DisplayName("CIT-008: Verificar atributos de la cita médica")
    void shouldReturnCorrectMedicalAppointmentAttributes() {

        String idPaciente = "PAC002";
        String idDoctor = "DOC003";
        String idEspecialidad = "ESP002";

        LocalDateTime fechaHora =
                LocalDateTime.of(2026, 11, 26, 10, 5);

        String estado = "ATENDIDA";

        CitaMedica cita = new CitaMedica(
                idPaciente,
                idDoctor,
                idEspecialidad,
                fechaHora,
                estado
        );

        assertAll(
                () -> assertEquals(idPaciente, cita.getIdPaciente()),
                () -> assertEquals(idDoctor, cita.getIdDoctor()),
                () -> assertEquals(idEspecialidad, cita.getIdEspecialidad()),
                () -> assertEquals(fechaHora, cita.getFechaHora()),
                () -> assertEquals(estado, cita.getEstado())
        );
    }


}