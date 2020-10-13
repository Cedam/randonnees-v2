package org.cedam.application.randonnees.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.cedam.application.randonnees.AppConfigDao;
import org.cedam.application.randonnees.entity.DayV2;
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
@ContextConfiguration(classes = AppConfigDao.class)
@SpringBootTest
//@Ignore
public class TrekTest {

	@Autowired
	private TrekV2Dao object;
	
	@Autowired
	private DayV2Dao dayDao;
	
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
		TrekV2 trekV2 = ConstanteTest.getTrek2();
		TrekV2 trekResult = object.save(trekV2);
		Assert.assertTrue(trekResult!=null);
		Assert.assertTrue(trekResult.getId()>0);	
		
		DayV2 day = dayDao.findAll().iterator().next();
		
		List<DayV2> listDays = new ArrayList<DayV2>();
		listDays.add(day);
		trekV2.setDays(listDays);
		trekResult = object.save(trekV2);
		Assert.assertTrue(trekResult!=null);
		Assert.assertTrue(trekResult.getId()>0);
	}

	@Test
	@Transactional
	public void FindTest() {
		//Insert
		object.save(ConstanteTest.getTrek());
		
		// Find a customer by ID
		Optional<TrekV2> result = object.findById(ConstanteTest.TREK_TEST_ID_1);
		Assert.assertTrue(!result.isEmpty());	 
		Assert.assertTrue(result.isPresent());	 
		
		// Find customers by name
		List<TrekV2> result2 = object.findByName(ConstanteTest.TREK_TEST_NAME_1);
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
