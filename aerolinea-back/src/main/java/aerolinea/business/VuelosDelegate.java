package aerolinea.business;

import aerolinea.excepcion.BusinessException;
import aerolinea.model.Vuelos;
import aerolinea.repository.VuelosRepository;
import aerolinea.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VuelosDelegate {

    @Autowired
    private VuelosRepository vuelosRepository;

    public List<Vuelos> consultaVuelosDisponibles() {
        List<Vuelos> vuelosList;
        try {
            vuelosList = vuelosRepository.consultarVuelosIda();
        } catch (BusinessException e) {
            throw new BusinessException(Constantes.VUELO_ERROR_CONSULTANDO, e);
        }
        return vuelosList;
    }
}
