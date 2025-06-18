package ar.com.sucursalservice.exception;

public class DatosSucursalInvalidosException extends RuntimeException {
    public DatosSucursalInvalidosException(String mensaje) {
        super(mensaje);
    }
}