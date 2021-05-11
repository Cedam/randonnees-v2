package org.cedam.application.randonnees.exception;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.Getter;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Permet la résolution des messages i18n
     */
    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Gère toutes les exceptions {@link BusinessException}, {@link TechnicalException} ainsi que toutes celles qui en héritent.
     *
     * @param ex      exception
     * @param request request
     * @return response
     */
    @ExceptionHandler({ RequiredAttributException.class, InternalErrorRandonneesException.class, NotFoundRandonneesException.class })
    public final ResponseEntity<ErrorResponse> handleAppException(HttpServletRequest request, RuntimeException ex) {
    	
        ResponseEntity<ErrorResponse> response = buildResponse(INTERNAL_SERVER_ERROR, ex.getMessage(), request.getRequestURI());
        
        return response;
    }

    /**
     * Construit une réponse à partir du statut http, du message d'erreur et de l'uri demandée.
     *
     * @param status  statut http de la réponse
     * @param message message d'erreur
     * @param path    uri
     * @return response
     */
    private ResponseEntity<ErrorResponse> buildResponse(HttpStatus status, String message, String path) {
        return buildResponse(status, status.getReasonPhrase(), message, path);
    }

    /**
     * Construit une réponse à partir du statut http, de la description du statut, du message d'erreur et de l'uri demandée.
     *
     * @param status            statut http de la réponse
     * @param statusDescription description du statut
     * @param message           message d'erreur
     * @param path              uri
     * @return response
     */
    private ResponseEntity<ErrorResponse> buildResponse(HttpStatus status, String statusDescription, String message, String path) {
        final ErrorResponse response = new ErrorResponse(status, statusDescription, message, path);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    /**
     * Réponse envoyée au client
     *
     * @author ARLI
     */
    @Getter
    //@Generated
    class ErrorResponse {

        /**
         * Timestamp
         */
        private final LocalDateTime timestamp;

        /**
         * HTTP statut
         */
        private final int status;

        /**
         * HTTP statut description
         */
        private final String error;

        /**
         * Message à afficher à l'utilisateur
         */
        private final String message;

        /**
         * URI demandée
         */
        private final String path;

        ErrorResponse(HttpStatus httpStatus, String error, String message, String path) {
            this.timestamp = LocalDateTime.now(ZoneId.of("UTC"));
            this.status = httpStatus.value();
            this.error = error;
            this.message = message;
            this.path = path;
        }
    }

}
