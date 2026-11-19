
package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {

        Paciente paciente = new Paciente(
                "12345678",
                "Ana",
                "Pérez",
                "987654321",
                "ana@mail.com"
        );

        Especialidad especialidad = new Especialidad(
                "Cardiología",
                "Especialista del corazón"
        );

        Doctor doctor = new Doctor(
                "87654321",
                "Carlos",
                "Ramírez",
                "CMP12345",
                especialidad
        );

        LocalDateTime fecha = LocalDateTime.of(2026, 11, 20, 10, 30);

        CitaMedica cita = new CitaMedica(
                paciente,
                doctor,
                fecha,
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);

        assertEquals(paciente, cita.getPaciente());
        assertEquals(doctor, cita.getDoctor());
        assertEquals(fecha, cita.getFechaHora());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }
}
