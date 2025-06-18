package ar.com.inventarioservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SucursalInexistenteException extends RuntimeException {
    public SucursalInexistenteException(Long sucursalId) {
        super(
                "No existe ninguna sucursal con id: " + sucursalId
        );
    }
}
