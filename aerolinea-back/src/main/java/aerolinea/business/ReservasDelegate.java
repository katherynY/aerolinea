package aerolinea.business;

import aerolinea.excepcion.BusinessException;
import aerolinea.model.Reservas;
import aerolinea.repository.ReservasRepository;
import aerolinea.util.Constantes;
import aerolinea.util.ValidorGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
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
                    if (reservas != null)
                        return Constantes.getMensaje(Constantes.RESERVA_EXITO_GUARDADO, reservas.getNumeroReserva());
                    return Constantes.RESERVA_ERROR_GUARDADO;
                }

            } else {
                return Constantes.ERROR_MENOR_EDAD;
            }
        } catch (BusinessException e) {
            throw new BusinessException(Constantes.RESERVA_ERROR_GUARDADO, e);
        }
        return "";

    }

    public List<Reservas> consultarReservaId(String cedula) {
        List<Reservas> reservas;
        try {
            reservas = reservasRepository.findAllById(Collections.singleton(cedula));
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
        } catch (BusinessException e) {
            throw new BusinessException(Constantes.RESERVA_ERROR_CONSULTANDO, e);
        }
    }
}
