package pe.saludpublica.model;

public class Paciente {

    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String telefono;
    private final String correo;

    public Paciente(String documento, String nombres, String apellidos,
                    String telefono, String correo) {
        this.documento = requerido(documento, "El documento del paciente es obligatorio");
        this.nombres = requerido(nombres, "Los nombres del paciente son obligatorios");
        this.apellidos = requerido(apellidos, "Los apellidos del paciente son obligatorios");
        this.telefono = telefono;
        this.correo = correo;
    }

    private static String requerido(String valor, String mensaje) {
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
