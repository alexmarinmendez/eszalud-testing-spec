package pe.saludpublica.model;

public class Especialidad {
    private String nombre;
    private String descripcion;

    public Especialidad(String nombre, String descripcion) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la especialidad es obligatorio");
        }
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) { throw new IllegalArgumentException("El nombre de la especialidad es obligatorio"); }
        this.nombre = nombre;
    }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
