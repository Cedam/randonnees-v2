package org.cedam.application.randonnees.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Default {

	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		String retourLigne = "<br>";
		StringBuilder str = new StringBuilder();		
		str.append("\\trek"+retourLigne);
		str.append("\\day");
		return str.toString();
	}

}