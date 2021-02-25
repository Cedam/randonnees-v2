package org.cedam.application.randonnees.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

import org.cedam.application.randonnees.appconfig.AppConfigController;
import org.cedam.application.randonnees.controller.exceptions.NotFoundRandonneesException;
import org.cedam.application.randonnees.dto.DayDto;
import org.cedam.application.randonnees.service.DayService;
import org.cedam.application.randonnees.test.mock.Constante;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = AppConfigController.class)
@SpringBootTest
public class DayControllerTest {

	@Autowired
	private DayController object;
	@Autowired
	private DayService dayService;
	
	@Test
	public void testGetById() throws Exception {
		long idDay = Constante.DAY_TEST_ID_1;
		ResponseEntity<DayDto> day = object.getById(idDay);
		assertThat(idDay).isEqualTo(day.getBody().getId());
		
		assertThrows(NotFoundRandonneesException.class, () -> { object.getById(-1);});
	}

	@Test
	public void testGetAllByTrekId()  {
		long idDay = Constante.TREK_TEST_ID_1;
		var days = object.getAllByTrekId(idDay);
		assertThat(days.getBody().size()).isNotZero();
		assertThat(days.getBody().get(0)).isNotNull();
	}
	
	@Test
	@Transactional
	public void testSave() throws Exception {
		DayDto dayInDto = new DayDto();
		dayInDto.setNumber(Constante.DAY_TEST_NUMBER_1);
		dayInDto.setTrek(Constante.getTrekDto());
		// Test insert
		ResponseEntity<DayDto> dayOutDto = object.save(dayInDto);
		assertThat(dayOutDto).isNotNull();

		// Test update
		dayInDto.setId(Constante.TREK_TEST_ID_1);
		dayOutDto = object.save(dayInDto);
		assertThat(dayOutDto.getBody().getId()).isEqualTo(Constante.TREK_TEST_ID_1);

		assertThrows(Exception.class, () -> { object.save(null);});
	}
	
	@Test
	@Transactional
	public void testDelete() throws Exception  {
		var days = dayService.getAll();
		long id = days.get(days.size()-1).getId();
		object.delete(id);
		assertThrows(Exception.class, () -> { object.getById(id); });
	}

	@Test
	public void testTest() {
		assertThat("Futur application randonnées : day").isEqualTo(object.test().getBody());
	}

}
