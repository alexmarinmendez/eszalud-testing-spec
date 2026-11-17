
package pe.saludpublica.model;

public class Especialidad {

    private String nombre;
    private String descripcion;


    public Especialidad(String nombre, String descripcion) {
        this.nombre = validarNombre(nombre);
        this.descripcion = descripcion;
    }

    private static String validarNombre(String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        return nombre;
    }


    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
