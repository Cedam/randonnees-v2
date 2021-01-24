package org.cedam.application.randonnees.dao;

import java.util.List;
import java.util.Optional;

import org.cedam.application.randonnees.appconfig.AppConfigDao;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.test.mock.ConstanteTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfigDao.class)
@SpringBootTest
public class DayDaoTest {

	@Autowired
	private DayDao object;

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
	public void saveTest() {
		Day dayResult = object.save(ConstanteTest.getDay());
		Assert.assertTrue(dayResult != null);
		Assert.assertTrue(dayResult.getId() > 0);
	}

	@Test
	@Transactional
	public void dindTest() {

		// Find a Day by ID
		Optional<Day> result = object.findById(ConstanteTest.DAY_TEST_ID_1);
		Assert.assertTrue(!result.isEmpty());
		Assert.assertTrue(result.isPresent());

		// Find Day by last number
		List<Day> result2 = object.findByNumber(ConstanteTest.DAY_TEST_NUMBER_1);
		Assert.assertTrue(!result2.isEmpty());
		Assert.assertTrue(result2.size() > 0);

	}

}
