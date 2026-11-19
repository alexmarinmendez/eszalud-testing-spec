package pe.saludpublica.model;

import static pe.saludpublica.model.Validaciones.requireValue;

public class Doctor {

    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String colegiatura;
    private final String especialidad;

    public Doctor(String documento, String nombres, String apellidos,
                  String colegiatura, String especialidad) {
        this.documento = requireValue(documento, "El documento del doctor es obligatorio");
        this.nombres = requireValue(nombres, "Los nombres del doctor son obligatorios");
        this.apellidos = requireValue(apellidos, "Los apellidos del doctor son obligatorios");
        this.colegiatura = requireValue(colegiatura, "La colegiatura del doctor es obligatoria");
        this.especialidad = especialidad;
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