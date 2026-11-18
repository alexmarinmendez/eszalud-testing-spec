package pe.saludpublica.model;

/**
 * Modelo que representa una especialidad médica.
 */
public class Especialidad {

    private final String nombre;
    private final String descripcion;

    public Especialidad(String nombre, String descripcion) {
        requireText(nombre, "El nombre es obligatorio");

        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    private static void requireText(String value, String message) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
