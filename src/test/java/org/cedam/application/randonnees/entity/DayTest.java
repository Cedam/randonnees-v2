package org.cedam.application.randonnees.entity;

import org.cedam.application.randonnees.appconfig.AppConfigDao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfigDao.class)
@SpringBootTest
public class DayTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Transactional
	public void Test() {
		var id = 1;
		var number = "number";
		var trekDto = new Trek();

		var dayDto = new Day();
		dayDto.setId(id);
		dayDto.setNumber(number);
		dayDto.setTrek(trekDto);

		Assert.assertEquals(id, dayDto.getId());
		Assert.assertEquals(number, dayDto.getNumber());
		Assert.assertEquals(trekDto, dayDto.getTrek());
	}

}
