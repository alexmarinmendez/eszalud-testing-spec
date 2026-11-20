package pe.saludpublica.model;

public class Paciente {

    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String telefono;
    private final String correo;

    public Paciente(String documento, String nombres, String apellidos, String telefono, String correo) {
        this.documento = validarObligatorio(documento, "documento");
        this.nombres = validarObligatorio(nombres, "nombres");
        this.apellidos = validarObligatorio(apellidos, "apellidos");
        this.telefono = telefono;
        this.correo = correo;
    }

    private static <T> T validarObligatorio(T valor, String campo) {
        if (valor == null) {
            throw new IllegalArgumentException("El campo " + campo + " es obligatorio");
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
