package ar.com.ventasservice.mapper;

import ar.com.ventasservice.dto.VentaDTO;
import ar.com.ventasservice.model.Venta;

public class VentaMapper {

    public static VentaDTO toDTO(Venta venta) {

        VentaDTO dto = new VentaDTO();
        dto.setId(venta.getId());
        dto.setAutomotorId(venta.getAutomotorId());
        dto.setClienteId(venta.getClienteId());
        dto.setEmpleadoId(venta.getEmpleadoId());
        dto.setSucursalId(venta.getSucursalId());
        dto.setMonto(venta.getMonto());
        dto.setFechaOperacion(venta.getFechaOperacion());
        dto.setFechaEntrega(venta.getFechaEntrega());

        return dto;
    }

    public static Venta toEntity(VentaDTO dto) {

        return new Venta(
                dto.getAutomotorId(),
                dto.getClienteId(),
                dto.getEmpleadoId(),
                dto.getSucursalId(),
                dto.getMonto(),
                dto.getFechaOperacion(),
                dto.getFechaEntrega()

        );
    }
}
