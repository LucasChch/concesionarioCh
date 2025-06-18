package ar.com.automotorservice.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Automotor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;
    private String marca;
    private Integer anio;
    private BigDecimal precioBase;
    private Integer aniosGarantia;

    //constructors
    protected Automotor() {}

    public Automotor(String modelo, String marca, Integer anio, BigDecimal precioBase, Integer aniosGarantia) {
        setModelo(modelo);
        setMarca(marca);
        setAnio(anio);
        setPrecioBase(precioBase);
        setAniosGarantia(aniosGarantia);
    }

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
