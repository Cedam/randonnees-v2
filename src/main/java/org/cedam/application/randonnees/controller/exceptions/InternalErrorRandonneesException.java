package org.cedam.application.randonnees.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalErrorRandonneesException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8580413173763895407L;

	public InternalErrorRandonneesException(Exception e) {
        super(e);
    }
}
