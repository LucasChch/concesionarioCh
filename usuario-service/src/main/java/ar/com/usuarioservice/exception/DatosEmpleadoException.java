package ar.com.usuarioservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DatosEmpleadoException extends RuntimeException {
    public DatosEmpleadoException(String message) {
        super(message);
    }
}
