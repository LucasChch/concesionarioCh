package ar.com.tallerservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SucursalNoEncontradaException extends RuntimeException {
    public SucursalNoEncontradaException(Long id) {
        super(
                "Sucursal con ID " + id + " no encontrada."
        );
    }
}
