package pe.saludpublica.model;

public class Paciente {

    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String telefono;
    private final String correo;

    public Paciente(String documento, String nombres,
                    String apellidos, String telefono, String correo) {
        if (nombres == null) {
            throw new IllegalArgumentException("Los nombres no pueden ser nulos");
        }
        if (documento == null) {
            throw new IllegalArgumentException("El documento no puede ser nulo");
        }
        if (apellidos == null) {
            throw new IllegalArgumentException("Los apellidos no pueden ser nulos");
        }

        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
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