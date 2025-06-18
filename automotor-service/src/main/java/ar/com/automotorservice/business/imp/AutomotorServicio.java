package ar.com.automotorservice.business.imp;

import ar.com.automotorservice.business.IAutomotorServicio;
import ar.com.automotorservice.dto.AutomotorDTO;
import ar.com.automotorservice.exception.AutomotorNoEncontradoException;
import ar.com.automotorservice.exception.DatosAutomotorInvalidosException;
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

        if(modelo == null || modelo.isBlank()){
            throw new DatosAutomotorInvalidosException("Modelo no puede ser nulo");
        }
        if(marca == null || marca.isBlank()){
            throw new DatosAutomotorInvalidosException("Marca no puede ser nulo");
        }
        if(anio == null || anio <= 0){
            throw new DatosAutomotorInvalidosException("Anio no puede ser nulo");
        }
        if(precioBase == null || precioBase.compareTo(BigDecimal.ZERO) == 0){
            throw new DatosAutomotorInvalidosException("Precio no puede ser 0 o nulo");
        }
        if(aniosGarantia == null || aniosGarantia <= 0){
            throw new DatosAutomotorInvalidosException("Anio no puede ser 0 o nulo");
        }

        //valido por duplicado
        Automotor automotorDuplicado = automotorDAO.findAutomotorsByMarcaAndModeloAndAnio(marca, modelo, anio);
        if(automotorDuplicado != null){
            throw  new DatosAutomotorInvalidosException("Automotor ya existe");
        }


        Automotor automotor = new Automotor(modelo, marca, anio, precioBase, aniosGarantia);
        automotorDAO.save(automotor);

        AutomotorDTO automotorDTO = AutomotorMapper.toDTO(automotor);

        return automotorDTO;
    }

    @Override
    public AutomotorDTO buscarAutomotor(Long automotorId) {
        Automotor automotor = automotorDAO.findById(automotorId).orElseThrow(() -> new AutomotorNoEncontradoException(automotorId));

        AutomotorDTO automotorDTO = AutomotorMapper.toDTO(automotor);

        return automotorDTO;
    }

}
