package org.cedam.application.randonnees.dto;

import java.util.ArrayList;

import org.cedam.application.randonnees.appconfig.AppConfigDao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfigDao.class)
@SpringBootTest
public class TrekDtoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

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

		Assert.assertEquals(id, trekDto.getId());
		Assert.assertEquals(name, trekDto.getName());
		Assert.assertEquals(location, trekDto.getLocation());
		Assert.assertEquals(year, trekDto.getYear());
		Assert.assertEquals(location, trekDto.getLocation());
		Assert.assertEquals(daysDto, trekDto.getDays());
	}

}
