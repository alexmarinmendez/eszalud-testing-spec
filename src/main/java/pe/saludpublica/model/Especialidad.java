package pe.saludpublica.model;

import java.util.Objects;

public class Especialidad {

    private final String nombre;
    private final String descripcion;

    public Especialidad(String nombre, String descripcion) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("nombre must not be null or blank");
        }
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Especialidad other)) return false;
        return Objects.equals(nombre, other.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}