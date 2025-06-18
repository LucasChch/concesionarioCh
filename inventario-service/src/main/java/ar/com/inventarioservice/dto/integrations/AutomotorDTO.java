package ar.com.inventarioservice.dto.integrations;

import java.math.BigDecimal;

public class AutomotorDTO {

    private Long id;
    private String modelo;
    private String marca;
    private Integer anio;
    private BigDecimal precioBase;
    private Integer aniosGarantia;

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public BigDecimal getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(BigDecimal precioBase) {
        this.precioBase = precioBase;
    }

    public Integer getAniosGarantia() {
        return aniosGarantia;
    }

    public void setAniosGarantia(Integer aniosGarantia) {
        this.aniosGarantia = aniosGarantia;
    }
}
