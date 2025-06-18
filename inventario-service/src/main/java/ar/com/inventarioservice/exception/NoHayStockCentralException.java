package ar.com.inventarioservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoHayStockCentralException extends RuntimeException {
    public NoHayStockCentralException(Long id ) {
        super(
                "No hay stock en el inventario central para el automotor con id:" + id
        );
    }
}
