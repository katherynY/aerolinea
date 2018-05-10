package aerolinea.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    public static final String ERROR_MESSAGE_HEADER = "internalErrorMessage";

    @ExceptionHandler
    protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(ERROR_MESSAGE_HEADER, ex.getMessage());
        return handleExceptionInternal(ex, "",
                headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}