package com.eszalud.model;

import java.time.LocalDateTime;

public class CitaMedica {
    private final String idPaciente;
    private final String idDoctor;
    private final String idEspecialidad;
    private final LocalDateTime fechaHora;
    private final String estado;

    public CitaMedica(
            String idPaciente,
            String idDoctor,
            String idEspecialidad,
            LocalDateTime fechaHora,
            String estado
    ) {
        validarObligatorio(idPaciente, "identificador del paciente");
        validarObligatorio(idDoctor, "identificador del doctor");
        validarObligatorio(idEspecialidad, "identificador de la especialidad");
        validarObligatorio(fechaHora, "fecha y hora de la cita");


        this.idPaciente = idPaciente;
        this.idDoctor = idDoctor;
        this.idEspecialidad = idEspecialidad;
        this.fechaHora = fechaHora;
        this.estado = (estado == null) ? "PROGRAMADA" : estado;
    }
    private static void validarObligatorio(Object valor, String campo) {
        if (valor == null) {
            throw new IllegalArgumentException(
                    "El campo " + campo + " no puede ser null"
            );
        }
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public String getIdDoctor() {
        return idDoctor;
    }

    public String getIdEspecialidad() {
        return idEspecialidad;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getEstado() {
        return estado;
    }
}