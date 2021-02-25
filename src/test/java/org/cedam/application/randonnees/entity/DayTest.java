package org.cedam.application.randonnees.entity;
import static org.assertj.core.api.Assertions.assertThat;

import org.cedam.application.randonnees.appconfig.AppConfigDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(classes = AppConfigDao.class)
@SpringBootTest
public class DayTest {

	@Test
	@Transactional
	public void test() {
		var id = 1;
		var number = "number";
		var trekDto = new Trek();

		var dayDto = new Day();
		dayDto.setId(id);
		dayDto.setNumber(number);
		dayDto.setTrek(trekDto);

		assertThat(id).isEqualTo(dayDto.getId());
		assertThat(number).isEqualTo(dayDto.getNumber());
		assertThat(trekDto).isEqualTo(dayDto.getTrek());
	}

}
