package pe.saludpublica.model;

import java.time.LocalDateTime;

public class CitaMedica {

    private String pacienteId;
    private String doctorId;
    private String especialidadId;
    private LocalDateTime fechaHora;
    private String motivo;
    private EstadoCita estado;

    public CitaMedica(String pacienteId, String doctorId, String especialidadId, LocalDateTime fechaHora, String motivo, EstadoCita estado) {

        validarDatosObligatorios(pacienteId, doctorId, fechaHora);

        this.pacienteId = pacienteId;
        this.doctorId = doctorId;
        this.especialidadId = especialidadId;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.estado = estado;
    }

    private void validarDatosObligatorios(String pacienteId, String doctorId,
                                          LocalDateTime fechaHora) {

        if (pacienteId == null) {
            throw new IllegalArgumentException("El paciente de la cita es obligatorio");
        }

        if (doctorId == null) {
            throw new IllegalArgumentException("El doctor de la cita es obligatorio");
        }

        if (fechaHora == null) {
            throw new IllegalArgumentException("La fecha y hora de la cita son obligatorias");
        }
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
