package org.cedam.application.randonnees.utils.mapper;

import org.cedam.application.randonnees.appconfig.AppConfigController;
import org.cedam.application.randonnees.dto.DayDto;
import org.cedam.application.randonnees.dto.TrekDto;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.entity.Trek;
import org.cedam.application.randonnees.test.mock.Constante;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfigController.class)
@SpringBootTest
public class MapperFactoryTest {

	@Autowired
	private MapperFactory object;

	
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
	public void convertDayToDayDtoTest() {
		try {
			Day source = Constante.getDay();
			DayDto destination = object.convertDayToDayDto(source);
			Assert.assertEquals(source.getId(), destination.getId());
			Assert.assertEquals(source.getNumber(), destination.getNumber());
			Assert.assertEquals(source.getTrek().getId(), destination.getTrek().getId());
		} catch (Exception e) {
			Assert.fail("Mapping error");
		}
	}

	@Test
	@Transactional
	public void convertDayDtoToDayTest() {
		try {
			DayDto source = Constante.getDayDto();
			Day destination = object.convertDayDtoToDay(source);
			Assert.assertEquals(source.getId(), destination.getId());
			Assert.assertEquals(source.getNumber(), destination.getNumber());
			Assert.assertEquals(source.getTrek().getId(), destination.getTrek().getId());
		} catch (Exception e) {
			Assert.fail("Mapping error");
		}
	}
	
	@Test
	@Transactional
	public void convertTrekToTrekDtoTest() {
		try {
			Trek source = Constante.getTrek();
			TrekDto destination = object.convertTrekToTrekDto(source);
			Assert.assertEquals(source.getId(), destination.getId());
			Assert.assertEquals(source.getName(), destination.getName());
			Assert.assertEquals(source.getYear(), destination.getYear());
			Assert.assertEquals(source.getLocation(), destination.getLocation());
			Assert.assertEquals(source.getDays(), destination.getDays());
		} catch (Exception e) {
			Assert.fail("Mapping error");
		}
	}
	
	@Test
	@Transactional
	public void convertTrekDtoToTrekTest() {
		try {
			TrekDto source = Constante.getTrekDto();
			Trek destination = object.convertTrekDtoToTrek(source);
			Assert.assertEquals(source.getId(), destination.getId());
			Assert.assertEquals(source.getName(), destination.getName());
			Assert.assertEquals(source.getYear(), destination.getYear());
			Assert.assertEquals(source.getLocation(), destination.getLocation());
			Assert.assertEquals(source.getDays(), destination.getDays());
		} catch (Exception e) {
			Assert.fail("Mapping error");
		}
	}
}
