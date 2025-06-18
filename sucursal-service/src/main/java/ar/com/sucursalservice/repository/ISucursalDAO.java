package ar.com.sucursalservice.repository;

import ar.com.sucursalservice.models.Sucursal;
import org.springframework.data.repository.CrudRepository;

public interface ISucursalDAO extends CrudRepository<Sucursal, Long> {
}
