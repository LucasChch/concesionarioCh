package ar.com.tallerservice.mapper;

import ar.com.tallerservice.dto.TallerDTO;
import ar.com.tallerservice.model.Taller;

public class TallerMapper {

    public static TallerDTO toDTO(Taller taller) {

        TallerDTO dto = new TallerDTO();
        dto.setId(taller.getId());
        dto.setSucursalId(taller.getSucursalId());
        dto.setAutomotorId(taller.getAutomotorId());
        dto.setClienteId(taller.getClienteId());
        dto.setCosto(taller.getCosto());
        dto.setDescripcion(taller.getDescripcion());
        dto.setHayGarantia(taller.isHayGarantia());
        dto.setFechaRecepcion(taller.getFechaRecepcion());
        dto.setFechaEntrega(taller.getFechaEntrega());
        dto.setKilometros(taller.getKilometros());

        return dto;
    }

    public static Taller toEntity(TallerDTO dto) {

        return new Taller(
                dto.getAutomotorId(),
                dto.getClienteId(),
                dto.getSucursalId(),
                dto.getFechaRecepcion(),
                dto.getFechaEntrega(),
                dto.getKilometros(),
                dto.isHayGarantia(),
                dto.getDescripcion(),
                dto.getCosto()

        );
    }
}
