package ar.com.sucursalservice.controllers;

import ar.com.sucursalservice.business.ISucursalServicio;
import ar.com.sucursalservice.dto.SucursalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SucursalesController {

    @Autowired
    private ISucursalServicio sucursalServicio;

    @GetMapping("/sucursal/{id}")
    public SucursalDTO getSucursal(@PathVariable Long id) {
        return sucursalServicio.buscarSucursal(id);
    }
    @PostMapping("/sucursal")
    public SucursalDTO createSucursal(@RequestBody SucursalDTO sucursal) {

        SucursalDTO sucursalCreada = sucursalServicio.crearSucursal(
                sucursal.getNombre(),
                sucursal.getDireccion(),
                sucursal.getPais(),
                sucursal.getFechaApertura()
        );

        return sucursalCreada;
    }
}
