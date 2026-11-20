package com.eszalud.model;

public class Especialidad {

    private String codigo;
    private String nombre;

    public Especialidad(String codigo, String nombre) {



        if (nombre == null) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
}