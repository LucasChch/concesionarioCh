package ar.com.usuarioservice.business;

import ar.com.usuarioservice.dto.ClienteDTO;
import ar.com.usuarioservice.dto.EmpleadoDTO;

public interface IUsuarioServicio {

    public ClienteDTO crearCliente(String nombre, String email, String dni, String direccion, String telefono);
    public ClienteDTO buscarCliente(Long clienteId);

    public EmpleadoDTO crearEmpleado(String nombre, String email, String dni, String puesto, Long sucursalId);
    public EmpleadoDTO buscarEmpleado(Long clienteId);
}
