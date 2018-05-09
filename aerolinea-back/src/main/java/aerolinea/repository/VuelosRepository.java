package aerolinea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import aerolinea.model.Vuelos;

public interface VuelosRepository extends JpaRepository<Vuelos, String> {
}
