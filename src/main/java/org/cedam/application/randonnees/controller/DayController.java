package org.cedam.application.randonnees.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cedam.application.randonnees.dto.DayDto;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.utils.mapper.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DayController {

	private static final Logger logger = LogManager.getLogger(DayController.class);

	@Autowired
	MapperFactory mapperFactory;

	@GetMapping("/day/all")
	@ResponseBody
	public List<Day> getAll() {
		return new ArrayList<>();
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
	public Day save(DayDto dayDto) {
		Day day = null;
		if (dayDto != null) {
			try {
				day = mapperFactory.convertDayDtoToDay(dayDto);
			} catch (Exception e) {
				logger.error("DayController.save", e);
			}
		}
		return day;
	}

	@GetMapping("/day")
	@ResponseBody
	public String test() {
		return "Futur application randonnées : day";
	}

}