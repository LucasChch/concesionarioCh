package ar.com.ventasservice.controllers;

import ar.com.ventasservice.business.IVentaServicio;
import ar.com.ventasservice.dto.VentaDTO;
import ar.com.ventasservice.exceptions.ClienteNoEncontradoException;
import ar.com.ventasservice.integrations.restClient.IUsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("venta")
public class VentaController {

    @Autowired
    IVentaServicio ventaServicio;

    @GetMapping("/ping")
    public String testEndpoint(){
        return "pong";
    }

    @PostMapping()
    public VentaDTO createVenta(@RequestBody VentaDTO ventaDTO) {
        return ventaServicio.realizarVenta(
                ventaDTO.getAutomotorId(),
                ventaDTO.getClienteId(),
                ventaDTO.getEmpleadoId(),
                ventaDTO.getSucursalId()
        );
    }
}