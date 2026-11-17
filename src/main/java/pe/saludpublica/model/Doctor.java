package pe.saludpublica.model;

public class Doctor{

private final String documento;
private final String nombres;
private final String apellidos;
private final String colegiatura;
private final String especialidad;

public Doctor(String documento, String nombres, String apellidos, String colegiatura, String especialidad) {
    validarDocumento(documento);
    validarColegiatura(colegiatura);
    validarNombre(nombres);
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
    private void validarNombre(String nombre) {
    if (nombre == null) {
        throw new IllegalArgumentException(("El nombre es obligatorio"));
        }
    }

public String getDocumento() { return documento; }
public String getNombres() { return nombres; }
public String getApellidos() { return apellidos; }
public String getColegiatura() { return colegiatura; }
public String getEspecialidad() { return especialidad; }
}