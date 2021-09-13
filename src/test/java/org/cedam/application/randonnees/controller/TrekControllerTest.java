package org.cedam.application.randonnees.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

import org.cedam.application.randonnees.appconfig.AppConfigController;
import org.cedam.application.randonnees.dto.TrekDto;
import org.cedam.application.randonnees.test.mock.Constante;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = AppConfigController.class)
@SpringBootTest
public class TrekControllerTest {

	@Autowired
	private TrekController object;

	@Test
	public void testGetAll() {
		assertThat(object.getAll()).isNotNull();
	}

	@Test
	public void testGetById() throws Exception {
		long idTrek = Constante.TREK_TEST_ID_1;
		ResponseEntity<TrekDto> trek = object.getById(idTrek);
		assertThat(idTrek).isEqualTo(trek.getBody().getId());
	}

	@Test
	@Transactional
	public void testSave() throws Exception {
		TrekDto trekInDto = new TrekDto();
		trekInDto.setLocation(Constante.TREK_TEST_LOCATION_1);
		trekInDto.setName(Constante.TREK_TEST_NAME_1);

		// Test insert
		ResponseEntity<TrekDto> trekOutDto = object.save(trekInDto);
		assertThat(trekOutDto).isNotNull();

		// Test update
		trekInDto.setId(Constante.TREK_TEST_ID_1);
		trekOutDto = object.save(trekInDto);
		assertThat(Constante.TREK_TEST_ID_1).isEqualTo(trekOutDto.getBody().getId());

		assertThrows(Exception.class, () -> object.save(null));
	}

	@Test
	@Transactional
	public void testDelete() throws Exception {
		var treks = object.getAll();
		long id = treks.getBody().get(treks.getBody().size() - 1).getId();
		object.delete(id);
		assertThrows(Exception.class, () -> object.getById(id));
	}


}
