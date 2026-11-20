package pe.saludpublica.model;

public class CitaMedica {

    private String paciente;
    private String doctor;
    private String especialidad;
    private String fechaHora;
    private String motivo;
    private EstadoCita estado;

    public CitaMedica(String paciente, String doctor,
                      String especialidad, String fechaHora,
                      String motivo, EstadoCita estado) {
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
