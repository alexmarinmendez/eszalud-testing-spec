package pe.saludpublica.model;

public class Paciente {

    private String documento;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;

    public Paciente() {
    }

    public Paciente(String documento, String nombres, String apellidos, String telefono, String correo) {
        if(documento==null){
            throw new IllegalArgumentException("El documento del paciente es obligatorio");
        }
        this.documento = documento;
        if (nombres == null){
            throw new IllegalArgumentException("Los nombres del paciente son obligatorios");
        }
        this.nombres = nombres;
        if(apellidos == null){
            throw new IllegalArgumentException("Los apellidos del paciente son obligatorios");
        }
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

    @Override
    public String toString() {
        return "Paciente{" +
                "documento='" + documento + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
