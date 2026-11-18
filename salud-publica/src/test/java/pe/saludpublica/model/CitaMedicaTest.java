package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    private static final LocalDateTime FECHA = LocalDateTime.of(2026, 12, 1, 9, 30);

    @Test
    @DisplayName("CIT-001: Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        CitaMedica cita = new CitaMedica(
                "pac-1",
                "doc-1",
                "esp-1",
                FECHA,
                "Dolor de cabeza",
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);
        assertEquals("pac-1", cita.getPaciente());
        assertEquals("doc-1", cita.getDoctor());
        assertEquals("esp-1", cita.getEspecialidad());
        assertEquals(FECHA, cita.getFechaHora());
        assertEquals("Dolor de cabeza", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("CIT-002: Rechazar cita sin paciente")
    void shouldRejectAppointmentWithoutPatient() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        null,
                        "doc-1",
                        "esp-1",
                        FECHA,
                        "Dolor de cabeza",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    @Test
    @DisplayName("CIT-003: Rechazar cita sin doctor")
    void shouldRejectAppointmentWithoutDoctor() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "pac-1",
                        null,
                        "esp-1",
                        FECHA,
                        "Dolor de cabeza",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    @Test
    @DisplayName("CIT-004: Rechazar cita sin especialidad")
    void shouldRejectAppointmentWithoutSpecialty() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "pac-1",
                        "doc-1",
                        null,
                        FECHA,
                        "Dolor de cabeza",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    @Test
    @DisplayName("CIT-005: Rechazar cita sin fecha y hora")
    void shouldRejectAppointmentWithoutDateTime() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "pac-1",
                        "doc-1",
                        "esp-1",
                        null,
                        "Dolor de cabeza",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    @Test
    @DisplayName("CIT-006: Asignar PROGRAMADA cuando el estado es null")
    void shouldDefaultToScheduledWhenStatusIsNull() {
        CitaMedica cita = new CitaMedica(
                "pac-1",
                "doc-1",
                "esp-1",
                FECHA,
                "Dolor de cabeza",
                null
        );

        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @ParameterizedTest
    @EnumSource(EstadoCita.class)
    @DisplayName("CIT-007: Conservar un estado válido")
    void shouldKeepProvidedStatus(EstadoCita estado) {
        CitaMedica cita = new CitaMedica(
                "pac-1",
                "doc-1",
                "esp-1",
                FECHA,
                "Dolor de cabeza",
                estado
        );

        assertEquals(estado, cita.getEstado());
    }

    @Test
    @DisplayName("CIT-008: Verificar atributos después de construir el objeto")
    void shouldKeepAttributesAfterConstruction() {
        LocalDateTime otraFecha = LocalDateTime.of(2027, 1, 15, 14, 0);

        CitaMedica cita = new CitaMedica(
                "pac-9",
                "doc-9",
                "esp-9",
                otraFecha,
                "Control anual",
                EstadoCita.ATENDIDA
        );

        assertEquals("pac-9", cita.getPaciente());
        assertEquals("doc-9", cita.getDoctor());
        assertEquals("esp-9", cita.getEspecialidad());
        assertEquals(otraFecha, cita.getFechaHora());
        assertEquals("Control anual", cita.getMotivo());
        assertEquals(EstadoCita.ATENDIDA, cita.getEstado());
    }



}