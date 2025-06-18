package ar.com.inventarioservice.repository;

import ar.com.inventarioservice.model.InventarioLocal;
import org.springframework.data.repository.CrudRepository;

public interface IInventarioLocalDAO extends CrudRepository<InventarioLocal, Long> {
}
