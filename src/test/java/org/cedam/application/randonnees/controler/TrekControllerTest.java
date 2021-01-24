package org.cedam.application.randonnees.controler;

import org.cedam.application.randonnees.appconfig.AppConfigController;
import org.cedam.application.randonnees.controller.TrekController;
import org.cedam.application.randonnees.dto.TrekDto;
import org.cedam.application.randonnees.entity.Trek;
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
public class TrekControllerTest {

	@Autowired
	private TrekController object;

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
		int idTrek = 0;
		Trek trek = object.getById(idTrek);
		Assert.assertEquals(idTrek, trek.getId());
	}

	@Test
	public void save() {
		int idTrek = 0;
		TrekDto trekDto = new TrekDto();
		trekDto.setId(idTrek);
		Trek trek = object.save(trekDto);
		Assert.assertEquals(idTrek, trek.getId());
		
		try {
			Trek trek2 = object.save(null);
			Assert.assertNull(trek2);
		} catch (Exception e) {
		}	
		
	}

	@Test
	public void testTest() {
		Assert.assertEquals("Futur application randonnées : trek.", object.test());
	}

}
