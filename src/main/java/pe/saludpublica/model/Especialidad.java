package pe.saludpublica.model;

import static pe.saludpublica.model.ValidacionUtil.requireNonNull;

public class Especialidad {
    private final String nombre;
    private final String descripcion;

    public Especialidad(String nombre, String descripcion) {
        requireNonNull(nombre, "nombre");
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
}
