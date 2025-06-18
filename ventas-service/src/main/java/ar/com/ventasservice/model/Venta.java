package ar.com.ventasservice.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long automotorId;
    private Long clienteId;
    private Long empleadoId;
    private Long sucursalId;

    private BigDecimal monto;
    private LocalDate fechaOperacion;
    private LocalDate fechaEntrega;

    //constructor
    protected Venta() {}

    public Venta(Long automotorId, Long clienteId, Long empleadoId, Long sucursalId,BigDecimal monto, LocalDate fechaOperacion, LocalDate fechaEntrega) {
        setAutomotorId(automotorId);
        setClienteId(clienteId);
        setEmpleadoId(empleadoId);
        setSucursalId(sucursalId);
        setMonto(monto);
        setFechaOperacion(fechaOperacion);
        setFechaEntrega(fechaEntrega);
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

    public Long getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Long empleadoId) {
        this.empleadoId = empleadoId;
    }

    public Long getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Long sucursalId) {
        this.sucursalId = sucursalId;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDate getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(LocalDate fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}