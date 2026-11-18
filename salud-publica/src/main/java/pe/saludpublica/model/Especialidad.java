package pe.saludpublica.model;

public class Especialidad {
    private String nombre;
    private String descripcion;

    public Especialidad() {
    }

    public Especialidad(String nombre, String descripcion) {
        if(nombre==null){
            throw new IllegalArgumentException("El nombre de la especialidad es requerido");
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

    @Override
    public String toString() {
        return "Especialidad{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
