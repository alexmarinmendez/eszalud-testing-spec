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
        if (paciente == null || paciente.trim().isEmpty()) {
            throw new IllegalArgumentException("El paciente no puede ser nulo o vacío");
        }
        if (doctor == null || doctor.trim().isEmpty()) {
            throw new IllegalArgumentException("El doctor no puede ser nulo o vacío");
        }
        if (especialidad == null || especialidad.trim().isEmpty()) {
            throw new IllegalArgumentException("La especialidad no puede ser nula o vacía");
        }
        if (fechaHora == null) {
            throw new IllegalArgumentException("La fecha y hora no pueden ser nulas");
        }
        this.paciente = paciente;
        this.doctor = doctor;
        this.especialidad = especialidad;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.estado = (estado != null) ? estado : EstadoCita.PROGRAMADA;
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