package aerolinea.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:message.properties")
public class MessageProperties {

    @Value("${reserva.exito.guardando}")
    private String mensajeExitoso;
    @Value("${reserva.error.guardando}")
    private String mensajeError;
    @Value("${reserva.validacion.menor}")
    private String mensajeMenorEdad;
    @Value("${vuelos.error}")
    private String mensajeVueloError;
    @Value("${reserva.error.consultando}")
    private String mensajeReservaConsultaError;

    public String getMensajeExitoso() {
        return mensajeExitoso;
    }

    public void setMensajeExitoso(String mensajeExitoso) {
        this.mensajeExitoso = mensajeExitoso;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getMensajeMenorEdad() {
        return mensajeMenorEdad;
    }

    public void setMensajeMenorEdad(String mensajeMenorEdad) {
        this.mensajeMenorEdad = mensajeMenorEdad;
    }

    public String getMensajeVueloError() {
        return mensajeVueloError;
    }

    public void setMensajeVueloError(String mensajeVueloError) {
        this.mensajeVueloError = mensajeVueloError;
    }


    public String getMensajeReservaConsultaError() {
        return mensajeReservaConsultaError;
    }

    public void setMensajeReservaConsultaError(String mensajeReservaConsultaError) {
        this.mensajeReservaConsultaError = mensajeReservaConsultaError;
    }
}
