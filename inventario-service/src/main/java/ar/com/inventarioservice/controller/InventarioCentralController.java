package ar.com.inventarioservice.controller;

import ar.com.inventarioservice.business.IInventarioCentralServicio;
import ar.com.inventarioservice.dto.InventarioCentralDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("inventario-central")
public class InventarioCentralController {
    @Autowired
    private IInventarioCentralServicio inventarioCentralServicio;

    @GetMapping("/{id}")
    public InventarioCentralDTO getInventarioCentral(@PathVariable Long id) {
        return inventarioCentralServicio.buscarInventarioCentralPorId(id);
    }

    @GetMapping("/stock")
    public InventarioCentralDTO buscarStockEnInvetarioCentral(@RequestParam Long automotorId){
        return inventarioCentralServicio.buscarStockEnInvetarioCentral(automotorId);
    }

    @PostMapping()
    public InventarioCentralDTO createInventarioCentral(@RequestBody InventarioCentralDTO inventarioCentral) {

        InventarioCentralDTO inventarioCentralCreado = inventarioCentralServicio.crearInventarioCentral(
                inventarioCentral.getAutomotorId(),
                inventarioCentral.getCantidad(),
                inventarioCentral.getTiempoEntrega()
        );

        return inventarioCentralCreado;
    }

    @PutMapping("/stock")
    public void removeOneFromInventarioCentralStock(@RequestParam Long automotorId) {
        inventarioCentralServicio.quitarUnoDelStock(automotorId);
    }

}
