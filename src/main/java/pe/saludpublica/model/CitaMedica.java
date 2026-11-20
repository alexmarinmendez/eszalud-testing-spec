package pe.saludpublica.model;

import java.util.Objects;

public class CitaMedica {

    private final String paciente;
    private final String doctor;
    private final String especialidad;
    private final String fechaHora;
    private final String motivo;
    private final EstadoCita estado;

    public CitaMedica(
            String paciente,
            String doctor,
            String especialidad,
            String fechaHora,
            String motivo,
            EstadoCita estado
    ) {
        this.paciente = requireNonBlank(paciente, "paciente");
        this.doctor = requireNonBlank(doctor, "doctor");
        this.especialidad = requireNonBlank(especialidad, "especialidad");
        this.fechaHora = requireNonBlank(fechaHora, "fechaHora");
        this.motivo = motivo;
        this.estado = estado != null ? estado : EstadoCita.PROGRAMADA;
    }

    private static String requireNonBlank(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " must not be null or blank");
        }
        return value;
    }

    public String getPaciente() {
        return paciente;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CitaMedica other)) return false;
        return Objects.equals(paciente, other.paciente)
                && Objects.equals(doctor, other.doctor)
                && Objects.equals(fechaHora, other.fechaHora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paciente, doctor, fechaHora);
    }
}