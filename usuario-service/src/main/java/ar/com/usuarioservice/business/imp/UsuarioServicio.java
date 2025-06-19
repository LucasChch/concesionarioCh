package ar.com.usuarioservice.business.imp;

import ar.com.usuarioservice.business.IUsuarioServicio;
import ar.com.usuarioservice.dto.ClienteDTO;
import ar.com.usuarioservice.dto.EmpleadoDTO;
import ar.com.usuarioservice.dto.integrations.SucursalDTO;
import ar.com.usuarioservice.exception.*;
import ar.com.usuarioservice.integrations.restClient.ISucursalClient;
import ar.com.usuarioservice.mapper.ClienteMapper;
import ar.com.usuarioservice.mapper.EmpleadoMapper;
import ar.com.usuarioservice.models.Cliente;
import ar.com.usuarioservice.models.Empleado;
import ar.com.usuarioservice.models.Usuario;
import ar.com.usuarioservice.repository.IUsuarioDAO;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio implements IUsuarioServicio {

    @Autowired
    private IUsuarioDAO usuarioDAO;

    @Autowired
    private ISucursalClient sucursalClient;

    //MÉTODOS CLIENTE
    @Override
    public ClienteDTO crearCliente(String nombre, String email, String dni, String direccion, String telefono) {

        if (nombre == null || nombre.isEmpty()) {
            throw new DatosClienteException("El nombre es obligatorio.");
        }
        if (email == null || email.isEmpty()) {
            throw new DatosClienteException("El email es obligatorio.");
        }
        if (dni == null || dni.isEmpty()) {
            throw new DatosClienteException("El dni es obligatorio.");
        }
        if (direccion == null || direccion.isEmpty()) {
            throw new DatosClienteException("El direccion es obligatorio.");
        }
        if (telefono == null || telefono.isEmpty()) {
            throw new DatosClienteException("El telefono es obligatorio.");
        }

        //valido cliente duplicado por email
        Usuario usuarioDuplicado = usuarioDAO.findByEmailAndDni(email, dni);
        if (usuarioDuplicado != null) {
            throw new DatosClienteException("El usuario ya existe");
        }

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
    public EmpleadoDTO crearEmpleado(String nombre, String email, String dni, String puesto, Long sucursalId) {

        if (nombre == null || nombre.isEmpty()) {
            throw new DatosEmpleadoException("El nombre es obligatorio.");
        }
        if (email == null || email.isEmpty()) {
            throw new DatosEmpleadoException("El email es obligatorio.");
        }
        if (dni == null || dni.isEmpty()) {
            throw new DatosEmpleadoException("El dni es obligatorio.");
        }
        if (puesto == null || puesto.isEmpty()) {
            throw new DatosEmpleadoException("El puesto es obligatorio.");
        }
        if (sucursalId == null || sucursalId < 0) {
            throw new DatosEmpleadoException("El sucursalId es obligatorio.");
        }

        //busco por duplicado
        Usuario usuarioDuplicado = usuarioDAO.findByEmailAndDni(email, dni);
        if (usuarioDuplicado != null) {
            throw new DatosEmpleadoException("El usuario ya existe");
        }

        //valido que exista la sucursal a la cual quiero crear el usuaroi
        try {
            SucursalDTO sucursal = sucursalClient.getSucursal(sucursalId);
        } catch (FeignException.NotFound e) {
            throw new SucursalNoEncontradaException(sucursalId);
        }

        Empleado empleado = new Empleado( nombre, email, dni, puesto, sucursalId );
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
