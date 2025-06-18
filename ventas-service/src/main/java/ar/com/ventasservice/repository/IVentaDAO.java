package ar.com.ventasservice.repository;

import ar.com.ventasservice.model.Venta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface IVentaDAO extends CrudRepository<Venta, Long> {

    @Transactional
    public Venta findByClienteIdAndAutomotorIdAndSucursalId(Long clienteId, Long automotorId, Long sucursalId);
}
