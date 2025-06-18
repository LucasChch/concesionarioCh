package ar.com.usuarioservice.mapper;

import ar.com.usuarioservice.dto.ClienteDTO;
import ar.com.usuarioservice.models.Cliente;
import ar.com.usuarioservice.models.Usuario;

public class ClienteMapper {
    public static ClienteDTO toDTO(Cliente cliente) {

        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNombre(cliente.getNombre());
        dto.setEmail(cliente.getEmail());
        dto.setDni(cliente.getDni());
        dto.setDireccion(cliente.getDireccion());
        dto.setTelefono(cliente.getTelefono());
        return dto;
    }

    public static Cliente toEntity(ClienteDTO dto) {

        return new Cliente(
                dto.getNombre(),
                dto.getEmail(),
                dto.getDni(),
                dto.getDireccion(),
                dto.getTelefono()
        );
    }
}
