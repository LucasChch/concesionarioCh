package ar.com.inventarioservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class InventarioLocalNoEncontradoException extends RuntimeException {

    public InventarioLocalNoEncontradoException(Long inventarioId) {
        super(
                "Inventario  con ID " + inventarioId + " no encontrado."
        );
    }


    public InventarioLocalNoEncontradoException(Long sucursalId, Long automotorId) {
        super(
                "Inventario para la sucursal con ID " + sucursalId + " y automotor ID " + automotorId + " no encontrado."
        );
    }
}
