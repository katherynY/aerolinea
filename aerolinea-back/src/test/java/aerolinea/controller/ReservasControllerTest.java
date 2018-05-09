package aerolinea.controller;

import aerolinea.model.Reservas;
import aerolinea.repository.ReservasRepository;
import aerolinea.repository.VuelosRepository;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ReservasControllerTest {

    @InjectMocks
    ReservasController controller;

    @Mock
    private VuelosRepository vuelosRepository;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Mock
    private ReservasRepository reservasRepository;

    private static final String CEDULA = "1234566543";

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
        Mockito.when(reservasRepository.findAllById(Collections.singleton(ReservasControllerTest.CEDULA))).thenReturn(listReserva);
        List<Reservas> result = controller.consultarReservaId(ReservasControllerTest.CEDULA);
        Assert.assertEquals(ReservasControllerTest.CEDULA, result.iterator().next().getCedula());
        Assert.assertEquals("Katheryn", result.iterator().next().getNombre());
    }

    @Test(expected = Exception.class)
    public void getIdReservasNull() {
        String cedula = "";
        Mockito.doThrow(PersistenceException.class).when(reservasRepository).findAllById(Collections.singleton(cedula));
        controller.consultarReservaId(cedula);
    }

    @Test(expected = Exception.class)
    public void getIdReservasNull2() {
        controller.consultarReservaId(null);
        exception.expect(NullPointerException.class);
        exception.expectMessage("");
    }
}