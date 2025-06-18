package ar.com.sucursalservice.business;

import ar.com.sucursalservice.dto.SucursalDTO;

import java.time.LocalDate;

public interface ISucursalServicio {
    public SucursalDTO crearSucursal(String nombre, String direccion, String pais, LocalDate fechaApertura);
    public SucursalDTO buscarSucursal(Long sucursalId);
}
