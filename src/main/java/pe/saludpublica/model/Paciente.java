package pe.saludpublica.model;

public class Paciente {
    private String documento;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;

    public Paciente(String documento, String nombres, String apellidos, String telefono, String correo) {
        validarObligatorio(documento, "El documento es obligatorio");
        validarObligatorio(nombres, "Los nombres son obligatorios");
        validarObligatorio(apellidos, "Los apellidos son obligatorios");

        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
    }

    private void validarObligatorio(String valor, String mensaje) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
    }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { validarObligatorio(documento, "El documento es obligatorio"); this.documento = documento; }
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { validarObligatorio(nombres, "Los nombres son obligatorios"); this.nombres = nombres; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { validarObligatorio(apellidos, "Los apellidos son obligatorios"); this.apellidos = apellidos; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}
