package pe.saludpublica.model;

public class Doctor {

    private String documento;
    private String nombres;
    private String apellidos;
    private String colegiatura;
    private String especialidad;

    public Doctor() {
    }

    public Doctor(String documento, String nombres, String apellidos, String colegiatura, String especialidad) {
        if(documento==null){
            throw new IllegalArgumentException("El documento del doctor es obligatorio");
        }
        this.documento = documento;
        if(nombres==null){
            throw new IllegalArgumentException("El nombre del doctor es obligatorio");
        }
        this.nombres = nombres;
        if(apellidos==null){
            throw new IllegalArgumentException("Los apellidos doctor son obligatorios");
        }
        this.apellidos = apellidos;
        if(colegiatura==null){
            throw new IllegalArgumentException("La colegiatura del doctor es obligatoria");
        }
        this.colegiatura = colegiatura;
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
