package pe.saludpublica.model;

public class Paciente {
    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String telefono;
    private final String correo;

    public Paciente(String documento, String nombres, String apellidos, String telefono, String correo) {
        validarDocumento(documento);
        validarNombres(nombres);
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
    }

    private void validarDocumento(String documento) {
        if (documento == null) {
            throw new IllegalArgumentException("El documento es obligatorio");
        }
    }
    private void validarNombres(String nombres) {
        if (nombres == null) {
            throw new IllegalArgumentException("Los nombres son obligatorios");
        }
    }

    public String getDocumento() { return documento; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }
}