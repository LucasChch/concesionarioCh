package ar.com.ventasservice.repository;

import ar.com.ventasservice.model.Venta;
import org.springframework.data.repository.CrudRepository;

public interface IVentaDAO extends CrudRepository<Venta, Long> {
}
