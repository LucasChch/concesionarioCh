package ar.com.usuarioservice.mapper;

import ar.com.usuarioservice.dto.EmpleadoDTO;
import ar.com.usuarioservice.models.Empleado;

public class EmpleadoMapper {
    public static EmpleadoDTO toDTO(Empleado empelado) {

        EmpleadoDTO dto = new EmpleadoDTO();
        dto.setId(empelado.getId());
        dto.setNombre(empelado.getNombre());
        dto.setEmail(empelado.getEmail());
        dto.setDni(empelado.getDni());
        dto.setSucursalId(empelado.getSucursalId());
        dto.setPuesto(empelado.getPuesto());
        return dto;
    }

    public static Empleado toEntity(EmpleadoDTO dto) {

        return new Empleado(
                dto.getNombre(),
                dto.getEmail(),
                dto.getDni(),
                dto.getPuesto(),
                dto.getSucursalId()
        );
    }
}