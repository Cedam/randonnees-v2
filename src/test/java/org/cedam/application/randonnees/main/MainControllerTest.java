package org.cedam.application.randonnees.main;

import org.cedam.application.randonnees.appconfig.AppConfigController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfigController.class)
@SpringBootTest
public class MainControllerTest {

	@Test
	@Transactional
	public void mainTest() {
		MainController.main(null);
		Assert.assertTrue(true);
	}

}
