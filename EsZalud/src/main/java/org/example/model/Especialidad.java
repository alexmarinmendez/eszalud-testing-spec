package org.example.model;

import java.util.Objects;

public class Especialidad {
    private String nombre;
    private String descripcion;

    public Especialidad(String nombre, String descripcion) {
        this.nombre = validarTextoObligatorio(nombre, "El nombre de la especialidad es obligatorio");
        this.descripcion = descripcion;
    }

    private static String validarTextoObligatorio(String valor, String mensaje) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = validarTextoObligatorio(nombre, "El nombre de la especialidad es obligatorio");
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Especialidad that)) return false;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Especialidad{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
