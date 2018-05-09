package aerolinea.util;

import aerolinea.model.Reservas;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class ValidorGeneral {

    public boolean validarEdad(Reservas reservas) {
       // LocalDate fechaNacimiento = reservas.getFechaNacimiento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaNacimiento = null;
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, ahora);
        return periodo.getYears() >= 18;
    }


}
