package pe.saludpublica.model;

import static pe.saludpublica.model.ValidacionUtil.requireNonNull;

public class Doctor {
    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String colegiatura;
    private final String especialidad;

    public Doctor(String documento, String nombres, String apellidos, String colegiatura, String especialidad) {
        requireNonNull(documento, "documento");
        requireNonNull(nombres, "nombres");
        requireNonNull(apellidos, "apellidos");
        requireNonNull(colegiatura, "colegiatura");

        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.colegiatura = colegiatura;
        this.especialidad = especialidad;
    }

    public String getDocumento() { return documento; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getColegiatura() { return colegiatura; }
    public String getEspecialidad() { return especialidad; }
}
