package ar.com.inventarioservice.business.imp;

import ar.com.inventarioservice.business.IInventarioLocalServicio;
import ar.com.inventarioservice.dto.InventarioLocalDTO;
import ar.com.inventarioservice.dto.integrations.AutomotorDTO;
import ar.com.inventarioservice.dto.integrations.SucursalDTO;
import ar.com.inventarioservice.exception.*;
import ar.com.inventarioservice.integrations.restClient.IAutomotorClient;
import ar.com.inventarioservice.integrations.restClient.ISucursalClient;
import ar.com.inventarioservice.mapper.InventarioLocalMapper;
import ar.com.inventarioservice.model.InventarioCentral;
import ar.com.inventarioservice.model.InventarioLocal;
import ar.com.inventarioservice.repository.IInventarioLocalDAO;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class InventarioLocalServicio implements IInventarioLocalServicio {

    @Autowired
    IInventarioLocalDAO inventarioLocalDAO;

    @Autowired
    IAutomotorClient automotorClient;

    @Autowired
    ISucursalClient sucursalClient;

    @Override
    public InventarioLocalDTO crearInventarioLocal(Long sucursalId, Long automotorId, int cantidad, int tiempoEntrega) {

        //antes de crear verifico que el id del automotor exista
        try {
            AutomotorDTO automotorDTO = automotorClient.getAutomotor(automotorId);
        } catch (FeignException.NotFound e) {
            throw new AutomotorInexistenteException(automotorId);
        }

        //tambien verifico que exista la sucursal
        try {
            SucursalDTO sucursalDTO = sucursalClient.getSucursal(sucursalId);
        } catch (FeignException.NotFound e) {
            throw new SucursalInexistenteException(sucursalId);
        }

        InventarioLocal inventarioLocal = new InventarioLocal(sucursalId, automotorId, cantidad, tiempoEntrega);
        inventarioLocalDAO.save(inventarioLocal);

        InventarioLocalDTO inventarioLocalDTO = InventarioLocalMapper.toDTO(inventarioLocal);

        return inventarioLocalDTO;

    }

    @Override
    public InventarioLocalDTO buscarInventarioLocalPorId(Long id) {
        InventarioLocal inventarioLocal = inventarioLocalDAO.findById(id).orElseThrow(() -> new InventarioLocalNoEncontradoException(id));

        InventarioLocalDTO inventarioLocalDTO = InventarioLocalMapper.toDTO(inventarioLocal);

        return inventarioLocalDTO;
    }

    @Override
    public InventarioLocalDTO buscarStockEnInvetarioLocal(Long sucursalId, Long automotorId) {
        InventarioLocal inventarioLocal = inventarioLocalDAO.findBySucursalIdAndAutomotorId(sucursalId, automotorId);

        if(inventarioLocal == null) {
            throw new InventarioLocalNoEncontradoException(sucursalId, automotorId);
        }

        InventarioLocalDTO inventarioLocalDTO = InventarioLocalMapper.toDTO(inventarioLocal);

        return inventarioLocalDTO;

    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public void quitarUnoDelStock(Long sucursalId, Long automotorId) {
        InventarioLocal inventarioCentral = inventarioLocalDAO.findBySucursalIdAndAutomotorId(sucursalId, automotorId);

        if(inventarioCentral == null) {
            throw new InventarioLocalNoEncontradoException(automotorId);
        }

        if (inventarioCentral.getCantidad() <= 0) {
            throw new NoHayStockCentralException(automotorId);
        }

        inventarioCentral.setCantidad(inventarioCentral.getCantidad() - 1);
        inventarioLocalDAO.save(inventarioCentral);
    }
}

