package pe.saludpublica.model;

public class Especialidad {

    private final String nombre;
    private final String descripcion;

    public Especialidad(String nombre, String descripcion) {
        this.nombre = requireText(nombre, "El nombre es obligatorio");
        this.descripcion = descripcion;
    }

    private static String requireText(String value, String message) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
}