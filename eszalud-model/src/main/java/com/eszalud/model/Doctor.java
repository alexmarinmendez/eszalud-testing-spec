package com.eszalud.model;

public class Doctor {

    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String colegiatura;

    public Doctor(String documento,
                  String nombres,
                  String apellidos,
                  String colegiatura) {

        validarObligatorio(documento, "El documento");
        validarObligatorio(nombres, "Los nombres");
        validarObligatorio(apellidos, "Los apellidos");
        validarObligatorio(colegiatura, "La colegiatura");

        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.colegiatura = colegiatura;
    }

    private static void validarObligatorio(
            String valor, String campo) {

        if (valor == null) {
            throw new IllegalArgumentException(
                    campo + " no puede ser null"
            );
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
}
