package pe.saludpublica.model;

public class Doctor {
    private String documento;
    private String nombres;
    private String apellidos;
    private String colegiatura;
    private String especialidad;

    public Doctor(String documento, String nombres, String apellidos, String colegiatura, String especialidad) {
        if (documento == null || documento.trim().isEmpty()) {
            throw new IllegalArgumentException("El documento no puede ser nulo o vacío");
        }
        if (nombres == null || nombres.trim().isEmpty()) {
            throw new IllegalArgumentException("Los nombres no pueden ser nulos o vacíos");
        }
        if (apellidos == null || apellidos.trim().isEmpty()) {
            throw new IllegalArgumentException("Los apellidos no pueden ser nulos o vacíos");
        }
        if (colegiatura == null || colegiatura.trim().isEmpty()) {
            throw new IllegalArgumentException("La colegiatura no puede ser nula o vacía");
        }
        if (especialidad == null || especialidad.trim().isEmpty()) {
            throw new IllegalArgumentException("La especialidad no puede ser nula o vacía");
        }

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