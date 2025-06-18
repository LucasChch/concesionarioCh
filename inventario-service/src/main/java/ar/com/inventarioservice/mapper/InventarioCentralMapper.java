package ar.com.inventarioservice.mapper;

import ar.com.inventarioservice.dto.InventarioCentralDTO;
import ar.com.inventarioservice.model.InventarioCentral;

public class InventarioCentralMapper {
    public static InventarioCentralDTO toDTO(InventarioCentral inventarioCentral) {

        InventarioCentralDTO dto = new InventarioCentralDTO();
        dto.setId(inventarioCentral.getId());
        dto.setAutomotorId(inventarioCentral.getAutomotorId());
        dto.setCantidad(inventarioCentral.getCantidad());
        dto.setTiempoEntrega(inventarioCentral.getTiempoEntrega());
        return dto;
    }

    public static InventarioCentral toEntity(InventarioCentralDTO dto) {

        return new InventarioCentral(
                dto.getAutomotorId(),
                dto.getCantidad(),
                dto.getTiempoEntrega()

        );
    }
}
