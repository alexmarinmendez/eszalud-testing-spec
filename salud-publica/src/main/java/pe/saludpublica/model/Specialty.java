package pe.saludpublica.model;

public class Specialty {

    private String name;
    private String description;

    public Specialty(String name, String description) {
        validateRequired(name, "El nombre de la especialidad es obligatorio");
        this.name = name;
        this.description = description;
    }

    private static void validateRequired(String value, String message) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
