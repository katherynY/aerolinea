package aerolinea.controller;

import aerolinea.business.VuelosDelegate;
import aerolinea.model.Vuelos;
import aerolinea.repository.VuelosRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VuelosControllerTest {

    @InjectMocks
    VuelosController vuelosController;

    @Mock
    private VuelosRepository vuelosRepository;

    @Mock
    VuelosDelegate vuelosDelegate;


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void consultaVuelos() {
        Vuelos vuelo = new Vuelos();
        List<Vuelos> vuelos = new ArrayList<>();
        vuelo.setIdVuelo("1");
        vuelo.setCiudadDestino("Cartagena");
        vuelo.setCiudadOrigen("Medellin");
        vuelos.add(vuelo);
        Mockito.when(vuelosDelegate.consultaVuelosDisponibles()).thenReturn(vuelos);
        List<Vuelos> result = vuelosController.consultaVuelosDisponibles();
        Assert.assertEquals("1", result.iterator().next().getIdVuelo());
        Assert.assertEquals("Cartagena", result.iterator().next().getCiudadDestino());
        Assert.assertEquals("Medellin", result.iterator().next().getCiudadOrigen());
    }

    @Test
    public void consultaVuelosResultNull() {
        Vuelos vuelo = new Vuelos();
        List<Vuelos> vuelos = new ArrayList<>();
        vuelo.setIdVuelo(null);
        vuelo.setCiudadDestino(null);
        vuelo.setCiudadOrigen(null);
        vuelos.add(vuelo);
        Mockito.when(vuelosDelegate.consultaVuelosDisponibles()).thenReturn(vuelos);
        List<Vuelos> result = vuelosController.consultaVuelosDisponibles();
        Assert.assertEquals(null, result.iterator().next().getIdVuelo());
        Assert.assertEquals(null, result.iterator().next().getCiudadDestino());
        Assert.assertEquals(null, result.iterator().next().getCiudadOrigen());
    }
}
