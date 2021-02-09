package org.cedam.application.randonnees.controler;
import static org.assertj.core.api.Assertions.assertThat;

import org.cedam.application.randonnees.appconfig.AppConfigController;
import org.cedam.application.randonnees.controller.TrekController;
import org.cedam.application.randonnees.dto.TrekDto;
import org.cedam.application.randonnees.entity.Trek;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = AppConfigController.class)
@SpringBootTest
public class TrekControllerTest {

	@Autowired
	private TrekController object;

	@Test
	public void getAllTest() {
		assertThat(object.getAll()).isNotNull();
	}

	@Test
	public void getByIdTest() {
		int idTrek = 0;
		Trek trek = object.getById(idTrek);
		assertThat(idTrek).isEqualTo(trek.getId());
	}

	@Test
	public void saveTest() {
		int idTrek = 0;
		TrekDto trekDto = new TrekDto();
		trekDto.setId(idTrek);
		Trek trek = object.save(trekDto);
		assertThat(idTrek).isEqualTo(trek.getId());
		
		try {
			Trek trek2 = object.save(null);
			assertThat(trek2).isNull();
		} catch (Exception e) {
		}	
		
	}

	@Test
	public void testTest() {
		assertThat("Futur application randonnées : trek.").isEqualTo(object.test());
	}

}
