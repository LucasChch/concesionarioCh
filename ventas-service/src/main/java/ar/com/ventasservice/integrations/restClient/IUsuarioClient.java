package ar.com.ventasservice.integrations.restClient;

import ar.com.ventasservice.dto.integrations.ClienteDTO;
import ar.com.ventasservice.dto.integrations.EmpleadoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("USUARIO-SERVICE")
public interface IUsuarioClient {

    @RequestMapping(method = RequestMethod.GET, value = "/cliente/{id}")
    public ClienteDTO getCliente(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/empleado/{id}")
    public EmpleadoDTO getEmpleado(@PathVariable("id") Long id);
}
