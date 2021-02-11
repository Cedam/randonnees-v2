package org.cedam.application.randonnees.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cedam.application.randonnees.business.DayBusiness;
import org.cedam.application.randonnees.dto.DayDto;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.service.DayService;
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
<<<<<<< HEAD
	private DayService manager;
=======
	private DayBusiness manager;
>>>>>>> bb70fb99bc4a70fd3a386636e7ffff87fd07206c

	@Autowired
	MapperFactory mapperFactory;

	@GetMapping("/day/id")
	@ResponseBody
	public DayDto getById(@RequestParam(value = "id", defaultValue = "0") long id) throws Exception {
		Day day = manager.getById(id);
		var dayDto = mapperFactory.convertDayToDayDto(day);
		return dayDto;
	}

	@GetMapping("/day/bytrekid")
	@ResponseBody
	public List<DayDto> getAllByTrekId(@RequestParam(value = "id", defaultValue = "0") long id) {
<<<<<<< HEAD
=======
		// TODO
>>>>>>> bb70fb99bc4a70fd3a386636e7ffff87fd07206c
		var daysDto = new ArrayList<DayDto>();
		var days = manager.getAll();
		days.forEach(x -> {
			try {
				daysDto.add(mapperFactory.convertDayToDayDto(x));
			} catch (Exception e) {
				logger.error("DayController.getAllByTrekId", e);
			}
		});
		return daysDto;
	}

	@GetMapping("/day/save")
	@ResponseBody
	public DayDto save(DayDto dayInDto) throws Exception {
		DayDto dayOutDto = null;
		if (dayInDto != null) {
			var dayIn = mapperFactory.convertDayDtoToDay(dayInDto);
			Day dayOut = manager.save(dayIn);
			dayOutDto = mapperFactory.convertDayToDayDto(dayOut);
		}
		return dayOutDto;
	}

	@GetMapping("/day/delete")
	@ResponseBody
<<<<<<< HEAD
	public Boolean delete(@RequestParam(value = "id", defaultValue = "0") long id) {
		manager.delete(id);
		return true;
=======
	public boolean delete(@RequestParam(value = "id", defaultValue = "0") long id) {
		return manager.delete(id);
>>>>>>> bb70fb99bc4a70fd3a386636e7ffff87fd07206c
	}

	@GetMapping("/day")
	@ResponseBody
	public String test() {
		return "Futur application randonnées : day";
	}

}