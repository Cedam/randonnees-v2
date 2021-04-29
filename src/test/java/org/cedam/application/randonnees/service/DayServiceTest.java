package org.cedam.application.randonnees.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.cedam.application.randonnees.appconfig.AppConfigService;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.test.mock.Constante;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(classes = AppConfigService.class)
@SpringBootTest
public class DayServiceTest {

	@Autowired
	private DayService object;

	@Test
	@Transactional
	public void testGetAll() {
		List<Day> listDays = object.getAll();
		assertThat(listDays).isNotNull();
	}
	
	@Test
	@Transactional
	public void testGetById() {
		List<Day> listeDays = object.getAll();
		Day day = object.getById(listeDays.get(0).getId());
		assertThat(day).isNotNull();
		assertThat(listeDays.get(0).getId()).isEqualTo(day.getId());

		Day day2 = object.getById(listeDays.get(0).getId() + 1);
		assertThat(day2).isNotNull();
		assertThat(listeDays.get(0).getId()).isNotEqualTo(day2.getId());
	}

	@Test
	@Transactional
	public void testGetListByTrekId() {
		List<Day> listDays = object.getListByTrekId(Constante.TREK_TEST_ID_1);
		assertThat(listDays.size()).isPositive();
		listDays.forEach(x -> {
			if(x.getTrek().getId()!=Constante.TREK_TEST_ID_1)
			{
				fail(String.format("Incorrect TrekId (%s) for the Day %s", x.getTrek().getId(), x.getId()));
			}
			
		});
		
		List<Day> listDays2 = object.getListByTrekId((long) -1);
		assertThat(listDays2.size()).isZero();
	}
	
	@Test
	@Transactional
	public void testSave() {
		int numberBefore = object.getAll().size();
		object.save(Constante.getDay());
		assertThat(++numberBefore).isEqualTo(object.getAll().size());
	}

	@Test
	@Transactional
	public void testDelete() {
		var days = object.getAll();
		long id = days.get(days.size()-1).getId();
		object.delete(id);
		assertThat(object.getById(id)).isNull();
	}
	
	@Test
	@Transactional
	public void testUpdate() {
		int numberBefore = object.getAll().size();

		// Persistant
		String valeurNumberA = String.valueOf(Math.random());
		Day dayA = object.getAll().get(0);
		dayA.setNumber(valeurNumberA);
		Day daySave = object.save(dayA);
		assertThat(valeurNumberA).isEqualTo(object.getById(daySave.getId()).getNumber());

		// Detache
		String valeurNumberB = String.valueOf(Math.random());
		Day dayB = new Day();
		dayB.setId(Constante.DAY_TEST_ID_2);
		dayB.setNumber(valeurNumberB);
		dayB.setTrek(Constante.getTrek());
		daySave = object.save(dayB);
		assertThat(valeurNumberB).isEqualTo(object.getById(daySave.getId()).getNumber());
		assertThat(numberBefore).isEqualTo(object.getAll().size());
	}
	
	
}
