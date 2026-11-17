package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    @Test
    @DisplayName("CIT-001: Crear cita médica con datos válidos")
    void shouldCreateCitaMedicaWithValidData() {
        LocalDateTime fechaHora = LocalDateTime.now().plusDays(1);
        CitaMedica cita = new CitaMedica("PAC-123", "DOC-456", "ESP-789", fechaHora, "PROGRAMADA");

        assertNotNull(cita);
        assertEquals("PAC-123", cita.getPacienteId());
        assertEquals("DOC-456", cita.getDoctorId());
        assertEquals("ESP-789", cita.getEspecialidadId());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("PROGRAMADA", cita.getEstado());
    }

    @Test
    @DisplayName("CIT-002: Crear cita sin identificador de paciente (null)")
    void shouldRejectCitaWithoutPacienteId() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(null, "DOC-456", "ESP-789", LocalDateTime.now(), "PROGRAMADA")
        );
    }

    @Test
    @DisplayName("CIT-003: Crear cita sin identificador de doctor (null)")
    void shouldRejectCitaWithoutDoctorId() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica("PAC-123", null, "ESP-789", LocalDateTime.now(), "PROGRAMADA")
        );
    }

    @Test
    @DisplayName("CIT-004: Crear cita sin identificador de especialidad (null)")
    void shouldRejectCitaWithoutEspecialidadId() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica("PAC-123", "DOC-456", null, LocalDateTime.now(), "PROGRAMADA")
        );
    }

    @Test
    @DisplayName("CIT-005: Crear cita sin fecha y hora (null)")
    void shouldRejectCitaWithoutFechaHora() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica("PAC-123", "DOC-456", "ESP-789", null, "PROGRAMADA")
        );
    }

    @Test
    @DisplayName("CIT-006: Crear cita con estado null (asigna PROGRAMADA por defecto)")
    void shouldAssignDefaultStateWhenEstadoIsNull() {
        CitaMedica cita = new CitaMedica("PAC-123", "DOC-456", "ESP-789", LocalDateTime.now(), null);
        assertEquals("PROGRAMADA", cita.getEstado());
    }

    @Test
    @DisplayName("CIT-007: Crear cita con un estado válido")
    void shouldKeepProvidedValidState() {
        CitaMedica cita = new CitaMedica("PAC-123", "DOC-456", "ESP-789", LocalDateTime.now(), "CONFIRMADA");
        assertEquals("CONFIRMADA", cita.getEstado());
    }

    @Test
    @DisplayName("CIT-008: Verificar los atributos después de construir el objeto")
    void shouldVerifyCitaAttributesAfterConstruction() {
        LocalDateTime fecha = LocalDateTime.of(2026, 12, 10, 10, 0);
        CitaMedica cita = new CitaMedica("P999", "D888", "E777", fecha, "ATENDIDA");

        assertEquals("P999", cita.getPacienteId());
        assertEquals("D888", cita.getDoctorId());
        assertEquals("E777", cita.getEspecialidadId());
        assertEquals(fecha, cita.getFechaHora());
        assertEquals("ATENDIDA", cita.getEstado());
    }
}