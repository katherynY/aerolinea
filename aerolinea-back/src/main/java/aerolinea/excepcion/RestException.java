package aerolinea.excepcion;

public class RestException extends RuntimeException {

    private String mensaje;

    public RestException(Throwable cause) {
        super(cause);
    }

    public RestException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public RestException(String message) {
        super(message);
    }

    public String getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
