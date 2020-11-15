package org.cedam.application.randonnees.main;

import org.cedam.application.randonnees.appconfig.AppConfigService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfigService.class)
@SpringBootTest
public class MainServiceTest {

		
		@Test
		@Transactional
		public void testGetById() {
			MainService.PourTest(null);
		}
		
		
}
