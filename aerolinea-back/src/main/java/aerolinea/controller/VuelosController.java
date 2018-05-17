package aerolinea.controller;

import aerolinea.business.VuelosDelegate;
import aerolinea.excepcion.BusinessException;
import aerolinea.model.Vuelos;
import aerolinea.util.Constantes;
import aerolinea.util.ValidorGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/vuelos/")
public class VuelosController extends ValidorGeneral {

    @Autowired
    VuelosDelegate vuelosDelegate;


    @GetMapping(path = "consultar")
    public @ResponseBody
    List<Vuelos> consultaVuelosDisponibles() {
        List<Vuelos> vuelosList;
        try {
            vuelosList = vuelosDelegate.consultaVuelosDisponibles();
        } catch (BusinessException e) {
            throw new BusinessException(Constantes.VUELO_ERROR_CONSULTANDO, e);
        }
        return vuelosList;
    }
}