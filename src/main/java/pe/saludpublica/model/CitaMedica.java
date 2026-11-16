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
        this.paciente = requerido(paciente, "El paciente de la cita es obligatorio");
        this.doctor = requerido(doctor, "El doctor de la cita es obligatorio");
        this.especialidad = especialidad;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.estado = estado;
    }

    private static <T> T requerido(T valor, String mensaje) {
        if (valor == null) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor;
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
