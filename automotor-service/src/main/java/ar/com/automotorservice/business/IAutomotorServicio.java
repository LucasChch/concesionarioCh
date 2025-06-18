package ar.com.automotorservice.business;

import ar.com.automotorservice.dto.AutomotorDTO;

import java.math.BigDecimal;

public interface IAutomotorServicio {

    public AutomotorDTO crearAutomotor(String modelo, String marca, Integer anio, BigDecimal precioBase, Integer aniosGarantia);
    public AutomotorDTO buscarAutomotor(Long automotorId);

}
