package pe.saludpublica.model;

import java.util.regex.Pattern;

import static pe.saludpublica.model.Validaciones.requireValue;

public class Paciente {

    private static final Pattern FORMATO_CORREO =
            Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");

    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String telefono;
    private final String correo;

    public Paciente(String documento, String nombres, String apellidos,
                    String telefono, String correo) {
        this.documento = requireValue(documento, "El documento del paciente es obligatorio");
        this.nombres = requireValue(nombres, "Los nombres del paciente son obligatorios");
        this.apellidos = requireValue(apellidos, "Los apellidos del paciente son obligatorios");
        this.telefono = telefono;
        this.correo = validarCorreo(correo);
    }

    private static String validarCorreo(String correo) {
        if (correo != null && !FORMATO_CORREO.matcher(correo).matches()) {
            throw new IllegalArgumentException("El correo del paciente no tiene un formato válido");
        }
        return correo;
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