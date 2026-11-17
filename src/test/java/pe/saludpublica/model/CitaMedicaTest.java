package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CitaMedicaTest {

    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 23, 16, 30);

        CitaMedica cita = new CitaMedica(
                "6af71e0b501cca046a166049",
                "6af7271e501cca046a16604f",
                "6af71da3501cca046a166045",
                fechaHora,
                "Dolor abdominal",
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);
        assertEquals("6af71e0b501cca046a166049", cita.getPaciente());
        assertEquals("6af7271e501cca046a16604f", cita.getDoctor());
        assertEquals("6af71da3501cca046a166045", cita.getEspecialidad());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("Dolor abdominal", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Rechazar la creación de una cita médica sin identificador de paciente")
    void shouldRejectAppointmentWithoutPatient() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 23, 16, 30);

        assertThrows(IllegalArgumentException.class, () -> new CitaMedica(
                null,
                "6af7271e501cca046a16604f",
                "6af71da3501cca046a166045",
                fechaHora,
                "Dolor abdominal",
                EstadoCita.PROGRAMADA
        ));
    }

    @Test
    @DisplayName("Rechazar la creación de una cita médica sin identificador de doctor")
    void shouldRejectAppointmentWithoutDoctor() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 23, 16, 30);

        assertThrows(IllegalArgumentException.class, () -> new CitaMedica(
                "6af71e0b501cca046a166049",
                null,
                "6af71da3501cca046a166045",
                fechaHora,
                "Dolor abdominal",
                EstadoCita.PROGRAMADA
        ));
    }

    @Test
    @DisplayName("Rechazar la creación de una cita médica sin identificador de especialidad")
    void shouldRejectAppointmentWithoutSpecialty() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 23, 16, 30);

        assertThrows(IllegalArgumentException.class, () -> new CitaMedica(
                "6af71e0b501cca046a166049",
                "6af7271e501cca046a16604f",
                null,
                fechaHora,
                "Dolor abdominal",
                EstadoCita.PROGRAMADA
        ));
    }

    @Test
    @DisplayName("Rechazar la creación de una cita médica sin fecha y hora")
    void shouldRejectAppointmentWithoutDateTime() {
        assertThrows(IllegalArgumentException.class, () -> new CitaMedica(
                "6af71e0b501cca046a166049",
                "6af7271e501cca046a16604f",
                "6af71da3501cca046a166045",
                null,
                "Dolor abdominal",
                EstadoCita.PROGRAMADA
        ));
    }

    @Test
    @DisplayName("Asignar estado PROGRAMADA por defecto cuando el estado es nulo")
    void shouldAssignDefaultStatusWhenStatusIsNull() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 23, 16, 30);

        CitaMedica cita = new CitaMedica(
                "6af71e0b501cca046a166049",
                "6af7271e501cca046a16604f",
                "6af71da3501cca046a166045",
                fechaHora,
                "Dolor abdominal",
                null
        );

        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Conservar correctamente un estado válido recibido al crear la cita")
    void shouldPreserveValidAppointmentStatus() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 10, 28, 11, 35);

        CitaMedica citaAtendida = new CitaMedica(
                "6af71f49501cca046a16604a",
                "6af730a190f1d08b4673bfa7",
                "6af71da3501cca046a166045",
                fechaHora,
                "Control posterior a consulta de emergencia",
                EstadoCita.ATENDIDA
        );

        CitaMedica citaCancelada = new CitaMedica(
                "6af71f49501cca046a16604a",
                "6af730a190f1d08b4673bfa7",
                "6af71da3501cca046a166045",
                fechaHora,
                "Control posterior a consulta de emergencia",
                EstadoCita.CANCELADA
        );

        assertAll(
                () -> assertEquals(EstadoCita.ATENDIDA, citaAtendida.getEstado()),
                () -> assertTrue(citaAtendida.isAtendida()),
                () -> assertEquals(EstadoCita.CANCELADA, citaCancelada.getEstado()),
                () -> assertFalse(citaCancelada.isAtendida())
        );
    }

    @Test
    @DisplayName("Verificar los atributos después de construir el objeto cita médica con dependencias simuladas")
    void shouldPreserveAllAttributesAfterCreation() {
        Paciente pacienteMock = mock(Paciente.class);
        Doctor doctorMock = mock(Doctor.class);
        Especialidad especialidadMock = mock(Especialidad.class);

        when(pacienteMock.getDocumento()).thenReturn("  6af71e0b501cca046a166049  ");
        when(doctorMock.getDocumento()).thenReturn("  6af7271e501cca046a16604f  ");
        when(especialidadMock.getNombre()).thenReturn("  6af71da3501cca046a166045  ");

        LocalDateTime fechaHora = LocalDateTime.of(2026, 11, 25, 9, 15);

        CitaMedica cita = new CitaMedica(
                pacienteMock.getDocumento(),
                doctorMock.getDocumento(),
                especialidadMock.getNombre(),
                fechaHora,
                "  Evaluación cardiológica preventiva  ",
                EstadoCita.PROGRAMADA
        );

        assertAll(
                () -> assertEquals("6af71e0b501cca046a166049", cita.getPaciente()),
                () -> assertEquals("6af7271e501cca046a16604f", cita.getDoctor()),
                () -> assertEquals("6af71da3501cca046a166045", cita.getEspecialidad()),
                () -> assertEquals(fechaHora, cita.getFechaHora()),
                () -> assertEquals("Evaluación cardiológica preventiva", cita.getMotivo()),
                () -> assertEquals(EstadoCita.PROGRAMADA, cita.getEstado())
        );

        verify(pacienteMock).getDocumento();
        verify(doctorMock).getDocumento();
        verify(especialidadMock).getNombre();
    }
}
