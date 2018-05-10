package aerolinea.repository;

import aerolinea.excepcion.PersistenceException;
import aerolinea.model.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface ReservasRepository extends JpaRepository<Reservas, String> {

    @Query(value = "SELECT COUNT(CEDULA) FROM #{#entityName} WHERE CEDULA = :cedula  AND FECHA_RESERVA = :fecha ", nativeQuery = true)
    Integer consultaRservaporFecha(@Param("cedula") String cedula,
                                   @Param("fecha") Date fecha) throws PersistenceException;
}
