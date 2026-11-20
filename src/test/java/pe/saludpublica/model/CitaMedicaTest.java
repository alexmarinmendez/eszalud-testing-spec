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

        CitaMedica cita = new CitaMedica("pac001", "doc001", "esp001", fecha,
                "Dolor de cabeza", EstadoCita.PROGRAMADA);

        assertNotNull(cita);
        assertEquals("pac001", cita.getPaciente());
        assertEquals("doc001", cita.getDoctor());
        assertEquals("esp001", cita.getEspecialidad());
        assertEquals(fecha, cita.getFechaHora());
        assertEquals("Dolor de cabeza", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Conservar cada atributo de la cita después de construirla")
    void shouldKeepAttributesAfterConstruction() {
        LocalDateTime fecha = LocalDateTime.of(2026, 11, 20, 15, 0);

        CitaMedica cita = new CitaMedica("pac002", "doc002", "esp002", fecha,
                "Control general", EstadoCita.ATENDIDA);

        assertEquals("pac002", cita.getPaciente());
        assertEquals("doc002", cita.getDoctor());
        assertEquals("esp002", cita.getEspecialidad());
        assertEquals(fecha, cita.getFechaHora());
        assertEquals("Control general", cita.getMotivo());
        assertEquals(EstadoCita.ATENDIDA, cita.getEstado());
    }
}