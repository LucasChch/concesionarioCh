package ar.com.inventarioservice.business;

import ar.com.inventarioservice.dto.InventarioCentralDTO;

import java.time.LocalDate;

public interface IInventarioCentralServicio {

    public InventarioCentralDTO crearInventarioCentral(Long automotorId, int cantidad, int tiempoEntrega);
    public InventarioCentralDTO buscarInventarioCentralPorId(Long id);
}