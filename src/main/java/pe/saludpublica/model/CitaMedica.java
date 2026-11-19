package pe.saludpublica.model;

import java.time.LocalDateTime;

public class CitaMedica {

    private String pacienteId;
    private String doctorId;
    private String especialidadId;
    private LocalDateTime fechaHora;
    private String motivo;
    private String estado;

    public CitaMedica(String pacienteId, String doctorId, String especialidadId, LocalDateTime fechaHora, String motivo, String estado) {

        if (pacienteId == null) {
            throw new IllegalArgumentException("El paciente de la cita es obligatorio");
        }
        this.pacienteId = pacienteId;

        if (doctorId == null) {
            throw new IllegalArgumentException("El doctor de la cita es obligatorio");
        }
        this.doctorId = doctorId;

        if (fechaHora == null) {
            throw new IllegalArgumentException("La fecha y hora de la cita son obligatorias");
        }
        this.fechaHora = fechaHora;

        this.especialidadId = especialidadId;
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

    public String getEstado() {
        return estado;
    }
}
