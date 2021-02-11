package org.cedam.application.randonnees.controller;
import static org.assertj.core.api.Assertions.assertThat;

import org.cedam.application.randonnees.appconfig.AppConfigController;
import org.cedam.application.randonnees.dto.TrekDto;
import org.cedam.application.randonnees.test.mock.Constante;
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
	public void getByIdTest() throws Exception {
		long idTrek = Constante.TREK_TEST_ID_1;
		TrekDto trek = object.getById(idTrek);
		assertThat(idTrek).isEqualTo(trek.getId());
	}

	@Test
	public void saveTest() throws Exception {
		TrekDto trekInDto = new TrekDto();
		trekInDto.setLocation(Constante.TREK_TEST_LOCATION_1);
		trekInDto.setName(Constante.TREK_TEST_NAME_1);
		
		//Test insert
		TrekDto trekOutDto = object.save(trekInDto);
		assertThat(trekOutDto).isNotNull();
		
		//Test update
		trekInDto.setId(Constante.TREK_TEST_ID_1);
		trekOutDto = object.save(trekInDto);
		assertThat(trekOutDto.getId()).isEqualTo(Constante.TREK_TEST_ID_1);
		
		try {
			trekOutDto = object.save(null);
			assertThat(trekOutDto).isNull();
		} catch (Exception e) {
			//Normal
		}	
		
	}

	@Test
	public void testTest() {
		assertThat("Futur application randonnées : trek.").isEqualTo(object.test());
	}

}
