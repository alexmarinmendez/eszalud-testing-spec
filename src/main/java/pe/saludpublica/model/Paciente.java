
package pe.saludpublica.model;

/**
 * Modelo que representa a un paciente.
 */
public class Paciente {

    private String documento;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;

    public Paciente(String documento, String nombres, String apellidos,
                    String telefono, String correo) {

        validarCampo(documento, "El documento");
        validarCampo(nombres, "Los nombres");
        validarCampo(apellidos, "Los apellidos");

        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
    }

    private void validarCampo(String valor, String campo) {
        if (valor == null) {
            throw new IllegalArgumentException(campo + " no puede ser null");
        }
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
