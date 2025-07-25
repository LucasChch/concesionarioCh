package ar.com.tallerservice.business;

import ar.com.tallerservice.dto.TallerDTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ITallerServicio {
    public TallerDTO crearTaller(Long automotorId, Long clienteId, Long sucursalId, Integer kilometros, String descripcion);
    public TallerDTO buscarTaller(Long tallerId);
}
