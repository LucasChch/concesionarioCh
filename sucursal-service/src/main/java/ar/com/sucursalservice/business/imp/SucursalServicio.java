package ar.com.sucursalservice.business.imp;

import ar.com.sucursalservice.business.ISucursalServicio;
import ar.com.sucursalservice.dto.SucursalDTO;
import ar.com.sucursalservice.exception.DatosSucursalInvalidosException;
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

        //validaciones
        if (nombre == null || nombre.isBlank()) {
            throw new DatosSucursalInvalidosException("El nombre de la sucursal es obligatorio.");
        }

        if (direccion == null || direccion.isBlank()) {
            throw new DatosSucursalInvalidosException("La dirección de la sucursal es obligatoria.");
        }

        if (pais == null || pais.isBlank()) {
            throw new DatosSucursalInvalidosException("El país es obligatorio.");
        }

        if (fechaApertura == null || fechaApertura.isAfter(LocalDate.now())) {
            throw new DatosSucursalInvalidosException("La fecha de apertura no puede ser nula ni futura.");
        }

        //vertifico que no exista otra sucursal en la misma direccion y el mismo pais
        Sucursal sucursalDuplicado = sucursalDAO.getSucursalByDireccionAndPais(direccion, pais);

        if (sucursalDuplicado != null) {
            throw  new DatosSucursalInvalidosException("La sucursal ya existe en esa direccion y pais.");
        }

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
