package ar.com.inventarioservice.business.imp;

import ar.com.inventarioservice.business.IInventarioCentralServicio;
import ar.com.inventarioservice.dto.InventarioCentralDTO;
import ar.com.inventarioservice.dto.integrations.AutomotorDTO;
import ar.com.inventarioservice.exception.AutomotorInexistenteException;
import ar.com.inventarioservice.exception.InventarioCentralNoEncontradoException;
import ar.com.inventarioservice.exception.NoHayStockCentralException;
import ar.com.inventarioservice.integrations.restClient.IAutomotorClient;
import ar.com.inventarioservice.mapper.InventarioCentralMapper;
import ar.com.inventarioservice.model.InventarioCentral;
import ar.com.inventarioservice.repository.IInventarioCentralDAO;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventarioCentralServicio implements IInventarioCentralServicio {

    @Autowired
    IInventarioCentralDAO inventarioCentralDAO;

    @Autowired
    IAutomotorClient automotorClient;


    @Override
    public InventarioCentralDTO crearInventarioCentral(Long automotorId, int cantidad, int tiempoEntrega) {

        //antes de crear verifico que el id del automotor exista
        try {
            AutomotorDTO automotorDTO = automotorClient.getAutomotor(automotorId);
        } catch (FeignException.NotFound e) {
            throw new AutomotorInexistenteException(automotorId);
        }

        InventarioCentral inventarioCentral = new InventarioCentral(automotorId, cantidad, tiempoEntrega);
        inventarioCentralDAO.save(inventarioCentral);

        InventarioCentralDTO inventarioCentralDTO = InventarioCentralMapper.toDTO(inventarioCentral);

        return inventarioCentralDTO;

    }

    @Override
    public InventarioCentralDTO buscarInventarioCentralPorId(Long id) {
        InventarioCentral inventarioCentral = inventarioCentralDAO.findById(id).orElseThrow(() -> new InventarioCentralNoEncontradoException(id));

        InventarioCentralDTO inventarioCentralDTO = InventarioCentralMapper.toDTO(inventarioCentral);

        return inventarioCentralDTO;
    }

    @Override
    public InventarioCentralDTO buscarStockEnInvetarioCentral(Long automotorId) {
        InventarioCentral inventarioCentral = inventarioCentralDAO.findByAutomotorId(automotorId);

        if(inventarioCentral == null) {
            throw new InventarioCentralNoEncontradoException(automotorId);
        }

        InventarioCentralDTO inventarioCentralDTO = InventarioCentralMapper.toDTO(inventarioCentral);

        return inventarioCentralDTO;

    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public void quitarUnoDelStock(Long automotorId) {
        InventarioCentral inventarioCentral = inventarioCentralDAO.findByAutomotorId(automotorId);

        if(inventarioCentral == null) {
            throw new InventarioCentralNoEncontradoException(automotorId);
        }

        if (inventarioCentral.getCantidad() <= 0) {
            throw new NoHayStockCentralException(automotorId);
        }

        inventarioCentral.setCantidad(inventarioCentral.getCantidad() - 1);
        inventarioCentralDAO.save(inventarioCentral);
    }
}
