package ar.com.tallerservice.repository;

import ar.com.tallerservice.dto.TallerDTO;
import ar.com.tallerservice.model.Taller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ITallerDAO extends CrudRepository<Taller, Long> {

    @Transactional
    public Taller  findTallerByClienteIdAndAutomotorIdAndSucursalId(Long clienteId, Long automotorId, Long sucursalId);

}
