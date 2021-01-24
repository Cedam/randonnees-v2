package org.cedam.application.randonnees.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

	@GetMapping("/")
	@ResponseBody
	public String welcome() {
		String retourLigne = "<br>";
		StringBuilder str = new StringBuilder();
		str.append("\\trek" + retourLigne);
		str.append("\\day");
		return str.toString();
	}

}