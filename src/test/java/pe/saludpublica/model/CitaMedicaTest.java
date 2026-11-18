package pe.saludpublica.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {
    @Test
    void testValidAppointmentCreation() {
        Paciente paciente = new Paciente("12345678", "Carlos", "Jimenez", "987654321", "Carlitos@test.com");
        Doctor doctor = new Doctor("12345678", "Bianka", "Ataegina", "CMP12345", "Dermatologia");
        LocalDateTime fechaHora = LocalDateTime.of(2026, 8, 27, 10, 30);

        CitaMedica cita = new CitaMedica(paciente, doctor, fechaHora);

        assertEquals(paciente, cita.getPaciente());
        assertEquals(doctor, cita.getDoctor());
        assertEquals(fechaHora, cita.getFechaHora());
    }
}
