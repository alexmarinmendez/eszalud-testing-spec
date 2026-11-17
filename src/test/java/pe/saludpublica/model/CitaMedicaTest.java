package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    @Test
    @DisplayName("Crear cita médica con datos válidos")
    void shouldCreateCitaMedicaWithValidData() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 20, 10, 30);

        CitaMedica cita = new CitaMedica(
                "PAC-001",
                "DOC-001",
                "ESP-01",
                fechaHora,
                "PROGRAMADA"
        );

        assertNotNull(cita);
        assertEquals("PAC-001", cita.getPacienteId());
        assertEquals("DOC-001", cita.getDoctorId());
        assertEquals("ESP-01", cita.getEspecialidadId());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("PROGRAMADA", cita.getEstado());
    }
    @Test
    @DisplayName("Rechazar la creación de una cita sin identificador de paciente")
    void shouldRejectCitaMedicaWithoutPacienteId() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 20, 10, 30);

        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        null,
                        "DOC-001",
                        "ESP-01",
                        fechaHora,
                        "PROGRAMADA"
                )
        );
    }
    @Test
    @DisplayName("Rechazar la creación de una cita sin identificador de doctor")
    void shouldRejectCitaMedicaWithoutDoctorId() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 20, 10, 30);

        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC-001",
                        null,
                        "ESP-01",
                        fechaHora,
                        "PROGRAMADA"
                )
        );
    }
}