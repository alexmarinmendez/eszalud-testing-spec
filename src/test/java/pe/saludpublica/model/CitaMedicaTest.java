package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    @Test
    @DisplayName("Crear cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        LocalDateTime fechaHora = LocalDateTime.now().plusDays(1);
        CitaMedica cita = new CitaMedica(
                "PAC-01",
                "DOC-01",
                "ESP-01",
                fechaHora,
                "Consulta general",
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);
        assertEquals("PAC-01", cita.getPaciente());
        assertEquals("DOC-01", cita.getDoctor());
        assertEquals("ESP-01", cita.getEspecialidad());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("Consulta general", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Rechazar cita sin identificador de paciente")
    void shouldRejectAppointmentWithoutPatient() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(null, "DOC-01", "ESP-01", LocalDateTime.now().plusDays(1), "Motivo", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Rechazar cita sin identificador de doctor")
    void shouldRejectAppointmentWithoutDoctor() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica("PAC-01", null, "ESP-01", LocalDateTime.now().plusDays(1), "Motivo", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Rechazar cita sin identificador de especialidad")
    void shouldRejectAppointmentWithoutSpecialty() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica("PAC-01", "DOC-01", null, LocalDateTime.now().plusDays(1), "Motivo", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Rechazar cita sin fecha y hora")
    void shouldRejectAppointmentWithoutDateTime() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica("PAC-01", "DOC-01", "ESP-01", null, "Motivo", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Crear cita con estado null aplica estado PROGRAMADA por defecto")
    void shouldAssignDefaultStatusWhenStatusIsNull() {
        CitaMedica cita = new CitaMedica("PAC-01", "DOC-01", "ESP-01", LocalDateTime.now().plusDays(1), "Motivo", null);
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Crear cita con un estado válido conserva dicho estado")
    void shouldKeepValidStatusWhenProvided() {
        CitaMedica citaAtendida = new CitaMedica("PAC-01", "DOC-01", "ESP-01", LocalDateTime.now().plusDays(1), "Motivo", EstadoCita.ATENDIDA);
        assertEquals(EstadoCita.ATENDIDA, citaAtendida.getEstado());
    }
}