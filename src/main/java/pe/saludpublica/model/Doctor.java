package pe.saludpublica.model;

public class Doctor {

    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String colegiatura;
    private final String especialidad;

    public Doctor(String documento, String nombres, String apellidos, String colegiatura, String especialidad) {
        this.documento = requireNonNullField(documento, "El documento del doctor no puede ser nulo").trim();
        this.nombres = requireNonNullField(nombres, "Los nombres del doctor no pueden ser nulos").trim();
        this.apellidos = requireNonNullField(apellidos, "Los apellidos del doctor no pueden ser nulos").trim();
        this.colegiatura = requireNonNullField(colegiatura, "La colegiatura del doctor no puede ser nula").trim();
        this.especialidad = especialidad != null ? especialidad.trim() : null;
    }

    private String requireNonNullField(String value, String errorMessage) {
        if (value == null) {
            throw new IllegalArgumentException(errorMessage);
        }
        return value;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getColegiatura() {
        return colegiatura;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
