package aerolinea.repository;

import aerolinea.model.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservasRepository extends JpaRepository<Reservas, String>  {
}
