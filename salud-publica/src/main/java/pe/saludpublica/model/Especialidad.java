package pe.saludpublica.model;

public class Especialidad {

    private final String nombre;
    private final String descripcion;

    public Especialidad(String nombre, String descripcion) {
        this.nombre = requireNotNull(nombre, "El nombre de la especialidad es obligatorio");
        this.descripcion = descripcion;
    }

    private static String requireNotNull(String value, String message) {
        if (value == null) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
