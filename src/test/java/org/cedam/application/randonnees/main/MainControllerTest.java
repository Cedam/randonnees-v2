package org.cedam.application.randonnees.main;
import static org.assertj.core.api.Assertions.assertThat;

import org.cedam.application.randonnees.appconfig.AppConfigController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(classes = AppConfigController.class)
@SpringBootTest
public class MainControllerTest {

	@Test
	@Transactional
	public void testMain() {
		MainController.main(null);
		assertThat(true).isTrue();
	}

}
