package ar.com.tallerservice.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Taller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long automotorId;
    private Long clienteId;
    private Long sucursalId;

    private LocalDate fechaRecepcion;
    private LocalDate fechaEntrega;
    private Integer kilometros;
    private boolean hayGarantia;
    private String descripcion;
    private BigDecimal costo;

    //contructors
    protected Taller() {}

    public Taller(Long automotorId, Long clienteId, Long sucursalId, LocalDate fechaRecepcion, LocalDate fechaEntrega, Integer kilometros, boolean hayGarantia, String descripcion, BigDecimal costo) {
        setAutomotorId(automotorId);
        setClienteId(clienteId);
        setSucursalId(sucursalId);
        setFechaRecepcion(fechaRecepcion);
        setFechaEntrega(fechaEntrega);
        setKilometros(kilometros);
        setHayGarantia(hayGarantia);
        setDescripcion(descripcion);
        setCosto(costo);
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAutomotorId() {
        return automotorId;
    }

    public void setAutomotorId(Long automotorId) {
        this.automotorId = automotorId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Long sucursalId) {
        this.sucursalId = sucursalId;
    }

    public LocalDate getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(LocalDate fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Integer getKilometros() {
        return kilometros;
    }

    public void setKilometros(Integer kilometros) {
        this.kilometros = kilometros;
    }

    public boolean isHayGarantia() {
        return hayGarantia;
    }

    public void setHayGarantia(boolean hayGarantia) {
        this.hayGarantia = hayGarantia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }
}