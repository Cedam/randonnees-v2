package org.cedam.application.randonnees.utils.mapper;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.cedam.application.randonnees.appconfig.AppConfigController;
import org.cedam.application.randonnees.dto.DayDto;
import org.cedam.application.randonnees.dto.TrekDto;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.entity.Trek;
import org.cedam.application.randonnees.test.mock.Constante;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(classes = AppConfigController.class)
@SpringBootTest
public class MapperFactoryTest {

	@Autowired
	private MapperFactory object;



	@Test
	@Transactional
	public void convertDayToDayDtoTest() {
		try {
			Day source = Constante.getDay();
			DayDto destination = object.convertDayToDayDto(source);
			assertThat(source.getId()).isEqualTo(destination.getId());
			assertThat(source.getNumber()).isEqualTo(destination.getNumber());
			assertThat(source.getTrek().getId()).isEqualTo(destination.getTrek().getId());
		} catch (Exception e) {
			fail("Mapping error");
		}
	}

	@Test
	@Transactional
	public void convertDayDtoToDayTest() {
		try {
			DayDto source = Constante.getDayDto();
			Day destination = object.convertDayDtoToDay(source);
			assertThat(source.getId()).isEqualTo(destination.getId());
			assertThat(source.getNumber()).isEqualTo(destination.getNumber());
			assertThat(source.getTrek().getId()).isEqualTo(destination.getTrek().getId());
		} catch (Exception e) {
			fail("Mapping error");
		}
	}
	
	@Test
	@Transactional
	public void convertTrekToTrekDtoTest() {
		try {
			Trek source = Constante.getTrek();
			TrekDto destination = object.convertTrekToTrekDto(source);
			assertThat(source.getId()).isEqualTo(destination.getId());
			assertThat(source.getName()).isEqualTo(destination.getName());
			assertThat(source.getYear()).isEqualTo(destination.getYear());
			assertThat(source.getLocation()).isEqualTo(destination.getLocation());
			assertThat(source.getDays()).isEqualTo(destination.getDays());
		} catch (Exception e) {
			fail("Mapping error");
		}
	}
	
	@Test
	@Transactional
	public void convertTrekDtoToTrekTest() {
		try {
			TrekDto source = Constante.getTrekDto();
			Trek destination = object.convertTrekDtoToTrek(source);
			assertThat(source.getId()).isEqualTo(destination.getId());
			assertThat(source.getName()).isEqualTo(destination.getName());
			assertThat(source.getYear()).isEqualTo(destination.getYear());
			assertThat(source.getLocation()).isEqualTo(destination.getLocation());
			assertThat(source.getDays()).isEqualTo(destination.getDays());
		} catch (Exception e) {
			fail("Mapping error");
		}
	}
}
