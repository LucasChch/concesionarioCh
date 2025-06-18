package ar.com.inventarioservice.controller;

import ar.com.inventarioservice.business.IInventarioLocalServicio;
import ar.com.inventarioservice.dto.InventarioLocalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("inventario-local")
public class InventarioLocalController {
    @Autowired
    private IInventarioLocalServicio inventarioLocalServicio;

    @GetMapping("/{id}")
    public InventarioLocalDTO getInventarioLocal(@PathVariable Long id) {
        return inventarioLocalServicio.buscarInventarioLocalPorId(id);
    }
    @PostMapping()
    public InventarioLocalDTO createInventarioLocal(@RequestBody InventarioLocalDTO inventarioLocal) {

        InventarioLocalDTO inventarioLocalCreado = inventarioLocalServicio.crearInventarioLocal(
                inventarioLocal.getSucursalId(),
                inventarioLocal.getAutomotorId(),
                inventarioLocal.getCantidad(),
                inventarioLocal.getTiempoEntrega()
        );

        return inventarioLocalCreado;
    }
}
