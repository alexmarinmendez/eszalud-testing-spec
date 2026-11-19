package pe.saludpublica.model;

/**
 * Validaciones compartidas por los modelos de EsZalud.
 */
final class Validaciones {

    private Validaciones() {
    }

    static <T> T requireValue(T value, String message) {
        if (value == null) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }
}