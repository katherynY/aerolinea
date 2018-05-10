package aerolinea.controller;

import aerolinea.business.VuelosDelegate;
import aerolinea.excepcion.BusinessException;
import aerolinea.excepcion.PersistenceException;
import aerolinea.model.Vuelos;
import aerolinea.util.Constantes;
import aerolinea.util.ValidorGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class VuelosController extends ValidorGeneral {

    @Autowired
    VuelosDelegate vuelosDelegate;


    @GetMapping(path = "/vuelos/consultar")
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