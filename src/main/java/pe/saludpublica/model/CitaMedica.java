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
        this.paciente = requerido(paciente, "paciente");
        this.doctor = requerido(doctor, "doctor");
        this.especialidad = requerido(especialidad, "especialidad");
        if (fechaHora == null) {
            throw new IllegalArgumentException("El campo fechaHora es obligatorio");
        }
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.estado = (estado == null) ? EstadoCita.PROGRAMADA : estado;
    }

    private String requerido(String valor, String campo) {
        if (valor == null) {
            throw new IllegalArgumentException("El campo " + campo + " es obligatorio");
        }
        return valor;
    }

    public String getPaciente()         { return paciente; }
    public String getDoctor()           { return doctor; }
    public String getEspecialidad()     { return especialidad; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public String getMotivo()           { return motivo; }
    public EstadoCita getEstado()       { return estado; }
}