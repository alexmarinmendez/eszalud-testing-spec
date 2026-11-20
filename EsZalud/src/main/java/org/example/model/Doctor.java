
package org.example.model;

import java.util.Objects;

public class Doctor {

    private String documento;
    private String nombres;
    private String apellidos;
    private String colegiatura;
    private String especialidad;

    public Doctor(
            String documento,
            String nombres,
            String apellidos,
            String colegiatura,
            String especialidad) {

        setDocumento(documento);
        setNombres(nombres);
        setApellidos(apellidos);
        setColegiatura(colegiatura);
        setEspecialidad(especialidad);
    }

    private static String validarTextoObligatorio(String valor, String mensaje) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }

        return valor.trim();
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = validarTextoObligatorio(
                documento, "El documento es obligatorio");
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = validarTextoObligatorio(
                nombres, "Los nombres son obligatorios");
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = validarTextoObligatorio(
                apellidos, "Los apellidos son obligatorios");
    }

    public String getColegiatura() {
        return colegiatura;
    }

    public void setColegiatura(String colegiatura) {
        this.colegiatura = validarTextoObligatorio(
                colegiatura, "La colegiatura es obligatoria");
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = validarTextoObligatorio(
                especialidad, "La especialidad es obligatoria");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor doctor)) return false;

        return Objects.equals(documento, doctor.documento)
                && Objects.equals(colegiatura, doctor.colegiatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento, colegiatura);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "documento='" + documento + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", colegiatura='" + colegiatura + '\'' +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}
