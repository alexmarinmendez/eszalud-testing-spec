package com.eszalud.model;

import java.time.LocalDateTime;

public class CitaMedica {

    private Paciente paciente;
    private Doctor doctor;
    private Especialidad especialidad;
    private LocalDateTime fechaHora;
    private String estado;

    public CitaMedica(Paciente paciente, Doctor doctor,
                      Especialidad especialidad, LocalDateTime fechaHora,
                      String estado) {


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

        if (estado == null) {
            throw new IllegalArgumentException("El estado es obligatorio");
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

    public String getEstado() {
        return estado;
    }
}