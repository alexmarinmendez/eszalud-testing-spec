package pe.saludpublica.model;

public class CitaMedica {
    private String paciente;
    private String doctor;
    private String especialidad;
    private String fechaHora;
    private String motivo;
    private EstadoCita estado;

    public CitaMedica(String paciente, String doctor, String especialidad, String fechaHora, String motivo, String estado) {
        if (paciente == null) {
            throw new IllegalArgumentException("El paciente no puede ser nulo");
        }
        this.paciente = paciente;
        this.doctor = doctor;
        this.especialidad = especialidad;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        if (estado == null) {
            this.estado = EstadoCita.PROGRAMADA;
        } else {
            this.estado = EstadoCita.valueOf(estado);
        }
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

    public String getEstado() {
        return estado.name();
    }
}
