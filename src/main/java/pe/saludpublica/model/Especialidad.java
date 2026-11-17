package pe.saludpublica.model;

public class Especialidad {

    private final String nombre;
    private final String descripcion;


    public Especialidad(String nombre, String descripcion) {

        if (nombre == null) {
            throw new IllegalArgumentException(
                    "El nombre de la especialidad no puede ser null"
            );
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