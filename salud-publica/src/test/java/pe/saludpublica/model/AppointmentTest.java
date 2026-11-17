package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {

        LocalDateTime dateTime = LocalDateTime.of(2026, 12, 1, 9, 30);

        Appointment appointment = new Appointment(
                "patient-001",
                "doctor-001",
                "specialty-001",
                dateTime,
                "Control general",
                AppointmentStatus.PROGRAMADA
        );

        assertNotNull(appointment);
        assertEquals("patient-001", appointment.getPatient());
        assertEquals("doctor-001", appointment.getDoctor());
        assertEquals("specialty-001", appointment.getSpecialty());
        assertEquals(dateTime, appointment.getDateTime());
        assertEquals("Control general", appointment.getReason());
        assertEquals(AppointmentStatus.PROGRAMADA, appointment.getStatus());
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin paciente")
    void shouldRejectAppointmentWithoutPatient() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(
                    null,
                    "doctor-001",
                    "specialty-001",
                    LocalDateTime.of(2026, 12, 1, 9, 30),
                    "Control general",
                    AppointmentStatus.PROGRAMADA
            );
        });
    }
}
