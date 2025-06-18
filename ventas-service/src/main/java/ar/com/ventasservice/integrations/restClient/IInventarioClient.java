package ar.com.ventasservice.integrations.restClient;

import ar.com.ventasservice.dto.integrations.InventarioCentralDTO;
import ar.com.ventasservice.dto.integrations.InventarioLocalDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("INVENTARIO-SERVICE")
public interface IInventarioClient {

    //Inventario LOCAL
    @RequestMapping(method = RequestMethod.GET, value = "/inventario-local/stock")
    public InventarioLocalDTO getInventarioLocalStock(@RequestParam Long sucursalId, @RequestParam Long automotorId);

    @RequestMapping(method = RequestMethod.PUT, value = "/inventario-local/stock")
    public InventarioLocalDTO quitarUnoDelStockLocal(@RequestParam Long sucursalId, @RequestParam Long automotorId);

    //Inventario Central
    @RequestMapping(method = RequestMethod.GET, value = "/inventario-central/stock")
    public InventarioCentralDTO getInventarioCentralStock(@RequestParam Long automotorId);

    @RequestMapping(method = RequestMethod.PUT, value = "/inventario-central/stock")
    public InventarioLocalDTO quitarUnoDelStockCentral(@RequestParam Long automotorId);

}
