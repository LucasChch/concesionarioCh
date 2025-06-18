package ar.com.tallerservice.controller;

import ar.com.tallerservice.business.ITallerServicio;
import ar.com.tallerservice.dto.TallerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/taller")
public class TallerController {

    @Autowired
    private ITallerServicio tallerServicio;

    @GetMapping("/{id}")
    public TallerDTO getTaller(@PathVariable Long id) {
        return tallerServicio.buscarTaller(id);
    }
    @PostMapping()
    public TallerDTO createTaller(@RequestBody TallerDTO taller) {

        TallerDTO tallerCreado = tallerServicio.crearTaller(
                taller.getAutomotorId(),
                taller.getClienteId(),
                taller.getSucursalId(),
                taller.getFechaRecepcion(),
                taller.getFechaEntrega(),
                taller.getKilometros(),
                taller.isHayGarantia(),
                taller.getDescripcion(),
                taller.getCosto()
        );

        return tallerCreado;
    }
}
