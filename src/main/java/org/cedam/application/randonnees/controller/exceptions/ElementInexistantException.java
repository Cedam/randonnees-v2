package org.cedam.application.randonnees.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ElementInexistantException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8580413173763895407L;

	public ElementInexistantException(String message) {
        super(message);
    }
}
