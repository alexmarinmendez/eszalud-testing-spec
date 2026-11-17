package pe.saludpublica.model;

public class Especialidad {
    private String nombre;
    private String descripcion;

    public Especialidad(String nombre, String descripcion) {
        this.nombre = validateRequiredText(nombre,"El nombre de la especialidad es obligatorio");
        this.descripcion = descripcion;
    }

    private String validateRequiredText(String value, String alertMenssage) {
        if (value == null ) {
            throw new IllegalArgumentException(alertMenssage);
        }
        return value.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
