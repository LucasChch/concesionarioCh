package ar.com.ventasservice.business;

import ar.com.ventasservice.dto.VentaDTO;
import ar.com.ventasservice.exceptions.ClienteNoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface IVentaServicio {

    public VentaDTO realizarVenta(Long automotorId, Long clienteId, Long empleadoId, Long sucursalId);
}
