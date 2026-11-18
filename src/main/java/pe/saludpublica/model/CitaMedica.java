package pe.saludpublica.model;

import java.time.LocalDateTime;

public class CitaMedica {

    private String paciente;
    private String doctor;
    private String especialidad;
    private LocalDateTime fechaHora;
    private String motivo;
    private EstadoCita estado;

    public CitaMedica(String paciente, String doctor, String especialidad,
                      LocalDateTime fechaHora, String motivo, EstadoCita estado) {

        if (paciente == null) {
            throw new IllegalArgumentException("El paciente no puede ser null");
        }

        if (doctor == null) {
            throw new IllegalArgumentException("El doctor no puede ser null");
        }

        if (especialidad == null) {
            throw new IllegalArgumentException("La especialidad no puede ser null");
        }

        if (fechaHora == null) {
            throw new IllegalArgumentException("La fecha y hora no pueden ser null");
        }

        this.paciente = paciente;
        this.doctor = doctor;
        this.especialidad = especialidad;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.estado = (estado == null) ? EstadoCita.PROGRAMADA : estado;
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