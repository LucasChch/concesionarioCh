package ar.com.ventasservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNoEncontradoException extends BusinessException {
  public ClienteNoEncontradoException(Long id) {
    super("Cliente con ID " + id + " no encontrado.");;
  }
}
