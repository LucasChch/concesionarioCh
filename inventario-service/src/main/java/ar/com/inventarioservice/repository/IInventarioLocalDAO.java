package ar.com.inventarioservice.repository;

import ar.com.inventarioservice.model.InventarioLocal;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

public interface IInventarioLocalDAO extends CrudRepository<InventarioLocal, Long> {

    @Transactional
    public InventarioLocal findBySucursalIdAndAutomotorId(Long sucursalId, Long automotorId);
}
