package ar.com.inventarioservice.repository;

import ar.com.inventarioservice.model.InventarioCentral;
import org.springframework.data.repository.CrudRepository;

public interface IInventarioCentralDAO extends CrudRepository<InventarioCentral, Long> {
}
