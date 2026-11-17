
package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    @Test
    @DisplayName("CIT-001: Crear cita médica con datos válidos")
    void shouldCreateMedicalAppointmentWithValidData() {

        LocalDateTime fechaHora = LocalDateTime.of(
                2026, 11, 20, 10, 30
        );

        CitaMedica cita = new CitaMedica(
                "PAC001",
                "DOC001",
                "ESP001",
                fechaHora,
                "PROGRAMADA"
        );

        assertNotNull(cita);

        assertAll(
                () -> assertEquals("PAC001", cita.getPacienteId()),
                () -> assertEquals("DOC001", cita.getDoctorId()),
                () -> assertEquals("ESP001", cita.getEspecialidadId()),
                () -> assertEquals(fechaHora, cita.getFechaHora()),
                () -> assertEquals("PROGRAMADA", cita.getEstado())
        );
    }

    @Test
    @DisplayName("CIT-002: Crear cita médica sin identificador del paciente")
    void shouldRejectAppointmentWithoutPatientId() {

        LocalDateTime fechaHora = LocalDateTime.of(
                2026, 11, 20, 10, 30
        );

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
    @DisplayName("CIT-003: Crear cita médica sin identificador del doctor")
    void shouldRejectAppointmentWithoutDoctorId() {

        LocalDateTime fechaHora = LocalDateTime.of(
                2026, 11, 20, 10, 30
        );

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
    @DisplayName("CIT-004: Crear cita médica sin identificador de especialidad")
    void shouldRejectAppointmentWithoutSpecialtyId() {

        LocalDateTime fechaHora = LocalDateTime.of(
                2026, 11, 20, 10, 30
        );

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
    @DisplayName("CIT-005: Crear cita médica sin fecha y hora")
    void shouldRejectAppointmentWithoutDateTime() {

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
    @DisplayName("CIT-006: Crear cita médica sin estado")
    void shouldAssignDefaultStatusWhenNull() {

        LocalDateTime fechaHora = LocalDateTime.of(
                2026, 11, 20, 10, 30
        );

        CitaMedica cita = new CitaMedica(
                "PAC001",
                "DOC001",
                "ESP001",
                fechaHora,
                null
        );

        assertEquals("PROGRAMADA", cita.getEstado());
    }

    @Test
    @DisplayName("CIT-007: Crear cita médica con estado válido")
    void shouldPreserveValidAppointmentStatus() {

        LocalDateTime fechaHora = LocalDateTime.of(
                2026, 11, 20, 10, 30
        );

        CitaMedica cita = new CitaMedica(
                "PAC001",
                "DOC001",
                "ESP001",
                fechaHora,
                "CANCELADA"
        );

        assertEquals("CANCELADA", cita.getEstado());
    }

    @Test
    @DisplayName("CIT-008: Verificar los getters de la cita médica")
    void shouldReturnAppointmentAttributesThroughGetters() {

        LocalDateTime fechaHora = LocalDateTime.of(
                2026, 11, 20, 10, 30
        );

        CitaMedica cita = new CitaMedica(
                "PAC001",
                "DOC001",
                "ESP001",
                fechaHora,
                "PROGRAMADA"
        );

        assertAll(
                "Verificar atributos de la cita médica",
                () -> assertEquals("PAC001", cita.getPacienteId()),
                () -> assertEquals("DOC001", cita.getDoctorId()),
                () -> assertEquals("ESP001", cita.getEspecialidadId()),
                () -> assertEquals(fechaHora, cita.getFechaHora()),
                () -> assertEquals("PROGRAMADA", cita.getEstado())
        );
    }

}