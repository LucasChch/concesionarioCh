package ar.com.tallerservice.integrations.resClient;

import ar.com.tallerservice.dto.integrations.SucursalDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("SUCURSAL-SERVICE")
public interface ISucursalClient {

    @RequestMapping(method = RequestMethod.GET, value = "/sucursal/{id}")
    public SucursalDTO getSucursal(@PathVariable("id") Long id);


}
