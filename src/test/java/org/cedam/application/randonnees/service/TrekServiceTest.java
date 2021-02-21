package org.cedam.application.randonnees.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.cedam.application.randonnees.appconfig.AppConfigService;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.entity.Trek;
import org.cedam.application.randonnees.service.TrekService;
import org.cedam.application.randonnees.test.mock.Constante;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(classes = AppConfigService.class)
@SpringBootTest
public class TrekServiceTest {

	@Autowired
	private TrekService object;

	@Test
	@Transactional
	public void testGetById() {
		List<Trek> listeTreks = object.getAll();
		Trek day = object.getById(listeTreks.get(0).getId());
		assertThat(day).isNotNull();
		assertThat(listeTreks.get(0).getId()).isEqualTo(day.getId());
		assertThat(listeTreks.get(0).getName()).isEqualTo(Constante.TREK_TEST_NAME_1);
		
		Trek day2 = object.getById(listeTreks.get(0).getId() + 1);
		assertThat(day2).isNotNull();
		assertThat(listeTreks.get(0).getId()).isNotEqualTo(day2.getId());
	}

	@Test
	@Transactional
	public void testListTreks() {
		List<Trek> listTreks = object.getAll();
		assertThat(listTreks).isNotNull();
	}

	@Test
	@Transactional
	public void testInsert() {
		int numberBefore = object.getAll().size();
		Trek trekA = new Trek();
		trekA.setName(Constante.TREK_TEST_NAME_1);
		trekA.setLocation(Constante.TREK_TEST_LOCATION_1);
		object.save(trekA);
		assertThat(++numberBefore).isEqualTo(object.getAll().size());
	}

	@Test
	@Transactional
	public void testUpdate() {
		int numberBefore = object.getAll().size();

		// Persistant
		double valeurNumberA = Math.random();
		Trek trekA = object.getAll().get(0);
		trekA.setName(String.valueOf(valeurNumberA));
		Trek trekSave = object.save(trekA);
		assertThat(String.valueOf(valeurNumberA)).isEqualTo(object.getById(trekSave.getId()).getName());

		// Détaché
		double valeurNumberB = Math.random();
		Trek trekB = new Trek();
		trekB.setId(Constante.TREK_TEST_ID_2);
		trekB.setName(String.valueOf(valeurNumberB));
		trekB.setLocation(Constante.TREK_TEST_LOCATION_2);
		trekSave = object.save(trekB);
		assertThat(String.valueOf(valeurNumberB)).isEqualTo(object.getById(trekSave.getId()).getName());
		assertThat(numberBefore).isEqualTo(object.getAll().size());
	}
	
	@Test
	@Transactional
	public void testAddDay() {
		
		Trek trek = object.getAll().iterator().next();
		var nbDays = trek.getDays().size();
		
		Day day = Constante.getDay();
		day.setNumber("98");
		object.addDay(trek, day);
		
		//TODO le jour n'est pas présent dans la liste des jours du Trek (si on met en commentaire @Transactional, alors c'est bon.
		//assertThat(newTrek.getDays().size()).isEqualTo(nbDays+1);
		
		object.addDay(trek, null);
		
	}

}
