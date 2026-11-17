
package pe.saludpublica.model;

public class Doctor {

    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String colegiatura;
    private final String especialidad;

    public Doctor(
            String documento,
            String nombres,
            String apellidos,
            String colegiatura,
            String especialidad) {

        if (documento == null) {
            throw new IllegalArgumentException(
                    "El documento del doctor no puede ser null"
            );
        }

        if (nombres == null) {
            throw new IllegalArgumentException(
                    "Los nombres del doctor no pueden ser null"
            );
        }

        if (apellidos == null) {
            throw new IllegalArgumentException(
                    "Los apellidos del doctor no pueden ser null"
            );
        }

        if (colegiatura == null) {
            throw new IllegalArgumentException(
                    "La colegiatura del doctor no puede ser null"
            );
        }


        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
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