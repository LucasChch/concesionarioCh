package ar.com.ventasservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoHayStockException extends RuntimeException {
    public NoHayStockException(Long id ) {
        super(
                "No hay stock en el inventario local ni en el central para el automotor con id:" + id
        );
    }
}
