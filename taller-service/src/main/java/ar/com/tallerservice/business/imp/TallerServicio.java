package ar.com.tallerservice.business.imp;

import ar.com.tallerservice.business.ITallerServicio;
import ar.com.tallerservice.dto.TallerDTO;
import ar.com.tallerservice.dto.integrations.AutomotorDTO;
import ar.com.tallerservice.dto.integrations.ClienteDTO;
import ar.com.tallerservice.dto.integrations.SucursalDTO;
import ar.com.tallerservice.exceptions.*;
import ar.com.tallerservice.integrations.resClient.IAutomotorClient;
import ar.com.tallerservice.integrations.resClient.ISucursalClient;
import ar.com.tallerservice.integrations.resClient.IUsuarioClient;
import ar.com.tallerservice.mapper.TallerMapper;
import ar.com.tallerservice.model.Taller;
import ar.com.tallerservice.repository.ITallerDAO;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class TallerServicio implements ITallerServicio {

    @Autowired
    ITallerDAO tallerDAO;

    @Autowired
    IUsuarioClient usuarioClient;

    @Autowired
    ISucursalClient sucursalClient;

    @Autowired
    IAutomotorClient automotorClient;

    @Override
    public TallerDTO crearTaller(Long automotorId, Long clienteId, Long sucursalId, Integer kilometros, String descripcion) {

        //inicializo variables
        ClienteDTO cliente;
        AutomotorDTO automotor;
        SucursalDTO sucursal;

        LocalDate fechaRecepcion = LocalDate.now();
        LocalDate fechaEntrega;
        BigDecimal costo;
        Boolean hayGarantia;

        if (automotorId == null) {
            throw new DatosTallerException("El automotor es obligatorio.");
        }
        if (clienteId == null) {
            throw new DatosTallerException("El cliente es obligatorio.");
        }
        if (sucursalId == null) {
            throw new DatosTallerException("La sucursal es obligatorio.");
        }
        if (descripcion == null) {
            throw new DatosTallerException("La descripcion es obligatorio.");
        }

        //valido que no exista ya una reserva de taller
        Taller tallerDuplicado = tallerDAO.findTallerByClienteIdAndAutomotorIdAndSucursalId(clienteId, automotorId, sucursalId);
        if (tallerDuplicado != null) {
            throw new TallerDuplicadoException();
        }



        //validaciones
        try {
            cliente = usuarioClient.getCliente(clienteId);
        } catch (FeignException.NotFound e) {
            throw new ClienteNoEncontradoException(clienteId);
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

        if (kilometros == null || kilometros <= 0) {
            throw new KilometrosException();
        }

        //compruebo si hay garantia
        if (automotor.getAnio() + automotor.getAniosGarantia() > fechaRecepcion.getYear()) {
            hayGarantia = true;
            costo = BigDecimal.valueOf(0);
        }
        else{
            hayGarantia = false;

            //cobro 1000 por kilómetros
            costo = BigDecimal.valueOf(kilometros * 1000);
        }

        //calculo fecha de entrega entre 5 a 31 días de manera aleatoria
        int diasRandom = ThreadLocalRandom.current().nextInt(5, 31); // 31 exclusivo
        fechaEntrega = fechaRecepcion.plusDays(diasRandom);

        Taller taller = new Taller(automotorId, clienteId, sucursalId, fechaRecepcion, fechaEntrega, kilometros, hayGarantia, descripcion, costo);
        tallerDAO.save(taller);

        TallerDTO tallerDTO = TallerMapper.toDTO(taller);

        return tallerDTO;
    }

    @Override
    public TallerDTO buscarTaller(Long tallerId) {
        Taller taller = tallerDAO.findById(tallerId).orElseThrow();

        TallerDTO tallerDTO = TallerMapper.toDTO(taller);

        return tallerDTO;
    }
}
