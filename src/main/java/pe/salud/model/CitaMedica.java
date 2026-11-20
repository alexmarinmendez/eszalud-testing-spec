package pe.salud.model;

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
            throw new IllegalArgumentException("El identificador del paciente es obligatorio");
        }
        if (doctor == null || doctor.isBlank()) {
            throw new IllegalArgumentException("El identificador del doctor es obligatorio");
        }
        if (especialidad == null || especialidad.isBlank()) {
            throw new IllegalArgumentException("El identificador de la especialidad es obligatorio");
        }
        if (fechaHora == null) {
            throw new IllegalArgumentException("La fecha y hora de la cita son obligatorias");
        }

        this.paciente = validarCampoObligatorio(paciente, "El identificador del paciente es obligatorio");
        this.doctor = validarCampoObligatorio(doctor, "El identificador del doctor es obligatorio");
        this.especialidad = validarCampoObligatorio(especialidad, "El identificador de la especialidad es obligatorio");
        if (fechaHora == null) {
            throw new IllegalArgumentException("La fecha y hora de la cita son obligatorias");
        }
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.estado = (estado != null) ? estado : EstadoCita.PROGRAMADA;
    }

    private String validarCampoObligatorio(String valor, String mensaje) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor;
    }

    public String getPaciente() { return paciente; }
    public String getDoctor() { return doctor; }
    public String getEspecialidad() { return especialidad; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public String getMotivo() { return motivo; }
    public EstadoCita getEstado() { return estado; }
}
