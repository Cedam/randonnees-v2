package org.cedam.application.randonnees.controler;
import static org.assertj.core.api.Assertions.assertThat;

import org.cedam.application.randonnees.appconfig.AppConfigController;
import org.cedam.application.randonnees.controller.DayController;
import org.cedam.application.randonnees.dto.DayDto;
import org.cedam.application.randonnees.entity.Day;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = AppConfigController.class)
@SpringBootTest
public class DayControllerTest {

	@Autowired
	private DayController object;


	@Test
	public void getByIdTest() {
		int idDay = 0;
		Day day = object.getById(idDay);
		assertThat(idDay).isEqualTo(day.getId());
	}

	@Test
	public void save() {
		int idDay = 0;
		DayDto dayDto = new DayDto();
		dayDto.setId(idDay);
		Day day = object.save(dayDto);
		assertThat(idDay).isEqualTo(day.getId());
		
		try {
			Day day2 = object.save(null);
			assertThat(day2).isNull();
		} catch (Exception e) {
		}	
		
	}

	@Test
	public void testTest() {
		assertThat("Futur application randonnées : day").isEqualTo(object.test());
	}

}
