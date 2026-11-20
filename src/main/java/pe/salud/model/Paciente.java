package pe.salud.model;

public class Paciente {

    private final String documento;
    private final String nombre;
    private final String apellido;
    private final String telefono;
    private final String correo;

    public Paciente(String documento, String nombre, String apellido, String telefono, String correo) {
        if (documento == null || documento.isBlank()) {
            throw new IllegalArgumentException("El documento es obligatorio");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Los nombres son obligatorios");
        }
        if (apellido == null || apellido.isBlank()) {
            throw new IllegalArgumentException("Los apellidos son obligatorios");
        }


        this.documento = validarCampoObligatorio(documento, "El documento es obligatorio");
        this.nombre = validarCampoObligatorio(nombre, "Los nombres son obligatorios");
        this.apellido = validarCampoObligatorio(apellido, "Los apellidos son obligatorios");
        this.telefono = telefono;
        this.correo = correo;


    }

    private String validarCampoObligatorio(String valor, String mensaje) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }
}
