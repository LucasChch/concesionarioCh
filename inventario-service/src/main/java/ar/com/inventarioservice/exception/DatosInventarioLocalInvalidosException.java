package ar.com.inventarioservice.exception;

public class DatosInventarioLocalInvalidosException extends RuntimeException {
    public DatosInventarioLocalInvalidosException(String mensaje) {
        super(mensaje);
    }
}