package aerolinea.util;

import aerolinea.model.Reservas;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ValidorGeneralTest {

    @InjectMocks
    private ValidorGeneral validorGeneral;


    @Test
    public void validarEdadFechaMenor() {
        Reservas reservas = new Reservas();
        reservas.setFechanacimiento(new Date("18/07/2018"));
        boolean result = validorGeneral.validarEdad(reservas);
        Assert.assertEquals(false, result);
    }

    @Test
    public void validarEdadFechaMayor() {
        Reservas reservas = new Reservas();
        reservas.setFechanacimiento(new Date("03/07/1992"));
        boolean result = validorGeneral.validarEdad(reservas);
        Assert.assertEquals(true, result);
    }

    @Test
    public void validarEdadIgual18() {
        Reservas reservas = new Reservas();
        reservas.setFechanacimiento(new Date("03/07/2000"));
        boolean result = validorGeneral.validarEdad(reservas);
        Assert.assertEquals(true, result);
    }

    @Test(expected = Exception.class)
    public void validarEdadSinFecha() {
        Reservas reservas = new Reservas();
        reservas.setFechanacimiento(null);
        boolean result = validorGeneral.validarEdad(reservas);
    }

}