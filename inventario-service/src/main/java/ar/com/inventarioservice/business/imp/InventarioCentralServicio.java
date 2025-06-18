package ar.com.inventarioservice.business.imp;

import ar.com.inventarioservice.business.IInventarioCentralServicio;
import ar.com.inventarioservice.dto.InventarioCentralDTO;
import ar.com.inventarioservice.mapper.InventarioCentralMapper;
import ar.com.inventarioservice.model.InventarioCentral;
import ar.com.inventarioservice.repository.IInventarioCentralDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventarioCentralServicio implements IInventarioCentralServicio {

    @Autowired
    IInventarioCentralDAO inventarioCentralDAO;

    @Override
    public InventarioCentralDTO crearInventarioCentral(Long automotorId, int cantidad, int tiempoEntrega) {
        InventarioCentral inventarioCentral = new InventarioCentral(automotorId, cantidad, tiempoEntrega);
        inventarioCentralDAO.save(inventarioCentral);

        InventarioCentralDTO inventarioCentralDTO = InventarioCentralMapper.toDTO(inventarioCentral);

        return inventarioCentralDTO;

    }

    @Override
    public InventarioCentralDTO buscarInventarioCentralPorId(Long id) {
        InventarioCentral inventarioCentral = inventarioCentralDAO.findById(id).orElseThrow();

        InventarioCentralDTO inventarioCentralDTO = InventarioCentralMapper.toDTO(inventarioCentral);

        return inventarioCentralDTO;
    }
}
