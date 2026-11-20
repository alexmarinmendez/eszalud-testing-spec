package pe.saludpublica.model;

public class Doctor {

    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String colegiatura;
    private final String especialidad;

    public Doctor(String documento, String nombres, String apellidos, String colegiatura, String especialidad) {
        this.documento = validarObligatorio(documento, "documento");
        this.nombres = validarObligatorio(nombres, "nombres");
        this.apellidos = validarObligatorio(apellidos, "apellidos");
        this.colegiatura = validarObligatorio(colegiatura, "colegiatura");
        this.especialidad = especialidad;
    }

    private static <T> T validarObligatorio(T valor, String campo) {
        if (valor == null) {
            throw new IllegalArgumentException("El campo " + campo + " es obligatorio");
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
