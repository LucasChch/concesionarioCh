package ar.com.ventasservice.integrations.restClient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("INVENTARIO-SERVICE")
public interface InventarioClient {
}
