package ar.com.ventasservice.business.imp;

import ar.com.ventasservice.business.IVentaServicio;
import ar.com.ventasservice.dto.VentaDTO;
import ar.com.ventasservice.dto.integrations.*;
import ar.com.ventasservice.exceptions.*;
import ar.com.ventasservice.integrations.restClient.IAutomotorClient;
import ar.com.ventasservice.integrations.restClient.IInventarioClient;
import ar.com.ventasservice.integrations.restClient.ISucursalClient;
import ar.com.ventasservice.integrations.restClient.IUsuarioClient;
import ar.com.ventasservice.mapper.VentaMapper;
import ar.com.ventasservice.model.Venta;
import ar.com.ventasservice.repository.IVentaDAO;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class VentaServicio implements IVentaServicio {

    @Autowired
    IVentaDAO ventaDAO;

    @Autowired
    IUsuarioClient usuarioClient;

    @Autowired
    IAutomotorClient automotorClient;

    @Autowired
    ISucursalClient sucursalClient;

    @Autowired
    IInventarioClient inventarioClient;

    @Override
    public VentaDTO realizarVenta(Long automotorId, Long clienteId, Long empleadoId, Long sucursalId ) {

        //inicializo variables
        ClienteDTO cliente;
        EmpleadoDTO empleado;
        AutomotorDTO automotor;
        SucursalDTO sucursal;
        InventarioLocalDTO inventarioLocal;
        InventarioCentralDTO inventarioCentral;

        LocalDate fechaOperacion = LocalDate.now();
        LocalDate fechaEntrega;
        BigDecimal monto;

        //obligatorios
        if (automotorId == null) {
            throw new DatosVentaException("El automotor es obligatorio.");
        }
        if (clienteId == null) {
            throw new DatosVentaException("El cliente es obligatorio.");
        }
        if (sucursalId == null) {
            throw new DatosVentaException("La sucursal es obligatorio.");
        }
        if (empleadoId == null) {
            throw new DatosVentaException("El empleado es obligatorio.");
        }

        //validacion de venta duplicada
        //findByClienteIdAndAutomotorIdAndSucursalId

        Venta tallerDuplicado = ventaDAO.findByClienteIdAndAutomotorIdAndSucursalId(clienteId, automotorId, sucursalId);
        if (tallerDuplicado != null) {
            throw new VentaDuplicadaException();
        }

        //validaciones de existencia con las demás tablas
        try {
            cliente = usuarioClient.getCliente(clienteId);
        } catch (FeignException.NotFound e) {
            throw new ClienteNoEncontradoException(clienteId);
        } catch(FeignException.BadRequest e) {
            throw new TipoUsuarioIncorrectoException(clienteId);
        }

        try {
             empleado = usuarioClient.getEmpleado(empleadoId);
        } catch (FeignException.NotFound e) {
            throw new EmpleadoNoEncontradoException(empleadoId);
        } catch(FeignException.BadRequest e) {
            throw new TipoUsuarioIncorrectoException(clienteId);
        }

        try {
             automotor = automotorClient.getAutomotor(automotorId);
        } catch (FeignException.NotFound e) {
            throw new AutomotorNoEncontradoException(automotorId);
        }

        try {
             sucursal = sucursalClient.getSucursal(sucursalId);
        } catch (FeignException.NotFound e) {
            throw new SucursalNoEncontradaException(sucursalId);
        }

        //control de stock
        try {
            inventarioLocal = inventarioClient.getInventarioLocalStock(sucursalId, automotorId);
        } catch (FeignException.NotFound e) {
            throw new InventarioLocalNoEncontradoException(sucursalId, automotorId);
        }

        //reviso la cantidad de stock local sino voy al stockCentral
        if(inventarioLocal.getCantidad() == 0){
            System.out.println("NO HAY STOCK EN EL INVENTARIO LOCAL DE LA SUCURSAL");

            try {
                inventarioCentral = inventarioClient.getInventarioCentralStock(automotorId);
            } catch (FeignException.NotFound e) {
                throw new InventarioCentralNoEncontradoException(automotorId);
            }

            //si tampoco hay stock en el central
            if (inventarioCentral.getCantidad() == 0){
                throw new NoHayStockException(automotorId);
            }

            //calculo con inventario central
            fechaEntrega = fechaOperacion.plusDays(inventarioCentral.getTiempoEntrega());
            //quito 1 del stock central
            inventarioClient.quitarUnoDelStockCentral(automotorId);

        }
        else{
            //calculo con inventario local
            fechaEntrega = fechaOperacion.plusDays(inventarioLocal.getTiempoEntrega());
            //quito 1 del stock local
            inventarioClient.quitarUnoDelStockLocal(sucursalId, automotorId);
        }

        monto = automotor.getPrecioBase();

        Venta venta = new Venta(automotor.getId(), cliente.getId(), empleado.getId(), sucursalId, monto, fechaOperacion, fechaEntrega);
        ventaDAO.save(venta);

        VentaDTO ventaDTO = VentaMapper.toDTO(venta);

        return ventaDTO;

    }


}
