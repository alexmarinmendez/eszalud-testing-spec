package pe.saludpublica.model;

public class Doctor {

    private String documento;
    private String nombres;
    private String apellidos;
    private String colegiatura;
    private String specialtyId;

    public Doctor(String documento, String nombres, String apellidos,
                  String colegiatura, String specialtyId) {

        validarCampo(documento, "El documento");
        validarCampo(nombres, "Los nombres");
        validarCampo(apellidos, "Los apellidos");
        validarCampo(colegiatura, "La colegiatura");

        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.colegiatura = colegiatura;
        this.specialtyId = specialtyId;
    }

    private void validarCampo(String valor, String campo) {
        if (valor == null) {
            throw new IllegalArgumentException(campo + " es obligatorio");
        }
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

    public String getSpecialtyId() {
        return specialtyId;
    }
}
