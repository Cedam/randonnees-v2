package org.cedam.application.randonnees.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

import org.cedam.application.randonnees.appconfig.AppConfigController;
import org.cedam.application.randonnees.dto.DayDto;
import org.cedam.application.randonnees.service.DayService;
import org.cedam.application.randonnees.test.mock.Constante;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = AppConfigController.class)
@SpringBootTest
public class DayControllerTest {

	@Autowired
	private DayController object;
	@Autowired
	private DayService dayService;
	
	@Test
	public void getByIdTest() throws Exception {
		long idDay = Constante.DAY_TEST_ID_1;
		DayDto day = object.getById(idDay);
		assertThat(idDay).isEqualTo(day.getId());
	}

	@Test
	public void getByAllByTrekIdTest()  {
		long idDay = Constante.TREK_TEST_ID_1;
		var days = object.getAllByTrekId(idDay);
		assertThat(days.size()).isGreaterThan(0);
		assertThat(days.get(0)).isNotNull();
	}
	
	@Test
	@Transactional
	public void saveTest() throws Exception {
		DayDto dayInDto = new DayDto();
		dayInDto.setNumber(Constante.DAY_TEST_NUMBER_1);
		dayInDto.setTrek(Constante.getTrekDto());
		// Test insert
		DayDto dayOutDto = object.save(dayInDto);
		assertThat(dayOutDto).isNotNull();

		// Test update
		dayInDto.setId(Constante.TREK_TEST_ID_1);
		dayOutDto = object.save(dayInDto);
		assertThat(dayOutDto.getId()).isEqualTo(Constante.TREK_TEST_ID_1);

		assertThrows(Exception.class, () -> { object.save(null);});
	}
	
	@Test
	@Transactional
	public void deleteTest() throws Exception  {
		var days = dayService.getAll();
		long id = days.get(days.size()-1).getId();
		object.delete(id);
		assertThat(object.getById(id)).isNull();
	}

	@Test
	public void testTest() {
		assertThat("Futur application randonnées : day").isEqualTo(object.test());
	}

}
