
package pe.saludpublica.model;

import java.time.LocalDateTime;

public class CitaMedica {

    private String paciente;
    private String doctor;
    private String especialidad;
    private LocalDateTime fechaHora;
    private String motivo;
    private EstadoCita estado;

    public CitaMedica(String paciente, String doctor,
                      String especialidad, LocalDateTime fechaHora,
                      String motivo, EstadoCita estado) {
        // Pendiente de implementar para GREEN
    }

    public String getPaciente() {
        return null;
    }

    public String getDoctor() {
        return null;
    }

    public String getEspecialidad() {
        return null;
    }

    public LocalDateTime getFechaHora() {
        return null;
    }

    public String getMotivo() {
        return null;
    }

    public EstadoCita getEstado() {
        return null;
    }
}
