package org.cedam.application.randonnees.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cedam.application.randonnees.business.TrekBusiness;
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
	private TrekBusiness manager;
	
	@Autowired
	MapperFactory mapperFactory;

	@GetMapping("/trek/all")
	@ResponseBody
	public List<TrekDto> getAll() {
		var treksDto = new ArrayList<TrekDto>();
		var treks = manager.getAll();
		treks.forEach(x -> {
			try {
				treksDto.add(mapperFactory.convertTrekToTrekDto(x));
			} catch (Exception e) {
				logger.error("DayController.getAllByTrekId", e);
			}
		});
		
		return treksDto;
	}

	@GetMapping("/trek/id")
	@ResponseBody
	public TrekDto getById(@RequestParam(value = "id", defaultValue = "0") long id) throws Exception {
		Trek trek = manager.getById(id);
		var trekDto = mapperFactory.convertTrekToTrekDto(trek);
		return trekDto;
	}

	@GetMapping("/trek/save")
	@ResponseBody
	public TrekDto save(TrekDto trekInDto) throws Exception {
		TrekDto trekOutDto = null;
		if (trekInDto != null) {
			Trek trek = manager.save(mapperFactory.convertTrekDtoToTrek(trekInDto));
			trekOutDto = mapperFactory.convertTrekToTrekDto(trek);
		}
		return trekOutDto;
	}

	@GetMapping("/trek/delete")
	@ResponseBody
	public boolean delete(@RequestParam(value = "id", defaultValue = "0") long id) {
		return manager.delete(id);
	}

	@GetMapping("/trek")
	@ResponseBody
	public String test() {
		return "Futur application randonnées : trek.";
	}

}