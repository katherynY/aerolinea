package aerolinea.util;

import aerolinea.model.Reservas;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ValidorGeneralTest {

    @InjectMocks
    private ValidorGeneral validorGeneral;


    @Test
    public void validarEdadFechaMenor() {
        Reservas reservas = new Reservas();
        reservas.setFechanacimiento( Date.from(LocalDate.of(2018, 7, 18)
                .atStartOfDay(ZoneId.systemDefault()).toInstant()));
        boolean result = validorGeneral.validarEdad(reservas);
        Assert.assertEquals(false, result);
    }

    @Test
    public void validarEdadFechaMayor() {
        Reservas reservas = new Reservas();
        reservas.setFechanacimiento( Date.from(LocalDate.of(1992, 7, 03)
                .atStartOfDay(ZoneId.systemDefault()).toInstant()));
        boolean result = validorGeneral.validarEdad(reservas);
        Assert.assertEquals(true, result);
    }

    @Test
    public void validarEdadIgual18() {
        Reservas reservas = new Reservas();
        reservas.setFechanacimiento(
                Date.from(LocalDate.of(1999, 7, 01)
                        .atStartOfDay(ZoneId.systemDefault()).toInstant()));
        boolean result = validorGeneral.validarEdad(reservas);
        Assert.assertEquals(true, result);
    }

    @Test
    public void validarEdadSinFecha() {
        Reservas reservas = new Reservas();
        reservas.setFechanacimiento(null);
        boolean result = validorGeneral.validarEdad(reservas);
        Assert.assertEquals(false, result);
    }

}