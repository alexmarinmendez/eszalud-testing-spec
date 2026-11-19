
package pe.saludpublica.model;

import java.time.LocalDateTime;

public class CitaMedica {

    private Paciente paciente;
    private Doctor doctor;
    private Especialidad especialidad;
    private LocalDateTime fechaHora;
    private EstadoCita estado;

    public CitaMedica(Paciente paciente, Doctor doctor,
                      Especialidad especialidad,
                      LocalDateTime fechaHora, EstadoCita estado) {

        if (paciente == null) {
            throw new IllegalArgumentException("El paciente no puede ser nulo");
        }

        if (doctor == null) {
            throw new IllegalArgumentException("El doctor no puede ser nulo");
        }

        if (especialidad == null) {
            throw new IllegalArgumentException("La especialidad no puede ser nula");
        }

        if (fechaHora == null) {
            throw new IllegalArgumentException("La fecha y hora no pueden ser nulas");
        }

        if (estado == null) {
            throw new IllegalArgumentException("El estado no puede ser nulo");
        }

        this.paciente = paciente;
        this.doctor = doctor;
        this.especialidad = especialidad;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public EstadoCita getEstado() {
        return estado;
    }
}
