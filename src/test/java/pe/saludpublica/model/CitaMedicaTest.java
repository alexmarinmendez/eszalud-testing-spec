
package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    private Paciente crearPaciente() {
        return new Paciente(
                "12345678", "Ana", "Pérez",
                "987654321", "ana@mail.com"
        );
    }

    private Especialidad crearEspecialidad() {
        return new Especialidad(
                "Cardiología", "Especialista del corazón"
        );
    }

    private Doctor crearDoctor() {
        return new Doctor(
                "87654321", "Carlos", "Ramírez",
                "CMP12345", crearEspecialidad()
        );
    }

    // CIT-001
    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        CitaMedica cita = new CitaMedica(
                crearPaciente(),
                crearDoctor(),
                crearEspecialidad(),
                LocalDateTime.of(2026, 11, 20, 10, 30),
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);
    }

    // CIT-002
    @Test
    @DisplayName("No permitir paciente nulo")
    void shouldThrowExceptionWhenPatientIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CitaMedica(
                    null,
                    crearDoctor(),
                    crearEspecialidad(),
                    LocalDateTime.of(2026, 11, 20, 10, 30),
                    EstadoCita.PROGRAMADA
            );
        });
    }

    // CIT-003
    @Test
    @DisplayName("No permitir doctor nulo")
    void shouldThrowExceptionWhenDoctorIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CitaMedica(
                    crearPaciente(),
                    null,
                    crearEspecialidad(),
                    LocalDateTime.of(2026, 11, 20, 10, 30),
                    EstadoCita.PROGRAMADA
            );
        });
    }

    // CIT-004
    @Test
    @DisplayName("No permitir especialidad nula")
    void shouldThrowExceptionWhenSpecialtyIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CitaMedica(
                    crearPaciente(),
                    crearDoctor(),
                    null,
                    LocalDateTime.of(2026, 11, 20, 10, 30),
                    EstadoCita.PROGRAMADA
            );
        });
    }

    // CIT-005
    @Test
    @DisplayName("No permitir fecha y hora nula")
    void shouldThrowExceptionWhenDateTimeIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CitaMedica(
                    crearPaciente(),
                    crearDoctor(),
                    crearEspecialidad(),
                    null,
                    EstadoCita.PROGRAMADA
            );
        });
    }

    // CIT-006
    @Test
    @DisplayName("No permitir estado nulo")
    void shouldThrowExceptionWhenStatusIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CitaMedica(
                    crearPaciente(),
                    crearDoctor(),
                    crearEspecialidad(),
                    LocalDateTime.of(2026, 11, 20, 10, 30),
                    null
            );
        });
    }

    // CIT-007
    @Test
    @DisplayName("Mantener el estado válido de la cita")
    void shouldKeepValidAppointmentStatus() {
        CitaMedica cita = new CitaMedica(
                crearPaciente(),
                crearDoctor(),
                crearEspecialidad(),
                LocalDateTime.of(2026, 11, 20, 10, 30),
                EstadoCita.ATENDIDA
        );

        assertEquals(EstadoCita.ATENDIDA, cita.getEstado());
    }

    // CIT-008
    @Test
    @DisplayName("Verificar todos los atributos de la cita")
    void shouldVerifyAllAppointmentAttributes() {

        Paciente paciente = crearPaciente();
        Doctor doctor = crearDoctor();
        Especialidad especialidad = crearEspecialidad();
        LocalDateTime fecha = LocalDateTime.of(2026, 11, 20, 10, 30);

        CitaMedica cita = new CitaMedica(
                paciente,
                doctor,
                especialidad,
                fecha,
                EstadoCita.PROGRAMADA
        );

        assertEquals(paciente, cita.getPaciente());
        assertEquals(doctor, cita.getDoctor());
        assertEquals(especialidad, cita.getEspecialidad());
        assertEquals(fecha, cita.getFechaHora());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }
}
