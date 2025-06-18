package ar.com.tallerservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class KilometrosException extends RuntimeException {
    public KilometrosException() {
        super("Los kilómentros son obligatorios y deben ser mayor que 0");
    }
}
