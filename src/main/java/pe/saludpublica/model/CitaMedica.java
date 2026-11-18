package pe.saludpublica.model;

import java.time.LocalDateTime;

public class CitaMedica {
    private Paciente paciente;
    private Doctor doctor;
    private LocalDateTime fechaHora;

    public CitaMedica(Paciente paciente, Doctor doctor, LocalDateTime fechaHora) {
        this.paciente = paciente;
        this.doctor = doctor;
        this.fechaHora = fechaHora;
    }

    public Paciente getPaciente() { return paciente; }
    public Doctor getDoctor() { return doctor; }
    public LocalDateTime getFechaHora() { return fechaHora; }
}
