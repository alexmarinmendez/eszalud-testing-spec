package pe.saludpublica.model;

/**
 * Validaciones compartidas por los modelos del dominio.
 */
final class Validaciones {

    private Validaciones() {
    }

    /**
     * Devuelve el valor recibido o lanza una excepción si es nulo o está en blanco.
     */
    static String requerido(String valor, String mensaje) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor;
    }
}
