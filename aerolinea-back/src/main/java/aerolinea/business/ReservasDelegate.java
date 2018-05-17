package aerolinea.business;

import aerolinea.excepcion.BusinessException;
import aerolinea.excepcion.PersistenceException;
import aerolinea.model.Reservas;
import aerolinea.repository.ReservasRepository;
import aerolinea.util.Constantes;
import aerolinea.util.ValidorGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReservasDelegate extends ValidorGeneral {

    @Autowired
    private ReservasRepository reservasRepository;

    public String guardarReserva(Reservas requestReservas) {
        Reservas reservas;
        Boolean resultado;
        try {
            resultado = validarEdad(requestReservas);
            if (resultado) {
                if (validarReservaporFecha(requestReservas)) {
                    reservas = reservasRepository.save(requestReservas);
                    if (reservas != null) {
                        return Constantes.getMensaje(Constantes.RESERVA_EXITO_GUARDADO, reservas.getNumeroReserva());
                    } else {
                        return Constantes.RESERVA_ERROR_GUARDADO;
                    }
                } else {
                    return Constantes.ERROR_EXISTE_RESERVA;
                }
            } else {
                return Constantes.ERROR_MENOR_EDAD;
            }
        } catch (BusinessException e) {
            throw new BusinessException(Constantes.RESERVA_ERROR_GUARDADO, e);
        }
    }

    public List<Reservas> consultarReservaId(String cedula) {
        List<Reservas> reservas;
        try {
            reservas = reservasRepository.consultaRservaporCedula(cedula);

        } catch (BusinessException e) {
            throw new BusinessException(Constantes.RESERVA_ERROR_CONSULTANDO, e);
        }
        return reservas;
    }

    public Boolean validarReservaporFecha(Reservas reservas) {
        Integer cantidad;
        try {
            cantidad = reservasRepository.consultaRservaporFecha(reservas.getCedula(), reservas.getFechaReserva());
            return cantidad == 0;
        } catch (PersistenceException e) {
            throw new PersistenceException(Constantes.RESERVA_ERROR_CONSULTANDO, e);
        } catch (BusinessException e) {
            throw new BusinessException(Constantes.RESERVA_ERROR_CONSULTANDO, e);
        }
    }
}
