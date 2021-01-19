package org.cedam.application.randonnees.main;

import org.cedam.application.randonnees.appconfig.AppConfigEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfigEntity.class)
@SpringBootTest
public class MainEntityTest {

	@Test
	public void todo() {
		Assert.assertTrue(true);
	}

}
