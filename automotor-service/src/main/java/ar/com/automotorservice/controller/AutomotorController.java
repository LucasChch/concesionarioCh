package ar.com.automotorservice.controller;

import ar.com.automotorservice.business.IAutomotorServicio;
import ar.com.automotorservice.dto.AutomotorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/automotor")
public class AutomotorController {

    @Autowired
    private IAutomotorServicio automotorServicio;


    @GetMapping("/{id}")
    public AutomotorDTO getAutomotor(@PathVariable Long id) {
        return automotorServicio.buscarAutomotor(id);
    }

    @PostMapping()
    public AutomotorDTO insertAutomotor(@RequestBody AutomotorDTO automotor) {
        AutomotorDTO automotorCreado = automotorServicio.crearAutomotor(
                automotor.getModelo(),
                automotor.getModelo(),
                automotor.getAnio(),
                automotor.getPrecioBase(),
                automotor.getAniosGarantia()
        );

        return automotorCreado;
    }
}
