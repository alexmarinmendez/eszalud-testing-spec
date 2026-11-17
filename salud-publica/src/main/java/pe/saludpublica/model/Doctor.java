package pe.saludpublica.model;

public class Doctor {

    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String colegiatura;
    private final String especialidad;

    public Doctor(String documento, String nombres, String apellidos, String colegiatura, String especialidad) {
        this.documento = requireNotNull(documento, "El documento es obligatorio");
        this.nombres = requireNotNull(nombres, "Los nombres son obligatorios");
        this.apellidos = requireNotNull(apellidos, "Los apellidos son obligatorios");
        this.colegiatura = requireNotNull(colegiatura, "La colegiatura es obligatoria");
        this.especialidad = especialidad;
    }

    private static String requireNotNull(String value, String message) {
        if (value == null) {
            throw new IllegalArgumentException(message);
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
