package org.cedam.application.randonnees;
import static org.assertj.core.api.Assertions.assertThat;

import org.cedam.application.randonnees.appconfig.AppConfigService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(classes = AppConfigService.class)
@SpringBootTest
public class SpringAppTest {

	@Test
	@Transactional
	public void testMain() {
		SpringApp springApp = new SpringApp();
		springApp.toString();
		
		SpringApp.main(null);
		assertThat(true).isTrue();
	}

}
