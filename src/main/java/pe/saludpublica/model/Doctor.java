package pe.saludpublica.model;

public class Doctor{

private String documento;
private String nombres;
private String apellidos;
private String colegiatura;
private String especialidad;

public Doctor(String documento, String nombres, String apellidos, String colegiatura, String especialidad) {
    validarDocumento(documento);
    validarColegiatura(colegiatura);
    this.documento = documento;
    this.nombres = nombres;
    this.apellidos = apellidos;
    this.colegiatura = colegiatura;
    this.especialidad = especialidad;
}
    private void validarDocumento(String documento) {
        if (documento == null) {
            throw new IllegalArgumentException("El documento es obligatorio");
        }
    }
    private void validarColegiatura(String colegiatura) {
        if (colegiatura == null) {
            throw new IllegalArgumentException("La colegiatura es obligatoria");
        }
    }

public String getDocumento() { return documento; }
public String getNombres() { return nombres; }
public String getApellidos() { return apellidos; }
public String getColegiatura() { return colegiatura; }
public String getEspecialidad() { return especialidad; }
}