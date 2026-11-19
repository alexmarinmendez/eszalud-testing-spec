package pe.saludpublica.model;

public class Especialidad {
    private final String nombre;
    private final String descripcion;

    public Especialidad(String nombre, String descripcion) {
        this.nombre = validateRequiredText(nombre,"El nombre de la especialidad es obligatorio");
        this.descripcion = descripcion;
    }

    private String validateRequiredText(String value, String alertMenssage) {
        if (value == null || value.isBlank() ) {
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
