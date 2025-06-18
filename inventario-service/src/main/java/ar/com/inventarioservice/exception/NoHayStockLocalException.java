package ar.com.inventarioservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoHayStockLocalException extends RuntimeException {
    public NoHayStockLocalException(Long sucursalId, Long automotorId) {
        super(
                "No hay stock en el inventario local con Id" + sucursalId+ " para el automotor con id:" + automotorId
        );
    }
}
