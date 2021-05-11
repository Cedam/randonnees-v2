package org.cedam.application.randonnees.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundRandonneesException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8580413173763895407L;

	public NotFoundRandonneesException(String message) {
        super(message);
    }
}
