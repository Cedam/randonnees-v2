package org.cedam.application.randonnees.business;

import java.util.List;

import org.cedam.application.randonnees.AppConfigBusiness;
import org.cedam.application.randonnees.entity.TrekV2;
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
public class TrekV3BOTest {

	@Autowired
	private TrekV3Business object;

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
		List<TrekV2> listeTreks = object.getAll();
		TrekV2 day = object.getById(listeTreks.get(0).getId());
		Assert.assertNotNull(day);
		Assert.assertEquals(listeTreks.get(0).getId(), day.getId());

		TrekV2 day2 = object.getById(listeTreks.get(0).getId() + 1);
		Assert.assertNotNull(day2);
		Assert.assertNotEquals(listeTreks.get(0).getId(), day2.getId());
	}

	@Test
	@Transactional
	public void testListTreks() {
		List<TrekV2> listTreks = object.getAll();
		Assert.assertNotNull(listTreks);
	}

	@Test
	@Transactional
	public void testInsert() {
		int numberBefore = object.getAll().size();
		TrekV2 trekA = new TrekV2();
		trekA.setName(ConstanteTest.TREK_TEST_NAME_1);
		trekA.setLocation(ConstanteTest.TREK_TEST_LOCATION_1);
		object.save(trekA);
		Assert.assertEquals(++numberBefore, object.getAll().size());
	}

	@Test
	@Transactional
	public void testUpdate() {
		int numberBefore = object.getAll().size();

		// Persistant
		double valeurNumberA = Math.random();
		TrekV2 trekA = object.getAll().get(0);
		trekA.setName(String.valueOf(valeurNumberA));
		TrekV2 trekSave = object.save(trekA);
		Assert.assertEquals(String.valueOf(valeurNumberA), object.getById(trekSave.getId()).getName());

		// Détaché
		double valeurNumberB = Math.random();
		TrekV2 trekB = new TrekV2();
		trekB.setId(ConstanteTest.TREK_TEST_ID_2);
		trekB.setName(String.valueOf(valeurNumberB));
		trekB.setLocation(ConstanteTest.TREK_TEST_LOCATION_2);
		trekSave = object.save(trekB);
		Assert.assertEquals(String.valueOf(valeurNumberB), object.getById(trekSave.getId()).getName());
		Assert.assertEquals(numberBefore, object.getAll().size());
	}

}
