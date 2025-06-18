package ar.com.tallerservice.integrations.resClient;

import ar.com.tallerservice.dto.integrations.AutomotorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("AUTOMOTOR-SERVICE")
public interface IAutomotorClient {

    @RequestMapping(method = RequestMethod.GET, value = "/automotor/{id}")
    public AutomotorDTO getAutomotor(@PathVariable("id") Long id);

}
