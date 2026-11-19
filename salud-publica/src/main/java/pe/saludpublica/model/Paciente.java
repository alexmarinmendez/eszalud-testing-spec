package pe.saludpublica.model;

public class Paciente {

    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String telefono;
    private final String correo;

    public Paciente(String documento, String nombres, String apellidos, String telefono, String correo) {
        this.documento = validateRequiredText(documento, "El documento es obligatorio");
        this.nombres = validateRequiredText(nombres, "Los nombres es obligatorio");
        this.apellidos = validateRequiredText(apellidos, "Los apellidos es obligatorio");
        this.telefono = telefono;
        this.correo = correo;
    }

    private String validateRequiredText(String value, String alertMenssage) {
        if (value == null || value.isBlank() ) {
            throw new IllegalArgumentException(alertMenssage);
        }
        return value.trim();
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
