package pe.saludpublica.model;

final class Validaciones {

    private Validaciones() {
    }

    static <T> T requerido(T valor, String campo) {
        if (valor == null) {
            throw new IllegalArgumentException(campo + " es obligatorio");
        }
        return valor;
    }
}