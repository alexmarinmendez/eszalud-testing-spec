package pe.saludpublica.model;

/**
 * Especialidad médica disponible en el establecimiento de salud.
 */
public class Especialidad {

    private final String nombre;
    private final String descripcion;

    public Especialidad(String nombre, String descripcion) {
        this.nombre = Validaciones.requerido(nombre, "El nombre de la especialidad es obligatorio");
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
