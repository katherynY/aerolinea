package aerolinea.controller;

import aerolinea.model.Reservas;
import aerolinea.repository.ReservasRepository;
import aerolinea.util.MessageProperties;
import aerolinea.util.ValidorGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ReservasController extends ValidorGeneral {

    @Autowired
    private ReservasRepository reservasRepository;

    @Autowired
    MessageProperties messageProperties;

    @PostMapping(path = "/reserva/agregar")
    @ResponseBody
    public String guardarReserva(@RequestBody Reservas requestReservas) {
        Reservas reservas = null;
        Boolean resultado;
        try {
            resultado = validarEdad(requestReservas);
            if (resultado) {
                reservas = reservasRepository.save(requestReservas);
                if (reservas != null)
                    return messageProperties.getMensajeExitoso() + reservas.getNumeroReserva();
                return messageProperties.getMensajeError();
            } else {
                return messageProperties.getMensajeMenorEdad();
            }
        } catch (Exception e) {
            return messageProperties.getMensajeError();
        }
    }

    @GetMapping(path = "/reserva/consultar")
    public @ResponseBody
    List<Reservas> consultarReservaId(@RequestParam String cedula) {
        List<Reservas> reservas = new ArrayList<>();
        try {
            reservas = reservasRepository.findAllById(Collections.singleton(cedula));
        } catch (Exception e) {
            messageProperties.getMensajeReservaConsultaError();
        }
        return reservas;
    }
}


