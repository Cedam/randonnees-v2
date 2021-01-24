package org.cedam.application.randonnees.controler;

import org.cedam.application.randonnees.appconfig.AppConfigController;
import org.cedam.application.randonnees.controller.DayController;
import org.cedam.application.randonnees.dto.DayDto;
import org.cedam.application.randonnees.entity.Day;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfigController.class)
@SpringBootTest
public class DayControllerTest {

	@Autowired
	private DayController object;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getAllTest() {
		Assert.assertNotNull(object.getAll());
	}

	@Test
	public void getByIdTest() {
		int idDay = 0;
		Day day = object.getById(idDay);
		Assert.assertEquals(idDay, day.getId());
	}

	@Test
	public void save() {
		int idDay = 0;
		DayDto dayDto = new DayDto();
		dayDto.setId(idDay);
		Day day = object.save(dayDto);
		Assert.assertEquals(idDay, day.getId());
		
		try {
			Day day2 = object.save(null);
			Assert.assertNull(day2);
		} catch (Exception e) {
		}	
		
	}

	@Test
	public void testTest() {
		Assert.assertEquals("Futur application randonnées : day", object.test());
	}

}
