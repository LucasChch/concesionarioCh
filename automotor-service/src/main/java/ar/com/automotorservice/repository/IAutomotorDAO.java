package ar.com.automotorservice.repository;

import ar.com.automotorservice.model.Automotor;
import org.springframework.data.repository.CrudRepository;

public interface IAutomotorDAO extends CrudRepository<Automotor, Long> {

    public Automotor findAutomotorsByMarcaAndModeloAndAnio(String marca, String modelo, Integer anio);
}