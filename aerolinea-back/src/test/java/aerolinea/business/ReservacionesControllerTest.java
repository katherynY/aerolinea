package aerolinea.business;

import aerolinea.model.Reservas;
import aerolinea.model.Vuelos;
import aerolinea.repository.ReservasRepository;
import aerolinea.repository.VuelosRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ReservacionesControllerTest {

    @InjectMocks
    ReservacionesController controller;

    @Mock
    private VuelosRepository vuelosRepository;

    @Mock
    private ReservasRepository reservasRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addReserva() {
    }

    @Test
    public void getAllVuelos() {
        Vuelos vuelo1 = new Vuelos();
        List<Vuelos> vuelos = new ArrayList<Vuelos>();
        vuelo1.setIdVuelo("1");
        vuelos.add(vuelo1);
        Iterable<Vuelos> vuelosIterable = vuelos;
        Mockito.when(vuelosRepository.findAll()).thenReturn(vuelosIterable);
        Iterable<Vuelos> result = controller.getAllVuelos();
        Assert.assertEquals("1", result.iterator().next().getIdVuelo());
    }

    @Test
    public void getIdReservas() {
        Reservas reservas = new Reservas();
        List<Reservas> listReserva = new ArrayList<Reservas>();
        String cedula = "1234566543";
        reservas.setCedula("1234566543");
        reservas.setNombre("Katheryn");
        listReserva.add(reservas);
        Mockito.when(reservasRepository.findAllById(Collections.singleton(cedula))).thenReturn(listReserva);
        List<Reservas> result = controller.getIdReservas(cedula);
        Assert.assertEquals("1234566543", result.iterator().next().getCedula());
        Assert.assertEquals("Katheryn", result.iterator().next().getNombre());
    }

    @Test(expected = Exception.class)
    public void getIdReservasNull() {
        Reservas reservas = new Reservas();
        String cedula = "";
        Mockito.doThrow(PersistenceException.class).when(reservasRepository).findAllById(Collections.singleton(cedula));
        controller.getIdReservas(cedula);
    }


    @Test
    public void validarEdad() {
    }
}