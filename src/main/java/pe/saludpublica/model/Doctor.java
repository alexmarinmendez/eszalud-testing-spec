package pe.saludpublica.model;

/**
 * Doctor registrado en el establecimiento de salud.
 */
public class Doctor {

    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String colegiatura;
    private final String especialidad;

    public Doctor(String documento, String nombres, String apellidos, String colegiatura, String especialidad) {
        this.documento = Validaciones.requerido(documento, "El documento del doctor es obligatorio");
        this.nombres = Validaciones.requerido(nombres, "Los nombres del doctor son obligatorios");
        this.apellidos = Validaciones.requerido(apellidos, "Los apellidos del doctor son obligatorios");
        this.colegiatura = Validaciones.requerido(colegiatura, "La colegiatura del doctor es obligatoria");
        this.especialidad = Validaciones.requerido(especialidad, "La especialidad del doctor es obligatoria");
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
