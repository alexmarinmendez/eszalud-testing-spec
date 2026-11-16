package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        LocalDateTime fecha = LocalDateTime.of(2026, 12, 1, 9, 30);
        CitaMedica cita = new CitaMedica(
                "pac1",
                "doc1",
                "esp1",
                fecha,
                "Control",
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);
        assertEquals("pac1", cita.getPaciente());
    }

    @Test
    @DisplayName("Rechazar cita sin paciente")
    void shouldRejectAppointmentWithoutPatient() {
        LocalDateTime fecha = LocalDateTime.of(2026, 12, 1, 9, 30);
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica(null, "doc1", "esp1", fecha, "Control", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Rechazar cita sin doctor")
    void shouldRejectAppointmentWithoutDoctor() {
        LocalDateTime fecha = LocalDateTime.of(2026, 12, 1, 9, 30);
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("pac1", null, "esp1", fecha, "Control", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Rechazar cita sin especialidad")
    void shouldRejectAppointmentWithoutSpecialty() {
        LocalDateTime fecha = LocalDateTime.of(2026, 12, 1, 9, 30);
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("pac1", "doc1", null, fecha, "Control", EstadoCita.PROGRAMADA)
        );
    }
    @Test
    @DisplayName("Rechazar cita sin fecha y hora")
    void shouldRejectAppointmentWithoutDateTime() {
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("pac1", "doc1", "esp1", null, "Control", EstadoCita.PROGRAMADA)
        );
    }

    @Test
    @DisplayName("Asignar estado PROGRAMADA por defecto si el estado es nulo")
    void shouldDefaultStatusToProgramadaWhenNull() {
        LocalDateTime fecha = LocalDateTime.of(2026, 12, 1, 9, 30);
        CitaMedica cita = new CitaMedica(
                "pac1", "doc1", "esp1", fecha, "Control", null
        );
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Mantener el estado proporcionado si no es nulo")
    void shouldKeepProvidedStatus() {
        LocalDateTime fecha = LocalDateTime.of(2026, 12, 1, 9, 30);
        CitaMedica cita = new CitaMedica(
                "pac1", "doc1", "esp1", fecha, "Control", EstadoCita.ATENDIDA
        );
        assertEquals(EstadoCita.ATENDIDA, cita.getEstado());
    }

    @Test
    @DisplayName("Conservar los valores de los atributos de la cita")
    void shouldKeepAppointmentAttributeValues() {
        LocalDateTime fecha = LocalDateTime.of(2026, 12, 1, 9, 30);
        CitaMedica cita = new CitaMedica(
                "pac1", "doc1", "esp1", fecha, "Control", EstadoCita.CANCELADA
        );
        assertEquals("pac1", cita.getPaciente());
        assertEquals("doc1", cita.getDoctor());
        assertEquals("esp1", cita.getEspecialidad());
        assertEquals(fecha, cita.getFechaHora());
        assertEquals("Control", cita.getMotivo());
        assertEquals(EstadoCita.CANCELADA, cita.getEstado());
    }
}