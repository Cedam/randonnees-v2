package org.cedam.application.randonnees.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.ArrayList;
import java.util.List;

import org.cedam.application.randonnees.dto.TrekDto;
import org.cedam.application.randonnees.entity.Trek;
import org.cedam.application.randonnees.exception.InternalErrorRandonneesException;
import org.cedam.application.randonnees.exception.RequiredAttributException;
import org.cedam.application.randonnees.service.TrekService;
import org.cedam.application.randonnees.utils.UtilsMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/treks")
@Log4j2
public class TrekController {

	@Autowired
	private TrekService manager;

	@Autowired
	UtilsMapping utilsMapping;

	@GetMapping("")
	@ResponseBody
	public ResponseEntity<List<TrekDto>> getAll() {
		var treksDto = new ArrayList<TrekDto>();
		var treks = manager.getAll();
		treks.forEach(x -> {
			try {
				treksDto.add(utilsMapping.convertTrekToTrekDto(x));
			} catch (Exception e) {
				log.error("UtilsMapping.convertTrekToTrekDto", e);
				throw new InternalErrorRandonneesException(e);
			}
		});
		return ok(treksDto);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<TrekDto> getById(@PathVariable(value = "id") long id) throws Exception {
		Trek trek = manager.getById(id);
		var trekDto = utilsMapping.convertTrekToTrekDto(trek);
		if (trekDto == null) {
			throw new RequiredAttributException(String.format("Aucun Trek avec l'ID '%x'", id));
		}
		return ok(trekDto);
	}

	@GetMapping("byname/{name}")
	@ResponseBody
	public ResponseEntity<TrekDto> getByName(@PathVariable(value = "name") String name) throws Exception {
		Trek trek = manager.getByName(name);
		var trekDto = utilsMapping.convertTrekToTrekDto(trek);
		if (trekDto == null) {
			throw new RequiredAttributException(String.format("Aucun Trek avec le nom '%s'", name));
		}
		return ok(trekDto);
	}

	@PostMapping("/save")
	@ResponseBody
	public ResponseEntity<TrekDto> save(@RequestBody TrekDto trekDto) throws Exception {
		TrekDto trekOutDto = null;
		try {
			Trek trek = manager.save(utilsMapping.convertTrekDtoToTrek(trekDto));
			trekOutDto = utilsMapping.convertTrekToTrekDto(trek);
		} catch (Exception e) {
			log.error("TrekController.save", e);
			throw new InternalErrorRandonneesException(e);
		}
		return ok(trekOutDto);
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Boolean> delete(@PathVariable(value = "id") long id) {
		manager.delete(id);
		return ok(true);
	}

}