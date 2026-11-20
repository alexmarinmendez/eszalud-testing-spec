package pe.saludpublica.model;

public class Doctor {

    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String colegiatura;
    private final String especialidad;

    public Doctor(String documento, String nombres, String apellidos,
                  String colegiatura, String especialidad) {
        this.documento = Validaciones.requerido(documento, "El documento");
        this.nombres = Validaciones.requerido(nombres, "Los nombres");
        this.apellidos = Validaciones.requerido(apellidos, "Los apellidos");
        this.colegiatura = Validaciones.requerido(colegiatura, "La colegiatura");
        this.especialidad = especialidad;
    }

    public String getDocumento() { return documento; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getColegiatura() { return colegiatura; }
    public String getEspecialidad() { return especialidad; }
}