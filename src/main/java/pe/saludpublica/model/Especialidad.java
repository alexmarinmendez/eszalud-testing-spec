package pe.saludpublica.model;

public class Especialidad {
    private String codigo;
    private String nombre;
    private String descripcion;

    public Especialidad(String codigo, String nombre, String descripcion) {
        if (nombre == null|| nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Especialidad(String codigo, String nombre) {
        this(codigo, nombre, null);
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
}