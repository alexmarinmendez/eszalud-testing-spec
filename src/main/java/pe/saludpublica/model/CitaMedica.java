package pe.saludpublica.model;
import java.time.LocalDateTime;
public class CitaMedica {
    private String paciente, doctor, especialidad, motivo; private LocalDateTime fechaHora; private EstadoCita estado;
    public CitaMedica(String paciente, String doctor, String especialidad, LocalDateTime fechaHora, String motivo, EstadoCita estado) { this.paciente = paciente; this.doctor = doctor; this.especialidad = especialidad; this.fechaHora = fechaHora; this.motivo = motivo; this.estado = estado; }
}
