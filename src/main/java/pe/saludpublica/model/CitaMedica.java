package pe.saludpublica.model;

import java.time.LocalDateTime;

public class CitaMedica {
    private String codigo;
    private Paciente paciente;
    private Doctor doctor;
    private Especialidad especialidad;
    private LocalDateTime fechaHora;
    private String motivo;
    private EstadoCita estado;

    public CitaMedica(String codigo, Paciente paciente, Doctor doctor, Especialidad especialidad, LocalDateTime fechaHora, String motivo, EstadoCita estado) {
        if (paciente == null) {
            throw new IllegalArgumentException("El paciente es obligatorio");
        }
        if (doctor == null) {
            throw new IllegalArgumentException("El doctor es obligatorio");
        }
        if (especialidad == null) {
            throw new IllegalArgumentException("La especialidad es obligatoria");
        }
        if (fechaHora == null) {
            throw new IllegalArgumentException("La fecha y hora son obligatorias");
        }
        if (fechaHora.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("La fecha de la cita no puede estar en el pasado");
        }
        if (motivo == null || motivo.trim().isEmpty()) {
            throw new IllegalArgumentException("El motivo de la cita es obligatorio y no puede estar vacío");
        }

        this.codigo = codigo;
        this.paciente = paciente;
        this.doctor = doctor;
        this.especialidad = especialidad;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.estado = (estado == null) ? EstadoCita.PROGRAMADA : estado;
    }

    // Constructor sobrecargado para no romper otras partes del proyecto si existieran
    public CitaMedica(String codigo, Paciente paciente, Doctor doctor, Especialidad especialidad, LocalDateTime fechaHora, EstadoCita estado) {
        this(codigo, paciente, doctor, especialidad, fechaHora, "Motivo no especificado", estado);
    }

    public String getCodigo() { return codigo; }
    public Paciente getPaciente() { return paciente; }
    public Doctor getDoctor() { return doctor; }
    public Especialidad getEspecialidad() { return especialidad; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public String getMotivo() { return motivo; }
    public EstadoCita getEstado() { return estado; }
}