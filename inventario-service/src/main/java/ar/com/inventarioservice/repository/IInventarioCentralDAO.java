package ar.com.inventarioservice.repository;

import ar.com.inventarioservice.model.InventarioCentral;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

public interface IInventarioCentralDAO extends CrudRepository<InventarioCentral, Long> {

    @Transactional
    public InventarioCentral findByAutomotorId(Long automotorId);
}
