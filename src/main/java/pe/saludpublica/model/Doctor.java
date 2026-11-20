package pe.saludpublica.model;

import java.util.Objects;

public class Doctor {

    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String colegiatura;
    private final String especialidad;

    public Doctor(
            String documento,
            String nombres,
            String apellidos,
            String colegiatura,
            String especialidad
    ) {
        this.documento = requireNonBlank(documento, "documento");
        this.nombres = requireNonBlank(nombres, "nombres");
        this.apellidos = requireNonBlank(apellidos, "apellidos");
        this.colegiatura = requireNonBlank(colegiatura, "colegiatura");
        this.especialidad = especialidad;
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

    public String getColegiatura() {
        return colegiatura;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor other)) return false;
        return Objects.equals(documento, other.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }
}