package ar.com.automotorservice.exception;

public class DatosAutomotorInvalidosException extends RuntimeException {
    public DatosAutomotorInvalidosException(String mensaje) {
        super(mensaje);
    }
}