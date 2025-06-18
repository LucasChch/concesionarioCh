package ar.com.inventarioservice.business;

import ar.com.inventarioservice.dto.InventarioLocalDTO;

public interface IInventarioLocalServicio {

    public InventarioLocalDTO crearInventarioLocal(Long sucursalId, Long automotorId, int cantidad, int tiempoEntrega );
    public InventarioLocalDTO buscarInventarioLocalPorId(Long id);
}
