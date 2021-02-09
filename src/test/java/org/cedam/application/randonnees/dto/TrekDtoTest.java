package org.cedam.application.randonnees.dto;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.cedam.application.randonnees.appconfig.AppConfigDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(classes = AppConfigDao.class)
@SpringBootTest
public class TrekDtoTest {


	@Test
	@Transactional
	public void Test() {
		var id = 1;
		var name = "name";
		var year = 99;
		var location = "location";
		var daysDto = new ArrayList<DayDto>();
		daysDto.add(new DayDto());

		var trekDto = new TrekDto();
		trekDto.setId(id);
		trekDto.setName(name);
		trekDto.setYear(year);
		trekDto.setLocation(location);
		trekDto.setDays(daysDto);

		assertThat(id).isEqualTo(trekDto.getId());
		assertThat(name).isEqualTo(trekDto.getName());
		assertThat(location).isEqualTo(trekDto.getLocation());
		assertThat(year).isEqualTo(trekDto.getYear());
		assertThat(location).isEqualTo(trekDto.getLocation());
		assertThat(daysDto).isEqualTo(trekDto.getDays());
	}

}
