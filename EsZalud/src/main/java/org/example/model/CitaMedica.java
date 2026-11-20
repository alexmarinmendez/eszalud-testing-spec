package org.example.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class CitaMedica {
    private String paciente;
    private String doctor;
    private String especialidad;
    private LocalDateTime fechaHora;
    private String motivo;
    private EstadoCita estado;

    public CitaMedica(
            String paciente,
            String doctor,
            String especialidad,
            LocalDateTime fechaHora,
            String motivo,
            EstadoCita estado
    ) {
        this.paciente = validarTextoObligatorio(paciente, "El paciente es obligatorio");
        this.doctor = validarTextoObligatorio(doctor, "El doctor es obligatorio");
        this.especialidad = validarTextoObligatorio(especialidad, "La especialidad es obligatoria");

        setFechaHora(fechaHora);

        this.motivo = motivo;

        // Si el estado es null, asignar PROGRAMADA por defecto
        this.estado = (estado != null)
                ? estado
                : EstadoCita.PROGRAMADA;
    }

    private static String validarTextoObligatorio(String valor, String mensaje) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor.trim();
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = validarTextoObligatorio(paciente, "El paciente es obligatorio");
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = validarTextoObligatorio(doctor, "El doctor es obligatorio");
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = validarTextoObligatorio(especialidad, "La especialidad es obligatoria");
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    private static <T> T validarObligatorio(T valor, String mensaje) {
        if (valor == null) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = validarObligatorio(
                fechaHora,
                "La fecha y hora son obligatorias"
        );
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = validarObligatorio(estado, "El estado no puede ser nulo");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CitaMedica that)) return false;
        return Objects.equals(paciente, that.paciente)
                && Objects.equals(doctor, that.doctor)
                && Objects.equals(fechaHora, that.fechaHora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paciente, doctor, fechaHora);
    }

    @Override
    public String toString() {
        return "CitaMedica{" +
                "paciente='" + paciente + '\'' +
                ", doctor='" + doctor + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", fechaHora=" + fechaHora +
                ", motivo='" + motivo + '\'' +
                ", estado=" + estado +
                '}';
    }
}
