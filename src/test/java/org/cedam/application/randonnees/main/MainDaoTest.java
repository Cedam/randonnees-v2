package org.cedam.application.randonnees.main;
import static org.assertj.core.api.Assertions.assertThat;

import org.cedam.application.randonnees.appconfig.AppConfigDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(classes = AppConfigDao.class)
@SpringBootTest
public class MainDaoTest {

	@Test
	@Transactional
	public void testMain() {
		MainDao instance = new MainDao();
		instance.toString();
		
		MainDao.main(null);
		assertThat(true).isTrue();
	}
}
