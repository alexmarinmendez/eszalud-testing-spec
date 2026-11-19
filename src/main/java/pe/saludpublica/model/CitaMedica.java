package pe.saludpublica.model;

import java.time.LocalDateTime;
import static pe.saludpublica.model.ValidacionUtil.requireNonNull;

public class CitaMedica {
    private final String codigo;
    private final Paciente paciente;
    private final Doctor doctor;
    private final LocalDateTime fechaHora;
    private EstadoCita estado;

    public CitaMedica(String codigo, Paciente paciente, Doctor doctor, LocalDateTime fechaHora, EstadoCita estado) {
        requireNonNull(codigo, "código");
        requireNonNull(paciente, "paciente");
        requireNonNull(doctor, "doctor");
        requireNonNull(fechaHora, "fecha y hora");
        requireNonNull(estado, "estado");

        this.codigo = codigo;
        this.paciente = paciente;
        this.doctor = doctor;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    public String getCodigo() { return codigo; }
    public Paciente getPaciente() { return paciente; }
    public Doctor getDoctor() { return doctor; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public EstadoCita getEstado() { return estado; }

    public void setEstado(EstadoCita estado) {
        requireNonNull(estado, "estado");
        this.estado = estado;
    }
}
