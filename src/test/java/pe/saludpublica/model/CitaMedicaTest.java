
package pe.saludpublica.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class CitaMedicaTest {

    @Test
    @DisplayName("CIT-001: Crear cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {

        LocalDateTime fecha = LocalDateTime.of(
                2026, 12, 10, 10, 30
        );

        CitaMedica cita = new CitaMedica(
                "PAC001",
                "DOC001",
                "ESP001",
                fecha,
                "Consulta general",
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);
        assertEquals("PAC001", cita.getPaciente());
        assertEquals("DOC001", cita.getDoctor());
        assertEquals("ESP001", cita.getEspecialidad());
        assertEquals(fecha, cita.getFechaHora());
        assertEquals("Consulta general", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }


    @Test
    @DisplayName("CIT-002: Rechazar cita sin paciente")
    void shouldRejectAppointmentWithoutPatient() {

        LocalDateTime fecha = LocalDateTime.of(
                2026, 12, 10, 10, 30
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        null,
                        "DOC001",
                        "ESP001",
                        fecha,
                        "Consulta general",
                        EstadoCita.PROGRAMADA
                )
        );
    }


    @Test
    @DisplayName("CIT-003: Rechazar cita sin doctor")
    void shouldRejectAppointmentWithoutDoctor() {

        LocalDateTime fecha = LocalDateTime.of(
                2026, 12, 10, 10, 30
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC001",
                        null,
                        "ESP001",
                        fecha,
                        "Consulta general",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    @Test
    @DisplayName("CIT-004: Rechazar cita sin especialidad")
    void shouldRejectAppointmentWithoutSpecialty() {

        LocalDateTime fecha = LocalDateTime.of(
                2026, 12, 10, 10, 30
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC001",
                        "DOC001",
                        null,
                        fecha,
                        "Consulta general",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    @Test
    @DisplayName("CIT-005: Rechazar cita sin fecha y hora")
    void shouldRejectAppointmentWithoutDateTime() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC001",
                        "DOC001",
                        "ESP001",
                        null,
                        "Consulta general",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    @Test
    @DisplayName("CIT-006: Asignar PROGRAMADA cuando el estado es null")
    void shouldDefaultToScheduledWhenStateIsNull() {

        LocalDateTime fecha = LocalDateTime.of(
                2026, 12, 10, 10, 30
        );

        CitaMedica cita = new CitaMedica(
                "PAC001",
                "DOC001",
                "ESP001",
                fecha,
                "Consulta general",
                null
        );

        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }


    @Test
    @DisplayName("CIT-007: Conservar un estado válido")
    void shouldPreserveValidAppointmentState() {

        LocalDateTime fecha = LocalDateTime.of(
                2026, 12, 10, 10, 30
        );

        CitaMedica cita = new CitaMedica(
                "PAC001",
                "DOC001",
                "ESP001",
                fecha,
                "Consulta general",
                EstadoCita.ATENDIDA
        );

        assertNotNull(cita);
        assertEquals(EstadoCita.ATENDIDA, cita.getEstado());
    }


    @Test
    @DisplayName("CIT-008: Verificar los atributos de la cita médica")
    void shouldPreserveAppointmentAttributesAfterConstruction() {

        LocalDateTime fecha = LocalDateTime.of(
                2026, 12, 15, 11, 0
        );

        CitaMedica cita = new CitaMedica(
                "PAC002",
                "DOC002",
                "ESP002",
                fecha,
                "Control médico",
                EstadoCita.CANCELADA
        );

        assertNotNull(cita);

        assertEquals("PAC002", cita.getPaciente());
        assertEquals("DOC002", cita.getDoctor());
        assertEquals("ESP002", cita.getEspecialidad());
        assertEquals(fecha, cita.getFechaHora());
        assertEquals("Control médico", cita.getMotivo());
        assertEquals(EstadoCita.CANCELADA, cita.getEstado());
    }


}
