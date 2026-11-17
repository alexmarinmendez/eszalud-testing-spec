
package pe.saludpublica.model;

import java.time.LocalDateTime;

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
        this.paciente = validarObligatorio(paciente, "El paciente es obligatorio");
        this.doctor = validarObligatorio(doctor, "El doctor es obligatorio");
        this.especialidad = validarObligatorio(especialidad, "La especialidad es obligatoria");
        this.fechaHora = validarObligatorio(fechaHora, "La fecha y hora son obligatorias");
        this.motivo = motivo;
        this.estado = validarObligatorio(estado, "El estado es obligatorio");
    }

    private static <T> T validarObligatorio(T valor, String mensaje) {
        if (valor == null) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor;
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

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public EstadoCita getEstado() {
        return estado;
    }
}
