package org.cedam.application.randonnees.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cedam.application.randonnees.dto.DayDto;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.service.DayService;
import org.cedam.application.randonnees.utils.mapper.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/days")
public class DayController {

	private static final Logger logger = LogManager.getLogger(DayController.class);

	@Autowired
	private DayService manager;

	@Autowired
	MapperFactory mapperFactory;

//TODO DCO : Gestion retour REST et Exception 'ElementInexistantException'
//    @GetMapping("/all")
//    public ResponseEntity<List<User>> findAllUsersList() {
//        return ok(userService.findAllList());
//    }
    
	@GetMapping("/id")
	@ResponseBody
	public DayDto getById(@RequestParam(value = "id", defaultValue = "0") long id) throws Exception {
		Day day = manager.getById(id);
		return mapperFactory.convertDayToDayDto(day);
	}

	@GetMapping("/bytrekid")
	@ResponseBody
	public List<DayDto> getAllByTrekId(@RequestParam(value = "id", defaultValue = "0") long id) {
		var daysDto = new ArrayList<DayDto>();
		var days = manager.getAll();
		//TODO DCO : recherche Days par Trek
		days.forEach(x -> {
			try {
				daysDto.add(mapperFactory.convertDayToDayDto(x));
			} catch (Exception e) {
				logger.error("DayController.getAllByTrekId", e);
			}
		});
		return daysDto;
	}

	@PostMapping("/")
	@ResponseBody
	public DayDto save(DayDto dayInDto) throws Exception {
		DayDto dayOutDto = null;
		var dayIn = mapperFactory.convertDayDtoToDay(dayInDto);
		Day dayOut = manager.save(dayIn);
		dayOutDto = mapperFactory.convertDayToDayDto(dayOut);
		return dayOutDto;
	}

	@DeleteMapping("/id")
	@ResponseBody
	public Boolean delete(@RequestParam(value = "id", defaultValue = "0") long id) {
		manager.delete(id);
		return true;
	}

	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return "Futur application randonnées : day";
	}

}