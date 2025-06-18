package ar.com.inventarioservice.business.imp;

import ar.com.inventarioservice.business.IInventarioLocalServicio;
import ar.com.inventarioservice.dto.InventarioLocalDTO;
import ar.com.inventarioservice.mapper.InventarioLocalMapper;
import ar.com.inventarioservice.model.InventarioLocal;
import ar.com.inventarioservice.repository.IInventarioLocalDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class InventarioLocalServicio implements IInventarioLocalServicio {

   @Autowired
   IInventarioLocalDAO inventarioLocalDAO;

    @Override
    public InventarioLocalDTO crearInventarioLocal(Long sucursalId, Long automotorId, int cantidad, int tiempoEntrega) {
        InventarioLocal inventarioLocal = new InventarioLocal(sucursalId, automotorId, cantidad, tiempoEntrega);
        inventarioLocalDAO.save(inventarioLocal);

        InventarioLocalDTO inventarioLocalDTO = InventarioLocalMapper.toDTO(inventarioLocal);

        return inventarioLocalDTO;

    }

    @Override
    public InventarioLocalDTO buscarInventarioLocalPorId(Long id) {
        InventarioLocal inventarioLocal = inventarioLocalDAO.findById(id).orElseThrow();

        InventarioLocalDTO inventarioLocalDTO = InventarioLocalMapper.toDTO(inventarioLocal);

        return inventarioLocalDTO;
    }
}

