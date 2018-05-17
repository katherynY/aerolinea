package aerolinea.business;

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
public class VuelosDelegateTest {

    @Mock
    private VuelosRepository vuelosRepository;

    @InjectMocks
    VuelosDelegate vuelosDelegate;

    @Test
    public void consultaVuelosDisponibles() {
        Vuelos vuelo1 = new Vuelos();
        List<Vuelos> vuelos = new ArrayList<>();
        vuelo1.setIdVuelo("1");
        vuelos.add(vuelo1);
        Mockito.when(vuelosRepository.consultarVuelosIda()).thenReturn(vuelos);
        List<Vuelos> result = vuelosDelegate.consultaVuelosDisponibles();
        Assert.assertEquals("1", result.iterator().next().getIdVuelo());
    }

    @Test
    public void consultaVuelosResultNull() {
        Vuelos vuelo = new Vuelos();
        List<Vuelos> vuelos = new ArrayList<>();
        vuelo.setIdVuelo(null);
        vuelo.setCiudadDestino(null);
        vuelo.setCiudadOrigen(null);
        vuelos.add(vuelo);
        Mockito.when(vuelosRepository.consultarVuelosIda()).thenReturn(vuelos);
        List<Vuelos> result = vuelosDelegate.consultaVuelosDisponibles();
        Assert.assertEquals(null, result.iterator().next().getIdVuelo());
        Assert.assertEquals(null, result.iterator().next().getCiudadDestino());
        Assert.assertEquals(null, result.iterator().next().getCiudadOrigen());
    }
}