package aerolinea.business;

import aerolinea.model.Reservas;
import aerolinea.repository.ReservasRepository;
import aerolinea.util.Constantes;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ReservasDelegateTest {

    @Mock
    private ReservasRepository reservasRepository;

    @InjectMocks
    ReservasDelegate reservasDelegate;

    private static final String CEDULA_CONSULTA_ID = "1234566543";
    private static final String CEDULA_VALIDAR_FECHA = "1234568789";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void guardarReservaExitosamente() {
        Reservas reservas = new Reservas();
        reservas.setCedula(ReservasDelegateTest.CEDULA_CONSULTA_ID);
        reservas.setNombre("Katheryn");
        reservas.setFechaReserva(new Date(1526360400));
        reservas.setFechanacimiento(new Date(706597200));
        Mockito.when(reservasRepository.save(reservas)).thenReturn(reservas);
        String result = reservasDelegate.guardarReserva(reservas);
        Assert.assertEquals(Constantes.getMensaje(Constantes.RESERVA_EXITO_GUARDADO, null), result);
    }

    @Test
    public void guardarReservaValidacionMenorEdad() {
        Reservas reservas = new Reservas();
        reservas.setCedula(ReservasDelegateTest.CEDULA_CONSULTA_ID);
        reservas.setNombre("Katheryn");
        reservas.setFechaReserva(Date.from(LocalDate.of(2018, 5, 15)
                .atStartOfDay(ZoneId.systemDefault()).toInstant()));
        reservas.setFechanacimiento(Date.from(LocalDate.of(2000, 7, 01)
                .atStartOfDay(ZoneId.systemDefault()).toInstant()));
        Mockito.when(reservasRepository.save(reservas)).thenReturn(reservas);
        String result = reservasDelegate.guardarReserva(reservas);
        Assert.assertEquals(Constantes.ERROR_MENOR_EDAD, result);
    }

    @Test
    public void guardarReservaValidacionFechaIgualCero() {
        Reservas reservas = new Reservas();
        Boolean valor = true;
        reservas.setCedula(ReservasDelegateTest.CEDULA_VALIDAR_FECHA);
        reservas.setNombre("Katheryn");
        reservas.setFechaReserva(Date.from(LocalDate.of(2018, 5, 15)
                .atStartOfDay(ZoneId.systemDefault()).toInstant()));
        reservas.setFechanacimiento(Date.from(LocalDate.of(1992, 7, 01)
                .atStartOfDay(ZoneId.systemDefault()).toInstant()));
        Mockito.when(reservasRepository.save(reservas)).thenReturn(reservas);
        String result = reservasDelegate.guardarReserva(reservas);
        Assert.assertEquals(Constantes.getMensaje(Constantes.RESERVA_EXITO_GUARDADO, null), result);
    }

    @Test
    public void consultarReservaIdExitosa() {
        Reservas reservas = new Reservas();
        List<Reservas> listReserva = new ArrayList<>();
        reservas.setCedula(ReservasDelegateTest.CEDULA_CONSULTA_ID);
        reservas.setNombre("Katheryn");
        listReserva.add(reservas);
        Mockito.when(reservasRepository.findAllById(Collections.singleton(ReservasDelegateTest.CEDULA_CONSULTA_ID))).thenReturn(listReserva);
        List<Reservas> result = reservasDelegate.consultarReservaId(ReservasDelegateTest.CEDULA_CONSULTA_ID);
        Assert.assertEquals(ReservasDelegateTest.CEDULA_CONSULTA_ID, result.iterator().next().getCedula());
        Assert.assertEquals("Katheryn", result.iterator().next().getNombre());
    }

    @Test
    public void validarReservaporFechaIgualCero() {
        Integer cantidad = 0;
        Reservas reservas = new Reservas();
        reservas.setCedula(CEDULA_VALIDAR_FECHA);
        reservas.setFechaReserva(new Date(1525928400));
        Mockito.when(reservasRepository.consultaRservaporFecha(reservas.getCedula(), reservas.getFechaReserva())).thenReturn(cantidad);
        boolean result = reservasDelegate.validarReservaporFecha(reservas);
        Assert.assertEquals(true, result);
    }

    @Test
    public void validarReservaporFechaIgualUno() {
        Integer cantidad = 1;
        Reservas reservas = new Reservas();
        reservas.setCedula(CEDULA_VALIDAR_FECHA);
        reservas.setFechaReserva(new Date(1525928400));
        Mockito.when(reservasRepository.consultaRservaporFecha(reservas.getCedula(), reservas.getFechaReserva())).thenReturn(cantidad);
        boolean result = reservasDelegate.validarReservaporFecha(reservas);
        Assert.assertEquals(false, result);
    }

    @Test(expected = Exception.class)
    public void validarReservaporFechaSinInformacion() {
        Reservas reservas = new Reservas();
        reservas.setCedula(null);
        reservas.setFechaReserva(null);
        reservasDelegate.validarReservaporFecha(reservas);
        Mockito.doThrow(javax.persistence.PersistenceException.class).when(reservasRepository).findAllById(Collections.singleton(reservas.getCedula()));
        reservasDelegate.consultarReservaId(reservas.getCedula());

    }
}