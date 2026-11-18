package pe.saludpublica.model;

final class Validaciones {

    private Validaciones() {
    }

    static <T> T requerido(T valor, String mensaje) {
        if (valor == null) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor;
    }
}