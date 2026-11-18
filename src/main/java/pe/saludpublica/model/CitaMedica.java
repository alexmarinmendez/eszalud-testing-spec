package pe.saludpublica.model;

public class CitaMedica {

    private String patientId;
    private String doctorId;
    private String specialtyId;
    private String fechaHora;
    private String motivo;
    private String estado;

    public CitaMedica(String patientId, String doctorId, String specialtyId,
                      String fechaHora, String motivo, String estado) {

        validarCampo(patientId, "El identificador del paciente");
        validarCampo(doctorId, "El identificador del doctor");
        validarCampo(specialtyId, "El identificador de la especialidad");
        validarCampo(fechaHora, "La fecha y hora");
        validarCampo(estado, "El estado");

        this.patientId = patientId;
        this.doctorId = doctorId;
        this.specialtyId = specialtyId;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.estado = estado;
    }

    private void validarCampo(String valor, String campo) {
        if (valor == null) {
            throw new IllegalArgumentException(campo + " es obligatorio");
        }
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getSpecialtyId() {
        return specialtyId;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getEstado() {
        return estado;
    }
}