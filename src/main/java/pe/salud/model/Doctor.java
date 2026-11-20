package pe.salud.model;

public class Doctor {

    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String colegiatura;
    private final String especialidad;

    public Doctor(String documento, String nombres, String apellidos, String colegiatura, String especialidad) {
        if (documento == null || documento.isBlank()) {
            throw new IllegalArgumentException("El documento es obligatorio");
        }
        if (nombres == null || nombres.isBlank()) {
            throw new IllegalArgumentException("Los nombres son obligatorios");
        }
        if (apellidos == null || apellidos.isBlank()) {
            throw new IllegalArgumentException("Los apellidos son obligatorios");
        }
        if (colegiatura == null || colegiatura.isBlank()) {
            throw new IllegalArgumentException("La colegiatura es obligatoria");
        }

        this.documento = validarCampoObligatorio(documento, "El documento es obligatorio");
        this.nombres = validarCampoObligatorio(nombres, "Los nombres son obligatorios");
        this.apellidos = validarCampoObligatorio(apellidos, "Los apellidos son obligatorios");
        this.colegiatura = validarCampoObligatorio(colegiatura, "La colegiatura es obligatoria");
        this.especialidad = especialidad;
    }

    private String validarCampoObligatorio(String valor, String mensaje) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor;
    }


public String getDocumento() { return documento; }
public String getNombres() { return nombres; }
public String getApellidos() { return apellidos; }
public String getColegiatura() { return colegiatura; }
public String getEspecialidad() { return especialidad; }
}