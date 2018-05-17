package aerolinea.repository;

import aerolinea.excepcion.PersistenceException;
import aerolinea.model.Vuelos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VuelosRepository extends JpaRepository<Vuelos, String> {

    @Query(value = "SELECT * FROM #{#entityName} WHERE TIPO_VIAJE = 0 ", nativeQuery = true)
    List<Vuelos> consultarVuelosIda() throws PersistenceException;

}
