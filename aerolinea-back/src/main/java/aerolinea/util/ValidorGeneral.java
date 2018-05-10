package aerolinea.util;

import aerolinea.model.Reservas;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class ValidorGeneral {

    public boolean validarEdad(Reservas reservas) {
        if (reservas.getFechaNacimiento() != null) {
            LocalDate fechaNacimiento = reservas.getFechaNacimiento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate ahora = LocalDate.now();
            Period periodo = Period.between(fechaNacimiento, ahora);
            return periodo.getYears() >= 18;
        }
        return false;
    }

    public String validarCedula(String cedula) {
        if (cedula.equals(""))
            return Constantes.ERROR_CEDULA_VACIA;
        return "";
    }
}