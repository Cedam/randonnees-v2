package org.cedam.application.randonnees.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cedam.application.randonnees.dto.TrekDto;
import org.cedam.application.randonnees.entity.Trek;
import org.cedam.application.randonnees.utils.mapper.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrekController {

	private static final Logger logger = LogManager.getLogger(TrekController.class);
	
	@Autowired
	MapperFactory mapperFactory;

	@GetMapping("/trek/all")
	@ResponseBody
	public List<Trek> getAll() {
		return new ArrayList<>();
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
	public Trek save(TrekDto trekDto) {
		Trek trek = null;
		try {
			trek = mapperFactory.convertTrekDtoToTrek(trekDto);
		} catch (Exception e) {
			logger.error("TrekController.save", e);
		}
		return trek;
	}

	@GetMapping("/trek")
	@ResponseBody
	public String test() {
		return "Futur application randonnées : trek.";
	}

}