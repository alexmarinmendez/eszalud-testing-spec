package com.eszalud.model;

public class Paciente {
    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String telefono;
    private final String correo;


    public Paciente(String documento,
                    String nombres,
                    String apellidos,
                    String telefono,
                    String correo) {

        validarObligatorio(documento, "El documento");
        validarObligatorio(nombres, "Los nombres");
        validarObligatorio(apellidos, "Los apellidos");

        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;

    }
    private static void validarObligatorio(String valor, String campo) {
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

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }
}