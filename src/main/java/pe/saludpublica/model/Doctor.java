package pe.saludpublica.model;

public class Doctor {
    private String documento;
    private String nombres;
    private String apellidos;
    private String colegiatura;
    private String especialidad;

    public Doctor(String documento, String nombres, String apellidos, String colegiatura, String especialidad) {
        validarObligatorio(documento, "El documento del doctor es obligatorio");
        validarObligatorio(nombres, "Los nombres del doctor son obligatorios");
        validarObligatorio(apellidos, "Los apellidos del doctor son obligatorios");
        validarObligatorio(colegiatura, "La colegiatura es obligatoria");

        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.colegiatura = colegiatura;
        this.especialidad = especialidad;
    }

    private void validarObligatorio(String valor, String mensaje) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
    }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { validarObligatorio(documento, "El documento del doctor es obligatorio"); this.documento = documento; }
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { validarObligatorio(nombres, "Los nombres del doctor son obligatorios"); this.nombres = nombres; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { validarObligatorio(apellidos, "Los apellidos del doctor son obligatorios"); this.apellidos = apellidos; }
    public String getColegiatura() { return colegiatura; }
    public void setColegiatura(String colegiatura) { validarObligatorio(colegiatura, "La colegiatura es obligatoria"); this.colegiatura = colegiatura; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
}
