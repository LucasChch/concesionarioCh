package ar.com.inventarioservice.business;

import ar.com.inventarioservice.dto.InventarioCentralDTO;
import ar.com.inventarioservice.dto.InventarioLocalDTO;

import java.time.LocalDate;

public interface IInventarioCentralServicio {

    public InventarioCentralDTO crearInventarioCentral(Long automotorId, int cantidad, int tiempoEntrega);
    public InventarioCentralDTO buscarInventarioCentralPorId(Long id);

    public InventarioCentralDTO buscarStockEnInvetarioCentral(Long automotorId);

    public void quitarUnoDelStock(Long automotorId);

}