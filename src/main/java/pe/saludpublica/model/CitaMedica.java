package pe.saludpublica.model;

import java.time.LocalDateTime;

public class CitaMedica {
    private Paciente paciente;
    private Doctor doctor;
    private LocalDateTime fechaHora;

    public CitaMedica(Paciente paciente, Doctor doctor, LocalDateTime fechaHora) {
        validarPaciente(paciente);
        validarDoctor(doctor);
        validarFechaHora(fechaHora);
        this.paciente = paciente;
        this.doctor = doctor;
        this.fechaHora = fechaHora;
    }
    private void validarPaciente(Paciente paciente) {
        if (paciente == null) {
            throw new IllegalArgumentException("El paciente es obligatorio");
        }
    }
    private void validarDoctor(Doctor doctor) {
        if (doctor == null) {
            throw new IllegalArgumentException("El doctor es obligatorio");
        }
    }
    private void validarFechaHora(LocalDateTime fechaHora) {
        if (fechaHora == null) {
            throw new IllegalArgumentException("La fecha y hora son obligatorias");
        }
    }

    public Paciente getPaciente() { return paciente; }
    public Doctor getDoctor() { return doctor; }
    public LocalDateTime getFechaHora() { return fechaHora; }
}
