package pe.saludpublica.model;

import java.time.LocalDateTime;

public class CitaMedica {
    private String pacienteId;
    private String doctorId;
    private String especialidadId;
    private LocalDateTime fechaHora;
    private String estado;

    public CitaMedica(String pacienteId, String doctorId, String especialidadId, LocalDateTime fechaHora, String estado) {
        if (pacienteId == null) {
            throw new IllegalArgumentException("El ID del paciente no puede ser nulo");
        }
        if (doctorId == null) {
            throw new IllegalArgumentException("El ID del doctor no puede ser nulo");
        }
        if (especialidadId == null) {
            throw new IllegalArgumentException("El ID de la especialidad no puede ser nulo");
        }
        if (fechaHora == null) {
            throw new IllegalArgumentException("La fecha y hora no pueden ser nulas");
        }

        this.pacienteId = pacienteId;
        this.doctorId = doctorId;
        this.especialidadId = especialidadId;
        this.fechaHora = fechaHora;

        // Regla CIT-006: si el estado es null, asigna "PROGRAMADA" por defecto
        this.estado = (estado == null) ? "PROGRAMADA" : estado;
    }

    public String getPacienteId() { return pacienteId; }
    public String getDoctorId() { return doctorId; }
    public String getEspecialidadId() { return especialidadId; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public String getEstado() { return estado; }
}