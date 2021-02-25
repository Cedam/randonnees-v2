package org.cedam.application.randonnees.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cedam.application.randonnees.controller.exceptions.InternalErrorRandonneesException;
import org.cedam.application.randonnees.controller.exceptions.NotFoundRandonneesException;
import org.cedam.application.randonnees.dto.TrekDto;
import org.cedam.application.randonnees.entity.Trek;
import org.cedam.application.randonnees.service.TrekService;
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
@RequestMapping("/treks")
public class TrekController {

	private static final Logger logger = LogManager.getLogger(TrekController.class);

	@Autowired
	private TrekService manager;

	@Autowired
	MapperFactory mapperFactory;

	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<List<TrekDto>> getAll() {
		var treksDto = new ArrayList<TrekDto>();
		var treks = manager.getAll();
		treks.forEach(x -> {
			try {
				treksDto.add(mapperFactory.convertTrekToTrekDto(x));
			} catch (Exception e) {
				logger.error("DayController.getAllByTrekId", e);
				throw new InternalErrorRandonneesException(e);
			}
		});

		return ok(treksDto);
	}

	@GetMapping("/id")
	@ResponseBody
	public ResponseEntity<TrekDto> getById(@RequestParam(value = "id", defaultValue = "0") long id) throws Exception {
		Trek trek = manager.getById(id);
		
		var trekDto = mapperFactory.convertTrekToTrekDto(trek);
		if(trekDto==null)
		{
			throw new NotFoundRandonneesException(String.format("Aucun Trek avec l'ID '%s'", id));
		}
		
		return ok(trekDto);
	}

	@PostMapping("/")
	@ResponseBody
	public ResponseEntity<TrekDto> save(TrekDto trekInDto) throws Exception {
		TrekDto trekOutDto = null;
			Trek trek = manager.save(mapperFactory.convertTrekDtoToTrek(trekInDto));
			trekOutDto = mapperFactory.convertTrekToTrekDto(trek);
		return ok(trekOutDto);
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
		return ok("Futur application randonnées : trek.");
	}

}