package pe.saludpublica.model;

public class Doctor {

    private String documento;
    private String nombres;
    private String apellidos;
    private String colegiatura;
    private String especialidadId;

    public Doctor(String documento, String nombres, String apellidos, String colegiatura, String especialidadId) {

        if (documento == null) {
            throw new IllegalArgumentException("El documento del doctor es obligatorio");
        }
        this.documento = documento;

        if (colegiatura == null) {
            throw new IllegalArgumentException("La colegiatura del doctor es obligatoria");
        }
        this.colegiatura = colegiatura;

        this.nombres = nombres;
        this.apellidos = apellidos;
        this.especialidadId = especialidadId;
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

    public String getEspecialidadId() {
        return especialidadId;
    }
}
