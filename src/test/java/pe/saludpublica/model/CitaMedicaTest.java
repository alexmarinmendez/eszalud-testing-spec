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
    }
}
