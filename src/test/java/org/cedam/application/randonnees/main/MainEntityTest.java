package org.cedam.application.randonnees.main;
import static org.assertj.core.api.Assertions.assertThat;

import org.cedam.application.randonnees.appconfig.AppConfigEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = AppConfigEntity.class)
@SpringBootTest
public class MainEntityTest {

	@Test
	public void testMain() {
		MainEntity instance = new MainEntity();
		instance.toString();
		
		MainEntity.main(null);
		assertThat(true).isTrue();
	}

}
