package aerolinea.controller;

import aerolinea.controller.VuelosController;
import aerolinea.model.Vuelos;
import aerolinea.repository.VuelosRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class VuelosControllerTest {

    @Mock
    private VuelosRepository vuelosRepository;

    @InjectMocks
    VuelosController controller;

    @Test
    public void consultaVuelos() {
        Vuelos vuelo1 = new Vuelos();
        List<Vuelos> vuelos = new ArrayList<>();
        vuelo1.setIdVuelo("1");
        vuelos.add(vuelo1);
        Mockito.when(vuelosRepository.findAll()).thenReturn(vuelos);
        List<Vuelos> result = controller.consultaVuelosDisponibles();
        Assert.assertEquals("1", result.iterator().next().getIdVuelo());
    }
}
