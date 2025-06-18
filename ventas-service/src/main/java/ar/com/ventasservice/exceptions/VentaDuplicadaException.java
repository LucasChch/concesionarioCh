package ar.com.ventasservice.exceptions;

public class VentaDuplicadaException extends RuntimeException {
    public VentaDuplicadaException() {
        super(
                "No podes realizar la misma venta."
        );
    }
}
