package ar.com.inventarioservice.dto;

public class InventarioLocalDTO {

    private Long id;
    private Long sucursalId;
    private Long automotorId;
    private int cantidad;
    private int tiempoEntrega;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Long sucursalId) {
        this.sucursalId = sucursalId;
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
