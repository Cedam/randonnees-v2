package org.cedam.application.randonnees.controler;

import org.cedam.application.randonnees.appconfig.AppConfigController;
import org.cedam.application.randonnees.controller.DayController;
import org.cedam.application.randonnees.controller.DefaultController;
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
public class DefaultControllerTest {

	@Autowired
	private DefaultController object;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void welcomeTest() {
		
		Assert.assertNotNull(object.welcome());
	}


}
