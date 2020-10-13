package org.cedam.application.randonnees.service.controller;

import java.util.ArrayList;
import java.util.List;

import org.cedam.application.randonnees.entityV6.Day;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DayController {

	@GetMapping("/day/all")
	@ResponseBody
	public List<Day> getAll() {
		return new ArrayList<Day>();
	}

	@GetMapping("/day/id")
	@ResponseBody
	public Day getById(@RequestParam(value = "id", defaultValue = "0") int id) {
		Day day = new Day();
		day.setId(id);
		return day;
	}

	@GetMapping("/day/save")
	@ResponseBody
	public Day save(Day day) {
		return day;
	}
	
	@GetMapping("/day")
	@ResponseBody
	public String test() {
		return "Futur application randonnées : day";
	}


}