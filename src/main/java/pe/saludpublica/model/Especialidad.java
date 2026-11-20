package pe.saludpublica.model;

public class Especialidad {

    private final String nombre;
    private final String descripcion;

    public Especialidad(String nombre, String descripcion) {
        this.nombre = validarObligatorio(nombre, "El nombre de la especialidad es obligatorio");
        this.descripcion = descripcion;
    }

    private String validarObligatorio(String valor, String mensaje) {
        if (valor == null) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
}