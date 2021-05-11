package org.cedam.application.randonnees.exception;

import java.text.MessageFormat;
import java.util.Formatter;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalErrorRandonneesException extends RuntimeException {


    private static final long serialVersionUID = 3431286450944737222L;

    public InternalErrorRandonneesException(@NonNull final Exception ex) {
        super(ex);
    }
    
    /**
     * Constructeur
     *
     * @param message message
     */
    public InternalErrorRandonneesException(@NonNull final String message) {
        super(message);
    }

    /**
     * Constructeur qui permet de customiser son message à l'aide d'un pattern
     *
     * @param message message pattern
     * @param params  paramètres utilisés par le pattern
     * @see MessageFormat
     */
    public InternalErrorRandonneesException(@NonNull final String message, final Object... params) {
        this(MessageFormat.format(message, params));
    }

    /**
     * Constructeur
     *
     * @param message   message
     * @param throwable exception
     */
    public InternalErrorRandonneesException(@NonNull final String message, final Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Constructeur qui permet de customiser son message à l'aide d'un pattern
     *
     * @param message   message pattern
     * @param throwable exception
     * @param params    paramètres utilisés par le pattern
     * @see Formatter
     */
    public InternalErrorRandonneesException(@NonNull final String message, final Throwable throwable, final Object... params) {
        this(MessageFormat.format(message, params), throwable);
    }
}
