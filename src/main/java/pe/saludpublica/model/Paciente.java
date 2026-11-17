package pe.saludpublica.model;

public class Paciente {

    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String telefono;
    private final String correo;

    public Paciente(String documento, String nombres, String apellidos, String telefono, String correo) {
        this.documento = requireAndTrim(documento, "El DNI no puede ser nulo");
        this.nombres = requireAndTrim(nombres, "Los nombres no pueden ser nulos");
        this.apellidos = requireAndTrim(apellidos, "Los apellidos no pueden ser nulos");
        this.telefono = trimOrNull(telefono);
        this.correo = trimOrNull(correo);
    }

    private String requireAndTrim(String value, String errorMessage) {
        if (value == null) {
            throw new IllegalArgumentException(errorMessage);
        }
        return value.trim();
    }

    private String trimOrNull(String value) {
        return value != null ? value.trim() : null;
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
