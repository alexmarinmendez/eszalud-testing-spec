package pe.saludpublica.model;

public class Especialidad {

    private String nombre;
    private String descripcion;

    public Especialidad(String nombre, String descripcion) {
        if (nombre == null) {
            throw new IllegalArgumentException("El nombre es obligatorio");
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
}
