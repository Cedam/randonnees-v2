package org.cedam.application.randonnees.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cedam.application.randonnees.controller.exceptions.InternalErrorRandonneesException;
import org.cedam.application.randonnees.controller.exceptions.NotFoundRandonneesException;
import org.cedam.application.randonnees.dto.DayDto;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.service.DayService;
import org.cedam.application.randonnees.utils.mapper.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/days")
public class DayController {

	private static final Logger logger = LogManager.getLogger(DayController.class);

	@Autowired
	private DayService manager;

	@Autowired
	MapperFactory mapperFactory;

    
	@GetMapping("/id")
	@ResponseBody
	public ResponseEntity<DayDto> getById(@RequestParam(value = "id", defaultValue = "0") long id) throws Exception {
		Day day = manager.getById(id);
		var dayDto = mapperFactory.convertDayToDayDto(day);
		
		if(dayDto==null)
		{
			throw new NotFoundRandonneesException(String.format("Aucun Day avec l'ID '%s'", id));
		}
		return ok(dayDto);
	}

	@GetMapping("/bytrekid")
	@ResponseBody
	public ResponseEntity<List<DayDto>> getAllByTrekId(@RequestParam(value = "id", defaultValue = "0") long id) {
		var daysDto = new ArrayList<DayDto>();
		var days = manager.getListByTrekId(id);
		days.forEach(x -> {
			try {
				daysDto.add(mapperFactory.convertDayToDayDto(x));
			} catch (Exception e) {
				logger.error("DayController.getAllByTrekId", e);
				throw new InternalErrorRandonneesException(e);
			}
		});
		return ok(daysDto);
	}

	@PostMapping("/")
	@ResponseBody
	public ResponseEntity<DayDto> save(DayDto dayInDto) throws Exception {
		DayDto dayOutDto = null;
		var dayIn = mapperFactory.convertDayDtoToDay(dayInDto);
		Day dayOut = manager.save(dayIn);
		dayOutDto = mapperFactory.convertDayToDayDto(dayOut);
		return ok(dayOutDto);
	}

	@DeleteMapping("/id")
	@ResponseBody
	public ResponseEntity<Boolean> delete(@RequestParam(value = "id", defaultValue = "0") long id) {
		manager.delete(id);
		return ok(true);
	}

	@GetMapping("/test")
	@ResponseBody
	public ResponseEntity<String> test() {
		return ok("Futur application randonnées : day");
	}

}