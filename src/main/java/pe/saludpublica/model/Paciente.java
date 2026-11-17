package pe.saludpublica.model;

public class Paciente {

    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String telefono;
    private final String correo;

    public Paciente(String documento, String nombres, String apellidos, String telefono, String correo) {
        if (documento == null) {
            throw new IllegalArgumentException("El DNI no puede ser nulo");
        }
        if (nombres == null) {
            throw new IllegalArgumentException("Los nombres no pueden ser nulos");
        }
        if (apellidos == null) {
            throw new IllegalArgumentException("Los apellidos no pueden ser nulos");
        }
        this.documento = documento.trim();
        this.nombres = nombres.trim();
        this.apellidos = apellidos.trim();
        this.telefono = telefono != null ? telefono.trim() : null;
        this.correo = correo != null ? correo.trim() : null;
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
