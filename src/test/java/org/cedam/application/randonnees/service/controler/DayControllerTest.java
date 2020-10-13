package org.cedam.application.randonnees.service.controler;

import org.cedam.application.randonnees.AppConfigService;
import org.cedam.application.randonnees.entityV6.Day;
import org.cedam.application.randonnees.service.controller.DayController;
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
@ContextConfiguration(classes = AppConfigService.class)
@SpringBootTest
public class DayControllerTest {

	@Autowired
	private DayController dayController;
	
	@Before
	public void setUp() throws Exception {}
	
	@After
	public void tearDown() throws Exception {}
	
	@Test
	public void getAllTest() {
		Assert.assertNotNull(dayController.getAll());
	}

	@Test
	public void getByIdTest() {
		int idDay = 0;
		Day day = dayController.getById(idDay);
		Assert.assertEquals(idDay, day.getId());
	}

	@Test
	public void save() {
		int idDay = 0;
		Day day = new Day();
		day.setId(idDay);
		day = dayController.save(day);
		Assert.assertEquals(idDay, day.getId());
	}

	@Test
	public void testTest() {
		Assert.assertEquals("Futur application randonnées : day", dayController.test());
	}

}
