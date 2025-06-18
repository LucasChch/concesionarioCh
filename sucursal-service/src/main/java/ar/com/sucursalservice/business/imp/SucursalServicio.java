package ar.com.sucursalservice.business.imp;

import ar.com.sucursalservice.business.ISucursalServicio;
import ar.com.sucursalservice.dto.SucursalDTO;
import ar.com.sucursalservice.exception.SucursalNoEncontradaException;
import ar.com.sucursalservice.mapper.SucursalMapper;
import ar.com.sucursalservice.models.Sucursal;
import ar.com.sucursalservice.repository.ISucursalDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SucursalServicio implements ISucursalServicio {

    @Autowired
    ISucursalDAO sucursalDAO;

    @Override
    public SucursalDTO crearSucursal(String nombre, String direccion, String pais, LocalDate fechaApertura) {
        Sucursal sucursal = new Sucursal(nombre, direccion, pais, fechaApertura);
        sucursalDAO.save(sucursal);

        SucursalDTO sucursalDTO = SucursalMapper.toDTO(sucursal);

        return sucursalDTO;
    }

    @Override
    public SucursalDTO buscarSucursal(Long sucursalId) {
        Sucursal sucursal = sucursalDAO.findById(sucursalId).orElseThrow(() -> new SucursalNoEncontradaException(sucursalId));

        SucursalDTO sucursalDTO = SucursalMapper.toDTO(sucursal);

        return sucursalDTO;
    }

}
