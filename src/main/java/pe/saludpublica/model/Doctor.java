
package pe.saludpublica.model;

public class Doctor {

    private String documento;
    private String nombres;
    private String apellidos;
    private String numeroColegiatura;
    private Especialidad especialidad;

    public Doctor(String documento, String nombres, String apellidos,
                  String numeroColegiatura, Especialidad especialidad) {

        if (documento == null) {
            throw new IllegalArgumentException("El documento no puede ser nulo");
        }

        if (nombres == null) {
            throw new IllegalArgumentException("Los nombres no pueden ser nulos");
        }

        if (apellidos == null) {
            throw new IllegalArgumentException("Los apellidos no pueden ser nulos");
        }

        if (numeroColegiatura == null) {
            throw new IllegalArgumentException("La colegiatura no puede ser nula");
        }

        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numeroColegiatura = numeroColegiatura;
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

    public String getNumeroColegiatura() {
        return numeroColegiatura;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
