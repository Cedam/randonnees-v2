package org.cedam.application.randonnees.main;
import static org.assertj.core.api.Assertions.assertThat;

import org.cedam.application.randonnees.appconfig.AppConfigBusiness;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(classes = AppConfigBusiness.class)
@SpringBootTest
public class MainBusinessTest {

	@Test
	@Transactional
	public void mainTest() {
		MainBusiness.main(null);
		assertThat(true).isTrue();
	}

}
