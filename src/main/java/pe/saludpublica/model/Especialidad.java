package pe.saludpublica.model;

public class Especialidad {

    private final String codigo;
    private final String nombre;

    public Especialidad(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
}