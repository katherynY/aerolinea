package aerolinea.controller;

import aerolinea.model.Vuelos;
import aerolinea.repository.VuelosRepository;
import aerolinea.util.MessageProperties;
import aerolinea.util.ValidorGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class VuelosController extends ValidorGeneral {

    @Autowired
    private VuelosRepository vuelosRepository;

    @Autowired
    MessageProperties messageProperties;

    @GetMapping(path = "/vuelos/consultar")
    public @ResponseBody
    List<Vuelos> consultaVuelosDisponibles() {
        List<Vuelos> vuelosList = new ArrayList<>();
        try {
            validarEdad(null);
            vuelosList = vuelosRepository.findAll();
        } catch (Exception e) {
            messageProperties.getMensajeExitoso();
        }
        return vuelosList;
    }
}
