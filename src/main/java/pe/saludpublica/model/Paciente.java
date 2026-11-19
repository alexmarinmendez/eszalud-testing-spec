package pe.saludpublica.model;

public class Paciente {

    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String telefono;
    private final String correo;

    public Paciente(String documento, String nombres, String apellidos, String telefono, String correo) {

        if (documento == null || documento.isBlank()) {
            throw new IllegalArgumentException("El documento es obligatorio");
        }

        if (nombres == null || nombres.isBlank()) {
            throw new IllegalArgumentException("Los nombres son obligatorios");
        }

        if (apellidos == null || apellidos.isBlank()) {
            throw new IllegalArgumentException("Los apellidos son obligatorios");
        }

        this.documento = validarCampoObligatorio(documento, "El documento es obligatorio");
        this.nombres = validarCampoObligatorio(nombres, "Los nombres son obligatorios");
        this.apellidos = validarCampoObligatorio(apellidos, "Los apellidos son obligatorios");
        this.telefono = telefono;
        this.correo = correo;
    }

    private String validarCampoObligatorio(String valor, String mensaje) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor;
    }


    public String getDocumento() { return documento; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }


}
