package org.cedam.application.randonnees.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.cedam.application.randonnees.appconfig.AppConfigDao;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.entity.Trek;
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
//@Ignore
public class TrekTest {

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
		Assert.assertTrue(trekResult!=null);
		Assert.assertTrue(trekResult.getId()>0);	
		
		Day day = dayDao.findAll().iterator().next();
		
		List<Day> listDays = new ArrayList<Day>();
		listDays.add(day);
		trek.setDays(listDays);
		trekResult = object.save(trek);
		Assert.assertTrue(trekResult!=null);
		Assert.assertTrue(trekResult.getId()>0);
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
		Assert.assertTrue(result2.size()>0);		
		
	}
	
	
	
//	public boolean test() {
//		// Save a new customer
//
//		TrekV2 newTrek = new TrekV2();
//		newTrek.setLocation("location");
//		newTrek.setName("Smith");		
//		trekV2Dao.save(newTrek);
//		
//		
//		
//		// Find a customer by ID
//		Optional<TrekV2> result = trekV2Dao.findById(1L);
//		result.ifPresent(new Consumer<TrekV2>() {
//			public void accept(TrekV2 customer) {
//				System.out.println(customer);
//			}
//		});
//		
//		// Find customers by last name
//		List<TrekV2> customers = trekV2Dao.findByName("Smith");
//		customers.forEach(new Consumer<TrekV2>() {
//			public void accept(TrekV2 customer) {
//				System.out.println(customer);
//			}
//		});
//		
//		// List all customers
//		Iterable<TrekV2> iterator = trekV2Dao.findAll();
//		iterator.forEach(new Consumer<TrekV2>() {
//			public void accept(TrekV2 customer) {
//				System.out.println(customer);
//			}
//		});
//		
//		// Count number of customer
//		long count = trekV2Dao.count();
//		System.out.println("Number of trek: " + count);
//		
//		return true;
//	}


}
