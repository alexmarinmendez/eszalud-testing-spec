package pe.saludpublica.model;

public class Especialidad {
    private final String nombre;
    private final String descripcion;

    public Especialidad(String nombre, String descripcion) {
        this.nombre = requerido(nombre, "nombre");
        this.descripcion = descripcion;
    }

    private String requerido(String valor, String campo) {
        if (valor == null) {
            throw new IllegalArgumentException(
                    "El campo " + campo + " es obligatorio"
            );
        }
        return valor;
    }

    public String getNombre()      { return nombre; }
    public String getDescripcion() { return descripcion; }
}