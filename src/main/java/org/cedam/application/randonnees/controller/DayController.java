package org.cedam.application.randonnees.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.ArrayList;
import java.util.List;

import org.cedam.application.randonnees.dto.DayDto;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.exception.InternalErrorRandonneesException;
import org.cedam.application.randonnees.exception.NotFoundRandonneesException;
import org.cedam.application.randonnees.service.DayService;
import org.cedam.application.randonnees.utils.UtilsMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;


@RestController
@RequestMapping("/days")
@Log4j2
public class DayController {

	//private static final Logger logger = LogManager.getLogger(DayController.class);

	@Autowired
	private DayService manager;

	@Autowired
	UtilsMapping utilsMapping;
    
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<DayDto> getById(@PathVariable(value = "id") long id) throws Exception {
		Day day = manager.getById(id);
		var dayDto = utilsMapping.convertDayToDayDto(day);
		
		if(dayDto==null)
		{
			throw new NotFoundRandonneesException(String.format("Aucun Day avec l'ID '%s'", id));
		}
		return ok(dayDto);
	}

	@GetMapping("/bytrekid/{id}")
	@ResponseBody
	public ResponseEntity<List<DayDto>> getByTrekId(@PathVariable(value = "id") long id) {
		var daysDto = new ArrayList<DayDto>();
		var days = manager.getListByTrekId(id);
		days.forEach(x -> {
			try {
				daysDto.add(utilsMapping.convertDayToDayDto(x));
			} catch (Exception e) {
				log.error("DayController.getAllByTrekId", e);
				throw new InternalErrorRandonneesException(e);
			}
		});
		return ok(daysDto);
	}

	@PostMapping("/save")
	@ResponseBody
	public ResponseEntity<DayDto> save(@RequestBody DayDto dayInDto) throws Exception {
		DayDto dayOutDto = null;
		try {
			var dayIn = utilsMapping.convertDayDtoToDay(dayInDto);
			Day dayOut = manager.save(dayIn);
			dayOutDto = utilsMapping.convertDayToDayDto(dayOut);
		} catch (Exception e) {
			log.error("DayController.save", e);
			throw new InternalErrorRandonneesException(e);
		}
		return ok(dayOutDto);
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Boolean> delete(@PathVariable(value = "id") long id) {
		manager.delete(id);
		return ok(true);
	}

}