package pe.saludpublica.model;

public class Doctor {
    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String colegiatura;
    private final String especialidad;

    public Doctor(String documento, String nombres, String apellidos,
                  String colegiatura, String especialidad) {
        this.documento = requerido(documento, "documento");
        this.nombres = requerido(nombres, "nombres");
        this.apellidos = requerido(apellidos, "apellidos");
        this.colegiatura = requerido(colegiatura, "colegiatura");
        this.especialidad = especialidad;
    }

    private String requerido(String valor, String campo) {
        if (valor == null) {
            throw new IllegalArgumentException(
                    "El campo " + campo + " es obligatorio"
            );
        }
        return valor;
    }

    public String getDocumento()    { return documento; }
    public String getNombres()      { return nombres; }
    public String getApellidos()    { return apellidos; }
    public String getColegiatura()  { return colegiatura; }
    public String getEspecialidad() { return especialidad; }
}