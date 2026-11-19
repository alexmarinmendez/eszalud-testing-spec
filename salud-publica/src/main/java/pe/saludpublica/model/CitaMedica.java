package pe.saludpublica.model;

public class CitaMedica {

    private String paciente;
    private String doctor;
    private String especialidad;
    private String fechaHora;
    private String motivo;
    private EstadoCita estado;

    public CitaMedica(String paciente, String doctor, String especialidad, String fechaHora, String motivo, EstadoCita estado) {

        this.paciente = validateRequiredText(paciente,"El paciente es obligatorio");
        this.doctor = validateRequiredText(doctor,"El doctor es obligatorio");
        this.especialidad = especialidad;
        this.fechaHora = validateRequiredText(fechaHora,"La fecha y hora es obligatorio");
        this.motivo = motivo;
        this.estado = (estado != null) ? estado : EstadoCita.PROGRAMADA;
    }

    private String validateRequiredText(String value, String alertMenssage) {
        if (value == null ) {
            throw new IllegalArgumentException(alertMenssage);
        }
        return value.trim();
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
