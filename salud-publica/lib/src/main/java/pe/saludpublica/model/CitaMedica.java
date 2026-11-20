package pe.saludpublica.model;

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
            EstadoCita estado) {

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
        this.motivo = motivo;
        this.estado = estado;
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
}