package pe.saludpublica.model;

import java.time.LocalDateTime;

public class CitaMedica {

    private final String pacienteId;
    private final String doctorId;
    private final String especialidadId;
    private final LocalDateTime fechaHora;
    private final String estado;

    public CitaMedica(String pacienteId, String doctorId, String especialidadId, LocalDateTime fechaHora, String estado) {
        if (pacienteId == null) {
            throw new IllegalArgumentException("El identificador del paciente es obligatorio");
        }
        this.pacienteId = pacienteId;
        if (doctorId == null) {
            throw new IllegalArgumentException("El identificador del doctor es obligatorio");
        }
        this.doctorId = doctorId;
        if (especialidadId == null) {
            throw new IllegalArgumentException("El identificador de la especialidad es obligatorio");
        }
        this.especialidadId = especialidadId;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    public String getPacienteId() { return pacienteId; }
    public String getDoctorId() { return doctorId; }
    public String getEspecialidadId() { return especialidadId; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public String getEstado() { return estado; }
}