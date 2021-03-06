package org.cedam.application.randonnees.controller;
import static org.assertj.core.api.Assertions.assertThat;

import org.cedam.application.randonnees.appconfig.AppConfigController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = AppConfigController.class)
@SpringBootTest
public class DefaultControllerTest {

	@Autowired
	private DefaultController object;
	
	@Test
	public void testWelcome() {
		
		assertThat(object.welcome()).isNotNull();
	}


}
