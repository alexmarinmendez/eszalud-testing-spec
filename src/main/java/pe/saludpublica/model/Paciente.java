package pe.saludpublica.model;

import java.util.Objects;

public class Paciente {

    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String telefono;
    private final String correo;

    public Paciente(
            String documento,
            String nombres,
            String apellidos,
            String telefono,
            String correo
    ) {
        this.documento = requireNonBlank(documento, "documento");
        this.nombres = requireNonBlank(nombres, "nombres");
        this.apellidos = requireNonBlank(apellidos, "apellidos");
        this.telefono = telefono;
        this.correo = correo;
    }

    private static String requireNonBlank(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " must not be null or blank");
        }
        return value;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paciente other)) return false;
        return Objects.equals(documento, other.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }
}