package aerolinea.util;

public final class Constantes {

    private Constantes() {
        super();
    }

    //RESERVAS
    public static final String RESERVA_EXITO_GUARDADO = "Se guardo correctamente la reserva, su código de reserva es: %d";
    public static final String RESERVA_ERROR_GUARDADO = "Error guardando la reserva.";
    public static final String RESERVA_ERROR_CONSULTANDO = "Error consultando las reservas por numero de cédula.";
    public static final String RESERVA_SIN_DATOS = "No se encontraron registros";
    //VUELOS
    public static final String VUELO_ERROR_CONSULTANDO = "=Error consultando los vuelos disponibles.";
    //VALIDACIONES
    public static final String ERROR_MENOR_EDAD = "Recuerde solo los mayores de edad pueden hacer reservas de vuelos";
    public static final String ERROR_CEDULA_VACIA = "El campo cédula es obligatorio.";
    public static final String ERROR_EXISTE_RESERVA = "Solo puedes hacer una reserva para el día de hoy.";
    //ERRORES DE PERCISTENCIA
    public static final String ERROR_CONEXION = "Se ha generado un error accediendo a los datos de la aplicación.";

    public static String getMensaje(String mensajePrincipal, String secundario) {
        return String.format(mensajePrincipal, secundario);
    }
}
