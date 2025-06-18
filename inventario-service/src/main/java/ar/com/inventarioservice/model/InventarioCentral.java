package ar.com.inventarioservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class InventarioCentral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long automotorId;
    private int cantidad;
    private int tiempoEntrega;


    //constructors
    protected InventarioCentral() {}

    public InventarioCentral(Long automotorId, int cantidad, int tiempoEntrega) {
        setAutomotorId(automotorId);
        setCantidad(cantidad);
        setTiempoEntrega(tiempoEntrega);
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTiempoEntrega() {
        return tiempoEntrega;
    }

    public void setTiempoEntrega(int tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }
}
