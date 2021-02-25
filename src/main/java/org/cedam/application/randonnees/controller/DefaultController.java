package org.cedam.application.randonnees.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;


@RestController
public class DefaultController {

	@GetMapping("/")
	@ResponseBody
	public  ResponseEntity<String> welcome() {
		String retourLigne = "<br>";
		StringBuilder str = new StringBuilder();
		str.append("\\trek" + retourLigne);
		str.append("\\day");
		return ok(str.toString());
	}

}