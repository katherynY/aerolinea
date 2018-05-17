package aerolinea.controller;

import aerolinea.business.ReservasDelegate;
import aerolinea.excepcion.BusinessException;
import aerolinea.excepcion.RestException;
import aerolinea.model.Reservas;
import aerolinea.util.Constantes;
import aerolinea.util.ValidorGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/reserva/")
public class ReservasController extends ValidorGeneral {

    @Autowired
    ReservasDelegate reservasDelegate;


    @PostMapping(path = "agregar")
    @ResponseBody
    public String guardarReserva(@RequestBody Reservas requestReservas) {
        String mensaje;
        try {
            mensaje = reservasDelegate.guardarReserva(requestReservas);
        } catch (BusinessException e) {
            return Constantes.RESERVA_ERROR_GUARDADO;
        }
        return mensaje;
    }

    @GetMapping(path = "consultar")
    public @ResponseBody
    List<Reservas> consultarReservaId(@RequestParam String cedula) {
        List<Reservas> reservas = new ArrayList<>();
        try {
            String cedulaValidada = validarCedula(cedula);
            if (cedulaValidada.equals("")) {
                reservas = reservasDelegate.consultarReservaId(cedula);
            } else {
                throw new RestException(Constantes.ERROR_CEDULA_VACIA);
            }
        } catch (RestException e) {
            throw new RestException(Constantes.ERROR_CEDULA_VACIA);
        } catch (BusinessException e) {
            throw new BusinessException(Constantes.RESERVA_ERROR_CONSULTANDO, e);
        }
        return reservas;
    }
}


