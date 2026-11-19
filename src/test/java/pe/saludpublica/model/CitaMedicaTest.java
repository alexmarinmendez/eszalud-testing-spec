package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    @Test
    @DisplayName("CIT-001: Crear cita médica con datos válidos")
    void shouldCreateCitaWithValidData() {
        Paciente paciente = new Paciente("12345678", "Ana", "Pérez", "987654321", "ana@mail.com");
        Doctor doctor = new Doctor("43219876", "Carlos", "Ruiz", "CMP-12345", "esp-cardiologia-01");
        LocalDateTime fecha = LocalDateTime.of(2026, 11, 20, 9, 0);

        CitaMedica cita = new CitaMedica(
                "CIT-001",
                paciente,
                doctor,
                fecha,
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita, "La cita debe crearse");
        assertEquals("CIT-001", cita.getCodigo());
        assertEquals(paciente, cita.getPaciente());
        assertEquals(doctor, cita.getDoctor());
        assertEquals(fecha, cita.getFechaHora());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("CIT-002: Rechazar cita sin código")
    void shouldRejectCitaWithoutCodigo() {
        Paciente paciente = new Paciente("12345678", "Ana", "Pérez", "987654321", "ana@mail.com");
        Doctor doctor = new Doctor("43219876", "Carlos", "Ruiz", "CMP-12345", "esp-cardiologia-01");
        LocalDateTime fecha = LocalDateTime.of(2026, 11, 20, 9, 0);

        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica(null, paciente, doctor, fecha, EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("CIT-003: Rechazar cita sin paciente")
    void shouldRejectCitaWithoutPaciente() {
        Doctor doctor = new Doctor("43219876", "Carlos", "Ruiz", "CMP-12345", "esp-cardiologia-01");
        LocalDateTime fecha = LocalDateTime.of(2026, 11, 20, 9, 0);

        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica("CIT-001", null, doctor, fecha, EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("CIT-004: Rechazar cita sin doctor")
    void shouldRejectCitaWithoutDoctor() {
        Paciente paciente = new Paciente("12345678", "Ana", "Pérez", "987654321", "ana@mail.com");
        LocalDateTime fecha = LocalDateTime.of(2026, 11, 20, 9, 0);

        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica("CIT-001", paciente, null, fecha, EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("CIT-005: Rechazar cita sin fecha")
    void shouldRejectCitaWithoutFecha() {
        Paciente paciente = new Paciente("12345678", "Ana", "Pérez", "987654321", "ana@mail.com");
        Doctor doctor = new Doctor("43219876", "Carlos", "Ruiz", "CMP-12345", "esp-cardiologia-01");

        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica("CIT-001", paciente, doctor, null, EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("CIT-006: Cambiar estado de cita")
    void shouldChangeCitaStatus() {
        Paciente paciente = new Paciente("12345678", "Ana", "Pérez", "987654321", "ana@mail.com");
        Doctor doctor = new Doctor("43219876", "Carlos", "Ruiz", "CMP-12345", "esp-cardiologia-01");
        LocalDateTime fecha = LocalDateTime.of(2026, 11, 20, 9, 0);

        CitaMedica cita = new CitaMedica("CIT-001", paciente, doctor, fecha, EstadoCita.PROGRAMADA);
        cita.setEstado(EstadoCita.ATENDIDA);

        assertEquals(EstadoCita.ATENDIDA, cita.getEstado());
    }
}
