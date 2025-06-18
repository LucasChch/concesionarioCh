package ar.com.automotorservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class AutomotorNoEncontradoException extends RuntimeException {
    public AutomotorNoEncontradoException(Long id) {
        super(
                "Automotor con ID " + id + " no encontrado."
        );
    }
}
