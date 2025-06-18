package ar.com.sucursalservice.mapper;

import ar.com.sucursalservice.dto.SucursalDTO;
import ar.com.sucursalservice.models.Sucursal;

public class SucursalMapper {

    public static SucursalDTO toDTO(Sucursal sucursal) {

        SucursalDTO dto = new SucursalDTO();
        dto.setId(sucursal.getId());
        dto.setNombre(sucursal.getNombre());
        dto.setDireccion(sucursal.getDireccion());
        dto.setPais(sucursal.getPais());
        dto.setFechaApertura(sucursal.getFechaApertura());
        return dto;
    }

    public static Sucursal toEntity(SucursalDTO dto) {

        return new Sucursal(
                dto.getNombre(),
                dto.getDireccion(),
                dto.getPais(),
                dto.getFechaApertura()
        );
    }
}
