package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CitaMedicaTest {

    @Test
    @DisplayName("CIT-008: Verificar atributos tras construir el objeto")
    void shouldKeepAppointmentAttributesAfterConstruction() {
        CitaMedica citaMedica = new CitaMedica("6af7316490f1d08b4673bfa8", "6af730a190f1d08b4673b", "9bc12ef4402ddb157b277",
                "2026-12-03 15:30", "Dolor de cabeza", "ATENDIDA");
        assertEquals("6af7316490f1d08b4673bfa8", citaMedica.getIdPaciente());
        assertEquals("6af730a190f1d08b4673b", citaMedica.getIdDoctor());
        assertEquals("9bc12ef4402ddb157b277", citaMedica.getIdEspecialidad());
        assertEquals("2026-12-03 15:30", citaMedica.getFechaHora());
        assertEquals("Dolor de cabeza", citaMedica.getMotivo());
        assertEquals("ATENDIDA", citaMedica.getEstado());
    }

    @Test
    @DisplayName("Crear cita sin identificador de paciente")
    void shouldThrowExceptionWhenPatientIdIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CitaMedica(null, "6af730a190f1d08b4673b", "6af71da3501cca046a166",
                    "2026-11-26 09:16", "Chekeo Mensual", "PROGRAMADA");
        });
    }

    @Test
    @DisplayName("Rechazar cita sin identificador de doctor")
    void shouldThrowExceptionWhenDoctorIdIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica("6af7316490f1d08b4673bfa8", null, "9bc12ef4402ddb157b277c02",
                        "2026-11-26 09:16", "Chequeo mensual", "PROGRAMADA"));
    }

    @Test
    @DisplayName("Rechazar cita sin identificador de especialidad")
    void shouldThrowExceptionWhenSpecialtyIdIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica("6af7316490f1d08b4673bfa8", "6af730a190f1d08b4673bfb1", null,
                        "2026-11-27 09:16", "Chequeo mensual", "PROGRAMADA"));
    }

    @Test
    @DisplayName("Rechazar cita sin fecha y hora")
    void shouldThrowExceptionWhenDateTimeIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica("6af7316490f1d08b4673bfa8", "6af730a190f1d08b4673bfb1", "9bc12ef4402ddb157b277c02",
                        null, "Chequeo mensual", "PROGRAMADA"));
    }

    @Test
    @DisplayName("Estado null asigna PROGRAMADA por defecto")
    void shouldDefaultToScheduledWhenStatusIsNull() {
        // Decisión documentada: estado null => "PROGRAMADA"
        CitaMedica c = new CitaMedica("6af7316490f1d08b4673bfa8", "6af730a190f1d08b4673bfb1", "9bc12ef4402ddb157b277c02",
                "2026-11-27 09:16", "Chequeo mensual", null);
        assertNotNull(c.getEstado());
        assertEquals("PROGRAMADA", c.getEstado());
    }

    @Test
    @DisplayName("Conservar un estado válido")
    void shouldPreserveValidState() {
        CitaMedica c = new CitaMedica("6af7316490f1d08b4673bfa8", "6af730a190f1d08b4673bfb1", "6af71da3501cca046a166",
                "2026-11-26 09:16", "Control posterior", "ATENDIDA");
        assertEquals("ATENDIDA", c.getEstado());
    }

    @Test
    @DisplayName("Verificar atributos tras construir el objeto")
    void shouldVerifyAttributesAfterConstruction() {
        CitaMedica c = new CitaMedica("45678912", "80654321", "9bc12ef4402ddb157b277",
                "2026-12-03 15:30", "Dolor de cabeza", "CANCELADA");
        assertEquals("45678912", c.getIdPaciente());
        assertEquals("80654321", c.getIdDoctor());
        assertEquals("9bc12ef4402ddb157b277", c.getIdEspecialidad());
        assertEquals("2026-12-03 15:30", c.getFechaHora());
        assertEquals("Dolor de cabeza", c.getMotivo());
        assertEquals("CANCELADA", c.getEstado());
    }


}
