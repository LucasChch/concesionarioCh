package ar.com.inventarioservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AutomotorInexistenteException extends RuntimeException {
    public AutomotorInexistenteException(Long automotorId) {
        super(
                "No existe ningun automotor con id: " + automotorId
        );
    }
}
