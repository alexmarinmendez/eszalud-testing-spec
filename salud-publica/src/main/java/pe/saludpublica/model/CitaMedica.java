package pe.saludpublica.model;

import java.time.LocalDateTime;

public class CitaMedica {

    private final String paciente;
    private final String doctor;
    private final String especialidad;
    private final LocalDateTime fechaHora;
    private final String motivo;
    private final EstadoCita estado;

    public CitaMedica(String paciente, String doctor, String especialidad, LocalDateTime fechaHora, String motivo, EstadoCita estado) {
        this.paciente = requireNotNull(paciente, "El paciente es obligatorio");
        this.doctor = requireNotNull(doctor, "El doctor es obligatorio");
        this.especialidad = requireNotNull(especialidad, "La especialidad es obligatoria");
        this.fechaHora = requireNotNull(fechaHora, "La fecha y hora son obligatorias");
        this.motivo = motivo;
        this.estado = (estado == null) ? EstadoCita.PROGRAMADA : estado;
    }

    private static <T> T requireNotNull(T value, String message) {
        if (value == null) {
            throw new IllegalArgumentException(message);
        }
        return value;
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

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public EstadoCita getEstado() {
        return estado;
    }
}
