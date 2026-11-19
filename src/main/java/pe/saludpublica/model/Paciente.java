package pe.saludpublica.model;

import static pe.saludpublica.model.ValidacionUtil.requireNonNull;

public class Paciente {
    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String telefono;
    private final String correo;

    public Paciente(String documento, String nombres, String apellidos, String telefono, String correo) {
        requireNonNull(documento, "documento");
        requireNonNull(nombres, "nombres");
        requireNonNull(apellidos, "apellidos");

        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getDocumento() { return documento; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }
}
