package org.cedam.application.randonnees.dao;

import java.util.List;
import java.util.Optional;

import org.cedam.application.randonnees.AppConfigDao;
import org.cedam.application.randonnees.entity.DayV2;
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
public class DayTest {
	
	
	@Autowired
	private DayV2Dao object;
	
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
		DayV2 dayResult = object.save(ConstanteTest.getDay());
		Assert.assertTrue(dayResult!=null);
		Assert.assertTrue(dayResult.getId()>0);
	}

	@Test
	@Transactional
	public void FindTest() {
	
		// Find a customer by ID
		Optional<DayV2> result = object.findById(ConstanteTest.DAY_TEST_ID_1);
		Assert.assertTrue(!result.isEmpty());	 
		Assert.assertTrue(result.isPresent());	 
		
		// Find customers by last name
		List<DayV2> result2 = object.findByNumber(ConstanteTest.DAY_TEST_NUMBER_1);
		Assert.assertTrue(!result2.isEmpty());	 
		Assert.assertTrue(result2.size()>0);		
		
	}
	
//	@Test
//	@Transactional
//	public void FindAllTest() {
//		//Insert
//		DayV2 newDay = new DayV2();
//		newDay.setNumber("number");		
//		Object obj = object.save(newDay);
//		
//		// List all customers
//		Iterable<DayV2> iterable = object.findAll();
//		iterable.forEach((c) -> Assert.assertNotNull(c));
//		
//		long count = object.count();
//		Assert.assertTrue(count>0);
//	}
//	
//	public boolean test() {
//		// Save a new customer
//		DayV2 newDay = new DayV2();
//		newDay.setNumber("number");		
//		dayV2Dao.save(newDay);
//		
//		// Find a customer by ID
//		Optional<DayV2> result = dayV2Dao.findById(1L);
//		result.ifPresent(new Consumer<DayV2>() {
//			public void accept(DayV2 customer) {
//				System.out.println(customer);
//			}
//		});
//		
//		// Find customers by last name
//		List<DayV2> customers = dayV2Dao.findByNumber("number");
//		customers.forEach(new Consumer<DayV2>() {
//			public void accept(DayV2 customer) {
//				System.out.println(customer);
//			}
//		});
//		
//		// List all customers
//		Iterable<DayV2> iterator = dayV2Dao.findAll();
//		iterator.forEach(new Consumer<DayV2>() {
//			public void accept(DayV2 customer) {
//				System.out.println(customer);
//			}
//		});
//		
//		// Count number of customer
//		long count = dayV2Dao.count();
//		System.out.println("Number of day: " + count);
//		
//		return true;
//	}

}
