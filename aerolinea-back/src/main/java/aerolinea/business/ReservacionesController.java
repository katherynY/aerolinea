package aerolinea.business;

import aerolinea.model.Reservas;
import aerolinea.model.Vuelos;
import aerolinea.repository.ReservasRepository;
import aerolinea.repository.VuelosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ReservacionesController {

    @Autowired
    private VuelosRepository vuelosRepository;

    @Autowired
    private ReservasRepository reservasRepository;

    @PostMapping(path = "/addReserva")
    public @ResponseBody
    String addReserva(@RequestBody Reservas requestReservas) {
        Reservas cadena = null;
        Boolean resultado;
        try {
            cadena = reservasRepository.save(requestReservas);
            resultado = validarEdad(requestReservas);
            if (resultado) {
                if (cadena != null)
                    return "Se guardo correctamente la reserva, su codigo de reserva es : " + cadena.getNumeroReserva();
                return "Error guardando la reserva.";

            } else {
                return "Recuerde solo los mayores de edad pueden hacer reservas de vuelo.";
            }
        } catch (Exception e) {
            return "Error guardando la reserva.";
        }
    }

    @GetMapping(path = "/getAllVuelos")
    public @ResponseBody
    Iterable<Vuelos> getAllVuelos() {
        return vuelosRepository.findAll();
    }

    @GetMapping(path = "/getIdReservas")
    public @ResponseBody
    List<Reservas> getIdReservas(@RequestParam String cedula) {
        return reservasRepository.findAllById(Collections.singleton(cedula));
    }

    private boolean validarEdad(Reservas reservas) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(reservas.getFechaNacimiento().toString(), fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNacimiento, ahora);

        return periodo.getYears() < 18;
    }
}


