package ar.com.automotorservice.mapper;

import ar.com.automotorservice.dto.AutomotorDTO;
import ar.com.automotorservice.model.Automotor;

public class AutomotorMapper {

    public static AutomotorDTO toDTO(Automotor automotor) {

        AutomotorDTO dto = new AutomotorDTO();
        dto.setId(automotor.getId());
        dto.setModelo(automotor.getModelo());
        dto.setMarca(automotor.getMarca());
        dto.setAnio(automotor.getAnio());
        dto.setPrecioBase(automotor.getPrecioBase());
        dto.setAniosGarantia(automotor.getAniosGarantia());

        return dto;
    }

    public static Automotor toEntity(AutomotorDTO dto) {

        return new Automotor(
                dto.getModelo(),
                dto.getMarca(),
                dto.getAnio(),
                dto.getPrecioBase(),
                dto.getAniosGarantia()
        );
    }
}
