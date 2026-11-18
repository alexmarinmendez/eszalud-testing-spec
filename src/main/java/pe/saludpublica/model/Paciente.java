package pe.saludpublica.model;

public class Paciente {

    private String documento;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;

    public Paciente(String documento, String nombres,
                    String apellidos, String telefono, String correo) {



        if (nombres == null) {
            throw new IllegalArgumentException("Los nombres no pueden ser null");
        }

        if (apellidos == null) {
            throw new IllegalArgumentException("Los apellidos no pueden ser null");
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