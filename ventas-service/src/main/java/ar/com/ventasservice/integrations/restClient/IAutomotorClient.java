package ar.com.ventasservice.integrations.restClient;

import ar.com.ventasservice.dto.integrations.AutomotorDTO;
import ar.com.ventasservice.dto.integrations.ClienteDTO;
import ar.com.ventasservice.dto.integrations.EmpleadoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("AUTOMOTOR-SERVICE")
public interface IAutomotorClient {

    @RequestMapping(method = RequestMethod.GET, value = "/automotor/{id}")
    public AutomotorDTO getAutomotor(@PathVariable("id") Long id);

}
