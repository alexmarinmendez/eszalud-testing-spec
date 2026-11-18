package pe.saludpublica.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Modelo que representa una cita médica.
 */
public class CitaMedica {

    private static final DateTimeFormatter FORMATO_FECHA_HORA =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private final String paciente;
    private final String doctor;
    private final String especialidad;
    private final String fechaHora;
    private final String motivo;
    private final EstadoCita estado;

    public CitaMedica(String paciente, String doctor, String especialidad,
                      String fechaHora, String motivo, EstadoCita estado) {
        requireNotNull(paciente, "El paciente es obligatorio");
        requireNotNull(doctor, "El doctor es obligatorio");
        requireNotNull(especialidad, "La especialidad es obligatoria");
        requireText(fechaHora, "La fecha y hora son obligatorias");
        requireValidFechaHora(fechaHora);

        this.paciente = paciente;
        this.doctor = doctor;
        this.especialidad = especialidad;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.estado = defaultStatus(estado);
    }

    private static EstadoCita defaultStatus(EstadoCita estado) {
        return estado != null ? estado : EstadoCita.PROGRAMADA;
    }

    private static void requireNotNull(Object value, String message) {
        if (value == null) {
            throw new IllegalArgumentException(message);
        }
    }

    private static void requireText(String value, String message) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }

    private static void requireValidFechaHora(String value) {
        LocalDateTime fecha = parseFechaHora(value);
        if (fecha.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException(
                    "No se pueden agendar citas en fechas pasadas");
        }
    }

    private static LocalDateTime parseFechaHora(String value) {
        try {
            return LocalDateTime.parse(value, FORMATO_FECHA_HORA);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(
                    "La fecha debe tener el formato yyyy-MM-dd HH:mm");
        }
    }

    public String getPaciente() {
        return paciente;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public EstadoCita getEstado() {
        return estado;
    }
}
