package org.cedam.application.randonnees.dao;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.cedam.application.randonnees.appconfig.AppConfigDao;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.entity.Trek;
import org.cedam.application.randonnees.test.mock.Constante;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(classes = AppConfigDao.class)
@SpringBootTest
public class TrekDaoTest {

	@Autowired
	private TrekDao object;

	@Autowired
	private DayDao dayDao;

	@Test
	@Transactional
	public void testSave() {
		Trek trek = Constante.getTrek2();
		Trek trekResult = object.save(trek);
		assertThat(trekResult).isNotNull();
		assertThat(trekResult.getId()).isNotZero();

		Day day = dayDao.findAll().iterator().next();

		List<Day> listDays = new ArrayList<>();
		listDays.add(day);
		trek.setDays(listDays);
		trekResult = object.save(trek);
		assertThat(trekResult).isNotNull();
		assertThat(trekResult.getId()).isNotZero();
	}

	@Test
	@Transactional
	public void testFind() {

		// Find a Trek by ID
		Optional<Trek> result = object.findById(Constante.TREK_TEST_ID_1);
		assertThat(!result.isEmpty()).isTrue();
		assertThat(result.isPresent()).isTrue();

		// Find Trek by name
		List<Trek> result2 = object.findByName(Constante.TREK_TEST_NAME_1);
		assertThat(!result2.isEmpty()).isTrue();
		assertThat(result2.size()).isNotZero();

	}

}
