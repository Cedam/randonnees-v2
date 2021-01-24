package org.cedam.application.randonnees.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.cedam.application.randonnees.appconfig.AppConfigDao;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.entity.Trek;
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
public class TrekDaoTest {

	@Autowired
	private TrekDao object;

	@Autowired
	private DayDao dayDao;

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
	public void SaveTest() {
		Trek trek = ConstanteTest.getTrek2();
		Trek trekResult = object.save(trek);
		Assert.assertTrue(trekResult != null);
		Assert.assertTrue(trekResult.getId() > 0);

		Day day = dayDao.findAll().iterator().next();

		List<Day> listDays = new ArrayList<Day>();
		listDays.add(day);
		trek.setDays(listDays);
		trekResult = object.save(trek);
		Assert.assertTrue(trekResult != null);
		Assert.assertTrue(trekResult.getId() > 0);
	}

	@Test
	@Transactional
	public void FindTest() {

		// Find a Trek by ID
		Optional<Trek> result = object.findById(ConstanteTest.TREK_TEST_ID_1);
		Assert.assertTrue(!result.isEmpty());
		Assert.assertTrue(result.isPresent());

		// Find Trek by name
		List<Trek> result2 = object.findByName(ConstanteTest.TREK_TEST_NAME_1);
		Assert.assertTrue(!result2.isEmpty());
		Assert.assertTrue(result2.size() > 0);

	}

}
