package pe.saludpublica.model;

import java.time.LocalDateTime;

public class CitaMedica {
    private String paciente;
    private String doctor;
    private String especialidad;
    private LocalDateTime fechaHora;
    private String motivo;
    private EstadoCita estado;

    public CitaMedica(String paciente, String doctor, String especialidad, LocalDateTime fechaHora, String motivo, EstadoCita estado) {
        validarObligatorio(paciente, "El identificador del paciente es obligatorio");
        validarObligatorio(doctor, "El identificador del doctor es obligatorio");
        validarObligatorio(especialidad, "El identificador de la especialidad es obligatorio");
        if (fechaHora == null) {
            throw new IllegalArgumentException("La fecha y hora de la cita son obligatorias");
        }

        this.paciente = paciente;
        this.doctor = doctor;
        this.especialidad = especialidad;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.estado = (estado == null) ? EstadoCita.PROGRAMADA : estado;
    }

    private void validarObligatorio(String valor, String mensaje) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
    }

    public String getPaciente() { return paciente; }
    public void setPaciente(String paciente) { validarObligatorio(paciente, "El identificador del paciente es obligatorio"); this.paciente = paciente; }
    public String getDoctor() { return doctor; }
    public void setDoctor(String doctor) { validarObligatorio(doctor, "El identificador del doctor es obligatorio"); this.doctor = doctor; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { validarObligatorio(especialidad, "El identificador de la especialidad es obligatorio"); this.especialidad = especialidad; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) {
        if (fechaHora == null) { throw new IllegalArgumentException("La fecha y hora de la cita son obligatorias"); }
        this.fechaHora = fechaHora;
    }
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public EstadoCita getEstado() { return estado; }
    public void setEstado(EstadoCita estado) { this.estado = (estado == null) ? EstadoCita.PROGRAMADA : estado; }
}
