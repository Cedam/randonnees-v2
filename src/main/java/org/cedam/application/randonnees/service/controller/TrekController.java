package org.cedam.application.randonnees.service.controller;

import java.util.ArrayList;
import java.util.List;

import org.cedam.application.randonnees.entityV6.Trek;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrekController {

	@GetMapping("/trek/all")
	@ResponseBody
	public List<Trek> getAll() {
		return new ArrayList<Trek>();
	}

	@GetMapping("/trek/id")
	@ResponseBody
	public Trek getById(@RequestParam(value = "id", defaultValue = "0") int id) {
		Trek trek = new Trek();
		trek.setId(id);
		return trek;
	}

	@GetMapping("/trek/save")
	@ResponseBody
	public Trek save(Trek trek) {
		return trek;
	}
	
	@GetMapping("/trek")
	@ResponseBody
	public String test() {
		return "Futur application randonnées : trek";
	}

}