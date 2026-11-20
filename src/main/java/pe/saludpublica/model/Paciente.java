package pe.saludpublica.model;

public class Paciente {

    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String telefono;
    private final String correo;

    public Paciente(String documento, String nombres, String apellidos, String telefono, String correo) {
        this.documento = validarObligatorio(documento, "El documento es obligatorio");
        this.nombres = validarObligatorio(nombres, "Los nombres son obligatorios");
        this.apellidos = validarObligatorio(apellidos, "Los apellidos son obligatorios");
        this.telefono = telefono;
        this.correo = correo;
    }

    private String validarObligatorio(String valor, String mensaje) {
        if (valor == null) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }
}