package pe.saludpublica.model;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {
    @Test
    @DisplayName("CIT-001 / CIT-008: Crear cita médica con datos válidos y verificar atributos")
    void shouldCreateAppointmentWithValidData() {
        LocalDateTime fecha = LocalDateTime.of(2026, 11, 25, 10, 30);
        CitaMedica cita = new CitaMedica("PAC-01", "DOC-01", "ESP-01", fecha, "Control general", EstadoCita.PROGRAMADA);
        assertNotNull(cita);
        assertEquals("PAC-01", cita.getPaciente());
        assertEquals("DOC-01", cita.getDoctor());
        assertEquals("ESP-01", cita.getEspecialidad());
        assertEquals(fecha, cita.getFechaHora());
        assertEquals("Control general", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("CIT-002: Rechazar cita médica sin identificador de paciente (null)")
    void shouldRejectAppointmentWithoutPatient() {
        LocalDateTime fecha = LocalDateTime.of(2026, 11, 25, 10, 30);
        assertThrows(IllegalArgumentException.class, () -> new CitaMedica(null, "DOC-01", "ESP-01", fecha, "Consulta", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("CIT-003: Rechazar cita médica sin identificador de doctor (null)")
    void shouldRejectAppointmentWithoutDoctor() {
        LocalDateTime fecha = LocalDateTime.of(2026, 11, 25, 10, 30);
        assertThrows(IllegalArgumentException.class, () -> new CitaMedica("PAC-01", null, "ESP-01", fecha, "Consulta", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("CIT-004: Rechazar cita médica sin identificador de especialidad (null)")
    void shouldRejectAppointmentWithoutSpecialty() {
        LocalDateTime fecha = LocalDateTime.of(2026, 11, 25, 10, 30);
        assertThrows(IllegalArgumentException.class, () -> new CitaMedica("PAC-01", "DOC-01", null, fecha, "Consulta", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("CIT-005: Rechazar cita médica sin fecha y hora (null)")
    void shouldRejectAppointmentWithoutDateTime() {
        assertThrows(IllegalArgumentException.class, () -> new CitaMedica("PAC-01", "DOC-01", "ESP-01", null, "Consulta", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("CIT-006: Asignar estado PROGRAMADA por defecto cuando el estado recibido es null")
    void shouldAssignDefaultScheduledStatusWhenStatusIsNull() {
        LocalDateTime fecha = LocalDateTime.of(2026, 11, 25, 10, 30);
        CitaMedica cita = new CitaMedica("PAC-01", "DOC-01", "ESP-01", fecha, "Consulta", null);
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("CIT-007 / CIT-013 / CIT-014: Conservar correctamente cualquier estado válido recibido")
    void shouldKeepValidAppointmentStatus() {
        LocalDateTime fecha = LocalDateTime.of(2026, 11, 25, 10, 30);
        CitaMedica citaAtendida = new CitaMedica("PAC-01", "DOC-01", "ESP-01", fecha, "Consulta", EstadoCita.ATENDIDA);
        CitaMedica citaCancelada = new CitaMedica("PAC-01", "DOC-01", "ESP-01", fecha, "Consulta", EstadoCita.CANCELADA);
        assertEquals(EstadoCita.ATENDIDA, citaAtendida.getEstado());
        assertEquals(EstadoCita.CANCELADA, citaCancelada.getEstado());
    }
}
