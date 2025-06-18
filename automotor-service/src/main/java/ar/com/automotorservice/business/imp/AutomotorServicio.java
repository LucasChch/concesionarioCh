package ar.com.automotorservice.business.imp;

import ar.com.automotorservice.business.IAutomotorServicio;
import ar.com.automotorservice.dto.AutomotorDTO;
import ar.com.automotorservice.mapper.AutomotorMapper;
import ar.com.automotorservice.model.Automotor;
import ar.com.automotorservice.repository.IAutomotorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AutomotorServicio implements IAutomotorServicio {

    @Autowired
    IAutomotorDAO automotorDAO;

    @Override
    public AutomotorDTO crearAutomotor(String modelo, String marca, Integer anio, BigDecimal precioBase, Integer aniosGarantia) {
        Automotor automotor = new Automotor(modelo, marca, anio, precioBase, aniosGarantia);
        automotorDAO.save(automotor);

        AutomotorDTO automotorDTO = AutomotorMapper.toDTO(automotor);

        return automotorDTO;
    }

    @Override
    public AutomotorDTO buscarAutomotor(Long automotorId) {
        Automotor automotor = automotorDAO.findById(automotorId).orElseThrow();

        AutomotorDTO automotorDTO = AutomotorMapper.toDTO(automotor);

        return automotorDTO;
    }

}
