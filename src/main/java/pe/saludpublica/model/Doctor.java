package pe.saludpublica.model;

/** Modelo de doctor desarrollado mediante TDD. */
public class Doctor {
    private String documento;
    private String nombres;
    private String apellidos;
    private String colegiatura;
    private String especialidad;

    public Doctor(String documento, String nombres, String apellidos,
                  String colegiatura, String especialidad) {
        if (documento == null){
            throw new IllegalArgumentException("El documento es obligatorio");
        }
        this.documento = documento;
        if (nombres == null){
            throw new IllegalArgumentException("Los nombres son obligatorios");
        }
        this.nombres = nombres;
        if (apellidos == null){
            throw new IllegalArgumentException("Los apellidos son obligatorios");
        }
        this.apellidos = apellidos;
        if (colegiatura == null){
            throw new IllegalArgumentException("La colegiatura es obligatoria");
        }
        this.colegiatura = colegiatura;
        this.especialidad = especialidad;
    }

    public String getDocumento() { return documento; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getColegiatura() { return colegiatura; }
    public String getEspecialidad() { return especialidad; }
}
