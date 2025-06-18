package ar.com.tallerservice.exceptions;

public class TallerDuplicadoException extends RuntimeException {
    public TallerDuplicadoException() {
        super(
                "La reserva para el taller ya fue realizada con anterioridad."
        );
    }
}
