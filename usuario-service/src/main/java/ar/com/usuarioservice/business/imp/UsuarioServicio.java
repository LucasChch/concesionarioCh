package ar.com.usuarioservice.business.imp;

import ar.com.usuarioservice.business.IUsuarioServicio;
import ar.com.usuarioservice.dto.ClienteDTO;
import ar.com.usuarioservice.dto.EmpleadoDTO;
import ar.com.usuarioservice.mapper.ClienteMapper;
import ar.com.usuarioservice.mapper.EmpleadoMapper;
import ar.com.usuarioservice.models.Cliente;
import ar.com.usuarioservice.models.Empleado;
import ar.com.usuarioservice.models.Usuario;
import ar.com.usuarioservice.repository.IUsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio implements IUsuarioServicio {

    @Autowired
    private IUsuarioDAO usuarioDAO;

    //MÉTODOS CLIENTE
    @Override
    public ClienteDTO crearCliente(String nombre, String email, String dni, String direccion, String telefono) {

        Cliente cliente = new Cliente( nombre, email, dni, direccion, telefono );
        usuarioDAO.save(cliente);

        ClienteDTO clienteDTO = ClienteMapper.toDTO(cliente);

        return clienteDTO;
    }

    @Override
    public ClienteDTO buscarCliente(Long clienteId) {
        Usuario usuario = usuarioDAO.findById(clienteId).orElseThrow();

        if (!(usuario instanceof Cliente cliente)) {
            throw new RuntimeException("El ID no corresponde a un cliente");
        }

        ClienteDTO clienteDTO = ClienteMapper.toDTO(cliente);

        return clienteDTO;
    }

    //MÉTODOS EMPLEADO
    @Override
    public EmpleadoDTO crearEmpleado(String nombre, String email, String dni, String puesto, Long concessionId) {
        Empleado empleado = new Empleado( nombre, email, dni, puesto, concessionId );
        usuarioDAO.save(empleado);

        EmpleadoDTO empleadoDTO = EmpleadoMapper.toDTO(empleado);

        return empleadoDTO;
    }

    @Override
    public EmpleadoDTO buscarEmpleado(Long empleadoId) {
        Usuario usuario = usuarioDAO.findById(empleadoId).orElseThrow();

        if (!(usuario instanceof Empleado empleado)) {
            throw new RuntimeException("El ID no corresponde a un empleado");
        }

        EmpleadoDTO empleadoDTO = EmpleadoMapper.toDTO(empleado);

        return empleadoDTO;
    }
}
