package pe.saludpublica.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    Paciente paciente = new Paciente("12345678", "Ana", "Pérez", "987654321", "ana@mail.com");
    Doctor doctor = new Doctor("76543210", "Carlos", "Mendoza", "CMP12345", "Cardiología");
    Especialidad especialidad = new Especialidad("ESP01", "Cardiología");

    // Usamos una fecha futura para pasar la validación de fecha correcta
    LocalDateTime fechaHora = LocalDateTime.now().plusDays(5);
    String motivo = "Chequeo general";

    @Test
    @DisplayName("CIT-001 y CIT-008: Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        CitaMedica cita = new CitaMedica("CITA-001", paciente, doctor, especialidad, fechaHora, motivo, EstadoCita.PROGRAMADA);

        assertNotNull(cita);
        assertEquals("CITA-001", cita.getCodigo());
        assertEquals(paciente, cita.getPaciente());
        assertEquals(doctor, cita.getDoctor());
        assertEquals(especialidad, cita.getEspecialidad());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals(motivo, cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("CIT-002 a CIT-005: Rechazar datos obligatorios nulos")
    void shouldRejectNullMandatoryFields() {
        assertThrows(IllegalArgumentException.class, () -> new CitaMedica("CITA-001", null, doctor, especialidad, fechaHora, motivo, EstadoCita.PROGRAMADA));
        assertThrows(IllegalArgumentException.class, () -> new CitaMedica("CITA-001", paciente, null, especialidad, fechaHora, motivo, EstadoCita.PROGRAMADA));
        assertThrows(IllegalArgumentException.class, () -> new CitaMedica("CITA-001", paciente, doctor, null, fechaHora, motivo, EstadoCita.PROGRAMADA));
        assertThrows(IllegalArgumentException.class, () -> new CitaMedica("CITA-001", paciente, doctor, especialidad, null, motivo, EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("CIT-006: Crear cita con estado null aplica comportamiento predeterminado")
    void shouldApplyDefaultStatusWhenNull() {
        CitaMedica cita = new CitaMedica("CITA-001", paciente, doctor, especialidad, fechaHora, motivo, null);
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("CIT-007, CIT-012, CIT-013, CIT-014: Conservar estados válidos")
    void shouldKeepValidStatus() {
        CitaMedica citaProg = new CitaMedica("CITA-001", paciente, doctor, especialidad, fechaHora, motivo, EstadoCita.PROGRAMADA);
        assertEquals(EstadoCita.PROGRAMADA, citaProg.getEstado());

        CitaMedica citaAten = new CitaMedica("CITA-002", paciente, doctor, especialidad, fechaHora, motivo, EstadoCita.ATENDIDA);
        assertEquals(EstadoCita.ATENDIDA, citaAten.getEstado());

        CitaMedica citaCanc = new CitaMedica("CITA-003", paciente, doctor, especialidad, fechaHora, motivo, EstadoCita.CANCELADA);
        assertEquals(EstadoCita.CANCELADA, citaCanc.getEstado());
    }

    @Test
    @DisplayName("CIT-009 y CIT-016: Rechazar motivo vacío o con espacios")
    void shouldRejectEmptyMotivo() {
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("CITA-001", paciente, doctor, especialidad, fechaHora, "", EstadoCita.PROGRAMADA));
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("CITA-001", paciente, doctor, especialidad, fechaHora, "   ", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("CIT-011: Rechazar cita con fecha pasada")
    void shouldRejectPastDate() {
        LocalDateTime fechaPasada = LocalDateTime.now().minusDays(1);
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("CITA-001", paciente, doctor, especialidad, fechaPasada, motivo, EstadoCita.PROGRAMADA));
    }
}