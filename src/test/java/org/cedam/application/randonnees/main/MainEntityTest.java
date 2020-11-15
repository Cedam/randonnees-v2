package org.cedam.application.randonnees.main;

import org.cedam.application.randonnees.appconfig.AppConfigEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfigEntity.class)
@SpringBootTest
public class MainEntityTest {

		
		@Test
		public void testGetById() {
			MainEntity.PourTest(null);
		}
		
		
}
