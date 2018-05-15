package aerolinea.controller;

import aerolinea.business.ReservasDelegate;
import aerolinea.model.Reservas;
import aerolinea.repository.VuelosRepository;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ReservasControllerTest {

    private static final String CEDULA = "1234566543";
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @InjectMocks
    ReservasController reservasController;

    @Mock
    private VuelosRepository vuelosRepository;

    @Mock
    ReservasDelegate reservasDelegate;
    @Test
    public void addReserva() {
    }

    @Test
    public void getIdReservas() {
        Reservas reservas = new Reservas();
        List<Reservas> listReserva = new ArrayList<>();
        reservas.setCedula(ReservasControllerTest.CEDULA);
        reservas.setNombre("Katheryn");
        listReserva.add(reservas);
        Mockito.when(reservasDelegate.consultarReservaId(ReservasControllerTest.CEDULA)).thenReturn(listReserva);
        List<Reservas> result = reservasController.consultarReservaId(ReservasControllerTest.CEDULA);
        Assert.assertEquals(ReservasControllerTest.CEDULA, result.iterator().next().getCedula());
        Assert.assertEquals("Katheryn", result.iterator().next().getNombre());
    }

    @Test(expected = Exception.class)
    public void getIdReservasNull() {
        String cedula = "";
        Mockito.doThrow(PersistenceException.class).when(reservasDelegate).consultarReservaId(cedula);
        reservasDelegate.consultarReservaId(cedula);
    }

    @Test(expected = Exception.class)
    public void getIdReservasNull2() {
        reservasController.consultarReservaId(null);
        exception.expect(NullPointerException.class);
        exception.expectMessage("");
    }
}