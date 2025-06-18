package ar.com.tallerservice.repository;

import ar.com.tallerservice.model.Taller;
import org.springframework.data.repository.CrudRepository;

public interface ITallerDAO extends CrudRepository<Taller, Long> {
}
