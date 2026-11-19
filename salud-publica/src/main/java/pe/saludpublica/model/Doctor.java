package pe.saludpublica.model;

public class Doctor {

    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String colegiatura;
    private final String especialidad;

    public Doctor(String documento, String nombres, String apellidos, String colegiatura, String especialidad) {

        this.documento = validateRequiredText(documento, "El documento es obligatorio");
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.colegiatura = validateRequiredText(colegiatura, "La colegiatura es obligatoria");
        this.especialidad = especialidad;
    }

    private String validateRequiredText(String value, String alertMenssage) {
        if (value == null || value.isBlank() ) {
            throw new IllegalArgumentException(alertMenssage);
        }
        return value.trim();
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
