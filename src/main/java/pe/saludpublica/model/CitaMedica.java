package pe.saludpublica.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

/**
 * Cita médica programada entre un paciente y un doctor.
 */
public class CitaMedica {

    private static final DateTimeFormatter FORMATO_FECHA_HORA =
            DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm").withResolverStyle(ResolverStyle.STRICT);

    private final String paciente;
    private final String doctor;
    private final String especialidad;
    private final String fechaHora;
    private final String motivo;
    private final EstadoCita estado;

    public CitaMedica(String paciente, String doctor, String especialidad,
                      String fechaHora, String motivo, EstadoCita estado) {
        this.paciente = Validaciones.requerido(paciente, "El identificador del paciente es obligatorio");
        this.doctor = Validaciones.requerido(doctor, "El identificador del doctor es obligatorio");
        this.especialidad = Validaciones.requerido(especialidad, "El identificador de la especialidad es obligatorio");
        this.fechaHora = fechaHoraValida(fechaHora);
        this.motivo = Validaciones.requerido(motivo, "El motivo de la cita es obligatorio");
        this.estado = estado == null ? EstadoCita.PROGRAMADA : estado;
    }

    private static String fechaHoraValida(String valor) {
        String fecha = Validaciones.requerido(valor, "La fecha y hora de la cita es obligatoria");
        try {
            LocalDateTime.parse(fecha, FORMATO_FECHA_HORA);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("La fecha y hora debe tener el formato yyyy-MM-dd HH:mm", e);
        }
        return fecha;
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
