package org.cedam.application.randonnees.business;

import java.util.List;

import org.cedam.application.randonnees.appconfig.AppConfigBusiness;
import org.cedam.application.randonnees.entity.Trek;
import org.cedam.application.randonnees.test.mock.Constante;
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
public class TrekBOTest {

	@Autowired
	private TrekBusiness object;

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
		List<Trek> listeTreks = object.getAll();
		Trek day = object.getById(listeTreks.get(0).getId());
		Assert.assertNotNull(day);
		Assert.assertEquals(listeTreks.get(0).getId(), day.getId());

		Trek day2 = object.getById(listeTreks.get(0).getId() + 1);
		Assert.assertNotNull(day2);
		Assert.assertNotEquals(listeTreks.get(0).getId(), day2.getId());
	}

	@Test
	@Transactional
	public void testListTreks() {
		List<Trek> listTreks = object.getAll();
		Assert.assertNotNull(listTreks);
	}

	@Test
	@Transactional
	public void testInsert() {
		int numberBefore = object.getAll().size();
		Trek trekA = new Trek();
		trekA.setName(Constante.TREK_TEST_NAME_1);
		trekA.setLocation(Constante.TREK_TEST_LOCATION_1);
		object.save(trekA);
		Assert.assertEquals(++numberBefore, object.getAll().size());
	}

	@Test
	@Transactional
	public void testUpdate() {
		int numberBefore = object.getAll().size();

		// Persistant
		double valeurNumberA = Math.random();
		Trek trekA = object.getAll().get(0);
		trekA.setName(String.valueOf(valeurNumberA));
		Trek trekSave = object.save(trekA);
		Assert.assertEquals(String.valueOf(valeurNumberA), object.getById(trekSave.getId()).getName());

		// Détaché
		double valeurNumberB = Math.random();
		Trek trekB = new Trek();
		trekB.setId(Constante.TREK_TEST_ID_2);
		trekB.setName(String.valueOf(valeurNumberB));
		trekB.setLocation(Constante.TREK_TEST_LOCATION_2);
		trekSave = object.save(trekB);
		Assert.assertEquals(String.valueOf(valeurNumberB), object.getById(trekSave.getId()).getName());
		Assert.assertEquals(numberBefore, object.getAll().size());
	}

}
