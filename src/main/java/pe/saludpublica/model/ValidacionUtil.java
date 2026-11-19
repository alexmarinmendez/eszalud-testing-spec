package pe.saludpublica.model;

public final class ValidacionUtil {
    private ValidacionUtil() {} // Evita que se instancie

    public static void requireNonNull(String valor, String nombreCampo) {
        if (valor == null) {
            throw new IllegalArgumentException("El campo '" + nombreCampo + "' es obligatorio");
        }
    }
}
