package ar.com.usuarioservice.controller;

import ar.com.usuarioservice.business.IUsuarioServicio;
import ar.com.usuarioservice.dto.ClienteDTO;
import ar.com.usuarioservice.dto.EmpleadoDTO;
import ar.com.usuarioservice.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private IUsuarioServicio usuarioService;

    //CLIENTE
    @GetMapping("/cliente/{id}")
    public ClienteDTO getCliente(@PathVariable Long id) {
        return usuarioService.buscarCliente(id);
    }
    @PostMapping("/cliente")
    public ClienteDTO createCliente(@RequestBody ClienteDTO cliente) {

        ClienteDTO clienteCreado = usuarioService.crearCliente(
                cliente.getNombre(),
                cliente.getEmail(),
                cliente.getDni(),
                cliente.getDireccion(),
                cliente.getTelefono()
        );

        return clienteCreado;
    }

    //EMPLEADOS
    @GetMapping("/empleado/{id}")
    public EmpleadoDTO getEmpleado(@PathVariable Long id) {
        return usuarioService.buscarEmpleado(id);
    }
    @PostMapping("/empleado")
    public EmpleadoDTO createEmpleado(@RequestBody EmpleadoDTO empleado) {

        EmpleadoDTO empleadoCreado = usuarioService.crearEmpleado(
                empleado.getNombre(),
                empleado.getEmail(),
                empleado.getDni(),
                empleado.getPuesto(),
                empleado.getSucursalId()
        );

        return empleadoCreado;
    }
}
