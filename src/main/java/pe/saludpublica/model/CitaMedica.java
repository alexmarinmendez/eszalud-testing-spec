package pe.saludpublica.model;

import java.time.LocalDateTime;

public class CitaMedica {

    private final String paciente;
    private final String doctor;
    private final String especialidad;
    private final LocalDateTime fechaHora;
    private final String motivo;
    private final EstadoCita estado;

    public CitaMedica(String paciente, String doctor, String especialidad,
                      LocalDateTime fechaHora, String motivo, EstadoCita estado) {
        this.paciente = requireText(paciente, "El paciente es obligatorio");
        this.doctor = requireText(doctor, "El doctor es obligatorio");
        this.especialidad = requireText(especialidad, "La especialidad es obligatoria");
        if (fechaHora == null) {
            throw new IllegalArgumentException("La fecha y hora son obligatorias");
        }
        this.fechaHora = fechaHora;
        this.motivo = requireText(motivo, "El motivo es obligatorio");
        this.estado = estado == null ? EstadoCita.PROGRAMADA : estado;
    }

    private static String requireText(String value, String message) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    public String getPaciente() { return paciente; }
    public String getDoctor() { return doctor; }
    public String getEspecialidad() { return especialidad; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public String getMotivo() { return motivo; }
    public EstadoCita getEstado() { return estado; }
}