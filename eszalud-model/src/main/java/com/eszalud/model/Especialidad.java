package com.eszalud.model;

public class Especialidad {

    private final String codigo;
    private final String nombre;

    public Especialidad(String codigo, String nombre){
        if (nombre == null) {
            throw new IllegalArgumentException(
                    "El nombre no puede ser null"
            );
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
