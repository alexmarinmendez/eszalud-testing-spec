
package pe.saludpublica.model;

import java.time.LocalDateTime;

public class CitaMedica {

    private Paciente paciente;
    private Doctor doctor;
    private LocalDateTime fechaHora;
    private EstadoCita estado;

    public CitaMedica(Paciente paciente, Doctor doctor,
                      LocalDateTime fechaHora, EstadoCita estado) {

        this.paciente = paciente;
        this.doctor = doctor;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public EstadoCita getEstado() {
        return estado;
    }
}
