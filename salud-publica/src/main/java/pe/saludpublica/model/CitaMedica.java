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
        if (paciente == null || paciente.isBlank()) {
            throw new IllegalArgumentException("Ingrese el paciente de la cita");
        }
        if (doctor == null || doctor.isBlank()) {
            throw new IllegalArgumentException("Ingrese el doctor de la cita");
        }
        if (especialidad == null || especialidad.isBlank()) {
            throw new IllegalArgumentException("Ingrese la especialidad de la cita");
        }
        if (fechaHora == null) {
            throw new IllegalArgumentException("Ingrese la fecha y hora de la cita");
        }
        this.paciente = paciente;
        this.doctor = doctor;
        this.especialidad = especialidad;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.estado = (estado != null) ? estado : EstadoCita.PROGRAMADA;
    }

    public String getPaciente() { return paciente; }
    public String getDoctor() { return doctor; }
    public String getEspecialidad() { return especialidad; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public String getMotivo() { return motivo; }
    public EstadoCita getEstado() { return estado; }

}
