package org.cedam.application.randonnees.dao;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.cedam.application.randonnees.appconfig.AppConfigDao;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.test.mock.Constante;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(classes = AppConfigDao.class)
@SpringBootTest
public class DayDaoTest {

	@Autowired
	private DayDao object;


	@Test
	@Transactional
	public void saveTest() {
		Day dayResult = object.save(Constante.getDay());
		assertThat(dayResult).isNotNull();
		assertThat(dayResult.getId() > 0).isTrue();
	}

	@Test
	@Transactional
	public void findTest() {

		// Find a Day by ID
		Optional<Day> result = object.findById(Constante.DAY_TEST_ID_1);
		assertThat(result.isEmpty()).isFalse();
		assertThat(result.isPresent()).isTrue();

		// Find Day by last number
		List<Day> result2 = object.findByNumber(Constante.DAY_TEST_NUMBER_1);
		assertThat(result2.isEmpty()).isFalse();
		assertThat(result2.size() > 0).isTrue();

	}

}
