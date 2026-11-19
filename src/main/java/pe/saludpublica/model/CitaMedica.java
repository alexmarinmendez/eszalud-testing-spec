package pe.saludpublica.model;

import java.time.LocalDateTime;

public class CitaMedica {

    private final String pacienteId;
    private final String doctorId;
    private final String especialidadId;
    private final LocalDateTime fechaHora;
    private final String motivo;
    private final EstadoCita estado;

    public CitaMedica(
            String pacienteId,
            String doctorId,
            String especialidadId,
            LocalDateTime fechaHora,
            String motivo,
            EstadoCita estado
    ) {
        if (pacienteId == null) {
            throw new IllegalArgumentException("Patient identifier is required");
        }

        if (doctorId == null) {
            throw new IllegalArgumentException("Doctor identifier is required");
        }

        if (especialidadId == null) {
            throw new IllegalArgumentException("Specialty identifier is required");
        }

        if (fechaHora == null) {
            throw new IllegalArgumentException("Appointment date time is required");
        }

        this.pacienteId = pacienteId;
        this.doctorId = doctorId;
        this.especialidadId = especialidadId;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.estado = estado;
    }

    public String getPacienteId() {
        return pacienteId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getEspecialidadId() {
        return especialidadId;
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
