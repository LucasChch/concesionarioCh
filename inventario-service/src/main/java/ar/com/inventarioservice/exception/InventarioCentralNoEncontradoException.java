package ar.com.inventarioservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class InventarioCentralNoEncontradoException extends RuntimeException {

    public InventarioCentralNoEncontradoException(Long inventarioId) {
        super(
                "Inventario  con ID " + inventarioId + " no encontrado."
        );
    }


    public InventarioCentralNoEncontradoException(Long sucursalId, Long automotorId) {
        super(
                "Inventario para el automotor con ID " + automotorId + " no encontrado."
        );
    }
}
