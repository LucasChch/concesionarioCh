package ar.com.tallerservice.integrations.resClient;


import ar.com.tallerservice.dto.integrations.ClienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("USUARIO-SERVICE")
public interface IUsuarioClient {

    @RequestMapping(method = RequestMethod.GET, value = "/cliente/{id}")
    public ClienteDTO getCliente(@PathVariable("id") Long id);

}
