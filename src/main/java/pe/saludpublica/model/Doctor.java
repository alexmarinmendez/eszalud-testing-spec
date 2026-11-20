package pe.saludpublica.model;

public class Doctor {

    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String colegiatura;
    private final String especialidad;

    public Doctor(String documento, String nombres, String apellidos, String colegiatura, String especialidad) {
        this.documento = validarObligatorio(documento, "El documento es obligatorio");
        this.nombres = validarObligatorio(nombres, "Los nombres son obligatorios");
        this.apellidos = validarObligatorio(apellidos, "Los apellidos son obligatorios");
        this.colegiatura = validarObligatorio(colegiatura, "La colegiatura es obligatoria");
        this.especialidad = especialidad;
    }

    private String validarObligatorio(String valor, String mensaje) {
        if (valor == null) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor;
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