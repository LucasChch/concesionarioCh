package ar.com.ventasservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TipoUsuarioIncorrectoException extends RuntimeException {
    public TipoUsuarioIncorrectoException(Long id) {
        super("El ID " + id + " no corresponde al tipo de usuario correcto.");
    }
}
