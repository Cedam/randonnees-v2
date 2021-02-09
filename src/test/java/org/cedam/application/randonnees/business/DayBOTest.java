package org.cedam.application.randonnees.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.cedam.application.randonnees.appconfig.AppConfigBusiness;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.test.mock.Constante;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(classes = AppConfigBusiness.class)
@SpringBootTest
public class DayBOTest {

	@Autowired
	private DayBusiness object;


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
	public void testListDays() {
		List<Day> listDays = object.getAll();
		assertThat(listDays).isNotNull();
	}

	@Test
	@Transactional
	public void testInsert() {
		int numberBefore = object.getAll().size();
		object.save(Constante.getDay());
		assertThat(++numberBefore).isEqualTo(object.getAll().size());
	}

	@Test
	@Transactional
	public void testUpdate() {
		int numberBefore = object.getAll().size();

		// Persistant
		double valeurNumberA = Math.random();
		Day dayA = object.getAll().get(0);
		dayA.setNumber(String.valueOf(valeurNumberA));
		Day daySave = object.save(dayA);
		assertThat(String.valueOf(valeurNumberA)).isEqualTo(object.getById(daySave.getId()).getNumber());

		// Détaché
		double valeurNumberB = Math.random();
		Day dayB = new Day();
		dayB.setId(Constante.DAY_TEST_ID_2);
		dayB.setNumber(String.valueOf(valeurNumberB));
		dayB.setTrek(Constante.getTrek());
		daySave = object.save(dayB);
		assertThat(String.valueOf(valeurNumberB)).isEqualTo(object.getById(daySave.getId()).getNumber());
		assertThat(numberBefore).isEqualTo(object.getAll().size());
	}
}
