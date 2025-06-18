package ar.com.inventarioservice.mapper;

import ar.com.inventarioservice.dto.InventarioLocalDTO;
import ar.com.inventarioservice.model.InventarioLocal;

public class InventarioLocalMapper {

    public static InventarioLocalDTO toDTO(InventarioLocal inventarioLocal) {

        InventarioLocalDTO dto = new InventarioLocalDTO();
        dto.setId(inventarioLocal.getId());
        dto.setSucursalId(inventarioLocal.getSucursalId());
        dto.setAutomotorId(inventarioLocal.getAutomotorId());
        dto.setCantidad(inventarioLocal.getCantidad());
        dto.setTiempoEntrega(inventarioLocal.getTiempoEntrega());
        return dto;
    }

    public static InventarioLocal toEntity(InventarioLocalDTO dto) {

        return new InventarioLocal(
                dto.getSucursalId(),
                dto.getAutomotorId(),
                dto.getCantidad(),
                dto.getTiempoEntrega()

        );
    }
}
