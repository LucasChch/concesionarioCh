package ar.com.inventarioservice.exception;

public class DatosInventarioCentralInvalidosException extends RuntimeException {
    public DatosInventarioCentralInvalidosException(String mensaje) {
        super(mensaje);
    }
}