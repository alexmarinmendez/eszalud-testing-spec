package pe.saludpublica.model;

final class Validaciones {

    private Validaciones() {
    }

    static void requerido(Object valor, String mensaje) {
        if (valor == null) {
            throw new IllegalArgumentException(mensaje);
        }
    }
}