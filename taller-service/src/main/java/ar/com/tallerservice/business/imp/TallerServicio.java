package ar.com.tallerservice.business.imp;

import ar.com.tallerservice.business.ITallerServicio;
import ar.com.tallerservice.dto.TallerDTO;
import ar.com.tallerservice.mapper.TallerMapper;
import ar.com.tallerservice.model.Taller;
import ar.com.tallerservice.repository.ITallerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TallerServicio implements ITallerServicio {

    @Autowired
    ITallerDAO tallerDAO;

    @Override
    public TallerDTO crearTaller(Long automotorId, Long clienteId, Long sucursalId, LocalDate fechaRecepcion, LocalDate fechaEntrega, Integer kilometros, boolean hayGarantia, String descripcion, BigDecimal costo) {
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
