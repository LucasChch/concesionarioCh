package ar.com.ventasservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InventarioCentralNoEncontradoException extends RuntimeException {
    public InventarioCentralNoEncontradoException(Long automotorId) {
        super(
                "Inventario para el automotor con ID " + automotorId + " no encontrado."
        );
    }
}
