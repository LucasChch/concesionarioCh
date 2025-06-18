package ar.com.usuarioservice.business.imp;

import ar.com.usuarioservice.business.IUsuarioServicio;
import ar.com.usuarioservice.dto.ClienteDTO;
import ar.com.usuarioservice.dto.EmpleadoDTO;
import ar.com.usuarioservice.exception.ClienteNoEncontradoException;
import ar.com.usuarioservice.exception.EmpleadoNoEncontradoException;
import ar.com.usuarioservice.exception.TipoUsuarioIncorrectoException;
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
        Usuario usuario = usuarioDAO.findById(clienteId).orElseThrow(() -> new ClienteNoEncontradoException(clienteId));

        if (!(usuario instanceof Cliente cliente)) {
            throw new TipoUsuarioIncorrectoException(clienteId);
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
        Usuario usuario = usuarioDAO.findById(empleadoId).orElseThrow(() -> new EmpleadoNoEncontradoException(empleadoId));

        if (!(usuario instanceof Empleado empleado)) {
            throw new TipoUsuarioIncorrectoException(empleadoId);
        }

        EmpleadoDTO empleadoDTO = EmpleadoMapper.toDTO(empleado);

        return empleadoDTO;
    }
}
