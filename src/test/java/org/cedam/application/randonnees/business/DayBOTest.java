package org.cedam.application.randonnees.business;

import java.util.List;

import org.cedam.application.randonnees.appconfig.AppConfigBusiness;
import org.cedam.application.randonnees.entity.Day;
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
@ContextConfiguration(classes = AppConfigBusiness.class)
@SpringBootTest
public class DayBOTest {

	@Autowired
	private DayBusiness object;

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
	public void testGetById() {
		List<Day> listeDays = object.getAll();
		Day day = object.getById(listeDays.get(0).getId());
		Assert.assertNotNull(day);
		Assert.assertEquals(listeDays.get(0).getId(), day.getId());

		Day day2 = object.getById(listeDays.get(0).getId() + 1);
		Assert.assertNotNull(day2);
		Assert.assertNotEquals(listeDays.get(0).getId(), day2.getId());
	}

	@Test
	@Transactional
	public void testListDays() {
		List<Day> listDays = object.getAll();
		Assert.assertNotNull(listDays);
	}

	@Test
	@Transactional
	public void testInsert() {
		int numberBefore = object.getAll().size();
		object.save(ConstanteTest.getDay());
		Assert.assertEquals(++numberBefore, object.getAll().size());
	}

	@Test
	@Transactional
	public void testUpdate() {
		int numberBefore = object.getAll().size();

		// Persistant
		double valeurNumberA = Math.random();
		Day dayA = object.getAll().get(0);
		dayA.setNumber(String.valueOf(valeurNumberA));
		Day daySave = object.save(dayA);
		Assert.assertEquals(String.valueOf(valeurNumberA), object.getById(daySave.getId()).getNumber());

		// Détaché
		double valeurNumberB = Math.random();
		Day dayB = new Day();
		dayB.setId(ConstanteTest.DAY_TEST_ID_2);
		dayB.setNumber(String.valueOf(valeurNumberB));
		dayB.setTrek(ConstanteTest.getTrek());
		daySave = object.save(dayB);
		Assert.assertEquals(String.valueOf(valeurNumberB), object.getById(daySave.getId()).getNumber());
		Assert.assertEquals(numberBefore, object.getAll().size());
	}
}
