
package pe.saludpublica.model;

import java.time.LocalDateTime;

public class CitaMedica {

    private final String pacienteId;
    private final String doctorId;
    private final String especialidadId;
    private final LocalDateTime fechaHora;
    private final String estado;

    public CitaMedica(
            String pacienteId,
            String doctorId,
            String especialidadId,
            LocalDateTime fechaHora,
            String estado) {

        if (pacienteId == null) {
            throw new IllegalArgumentException(
                    "El identificador del paciente no puede ser null"
            );
        }

        if (doctorId == null) {
            throw new IllegalArgumentException(
                    "El identificador del doctor no puede ser null"
            );
        }

        if (especialidadId == null) {
            throw new IllegalArgumentException(
                    "El identificador de la especialidad no puede ser null"
            );
        }

        if (fechaHora == null) {
            throw new IllegalArgumentException(
                    "La fecha y hora de la cita médica no pueden ser null"
            );
        }


        this.pacienteId = pacienteId;
        this.doctorId = doctorId;
        this.especialidadId = especialidadId;
        this.fechaHora = fechaHora;
        this.estado = (estado == null) ? "PROGRAMADA" : estado;
    }

    public String getPacienteId() {
        return pacienteId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getEspecialidadId() {
        return especialidadId;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getEstado() {
        return estado;
    }
}