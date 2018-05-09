package aerolinea.repository;

import org.springframework.data.repository.CrudRepository;
import aerolinea.model.Vuelos;

public interface VuelosRepository extends CrudRepository<Vuelos, String> {
}
