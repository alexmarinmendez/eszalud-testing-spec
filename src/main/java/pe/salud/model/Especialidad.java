package pe.salud.model;

public class Especialidad {
    private final String nombre;
    private final String descripcion;

    public Especialidad(String nombre, String descripcion) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la especialidad es obligatorio");
        }

        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
}
