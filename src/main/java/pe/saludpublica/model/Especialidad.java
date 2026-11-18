package pe.saludpublica.model;

public class Especialidad {
    private final String codigo;
    private final String nombre;

    public Especialidad(String codigo, String nombre) {
        validarNombre(nombre);
        this.codigo = codigo;
        this.nombre = nombre;
    }

    private void validarNombre(String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException("El nombre de la especialidad es obligatorio");
        }
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
}