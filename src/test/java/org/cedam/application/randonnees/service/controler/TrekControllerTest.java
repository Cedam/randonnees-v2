package org.cedam.application.randonnees.service.controler;

import org.cedam.application.randonnees.AppConfigService;
import org.cedam.application.randonnees.entityV6.Trek;
import org.cedam.application.randonnees.service.controller.TrekController;
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
public class TrekControllerTest {

	@Autowired
	private TrekController trekController;
	
	@Before
	public void setUp() throws Exception {}
	
	@After
	public void tearDown() throws Exception {}
	
	@Test
	public void getAllTest() {
		Assert.assertNotNull(trekController.getAll());
	}

	@Test
	public void getByIdTest() {
		int idTrek = 0;
		Trek trek = trekController.getById(idTrek);
		Assert.assertEquals(idTrek, trek.getId());
	}

	@Test
	public void save() {
		int idTrek = 0;
		Trek trek = new Trek();
		trek.setId(idTrek);
		trek = trekController.save(trek);
		Assert.assertEquals(idTrek, trek.getId());
	}
	
	@Test
	public void testTest() {
		Assert.assertEquals("Futur application randonnées : trek", trekController.test());
	}

}
