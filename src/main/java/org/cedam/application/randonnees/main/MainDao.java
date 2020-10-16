package org.cedam.application.randonnees.main;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.cedam.application.randonnees.appconfig.AppConfigDao;
import org.cedam.application.randonnees.dao.DayDao;
import org.cedam.application.randonnees.dao.TrekDao;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.entity.Trek;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDao {

	public static void main(String[] args) {
		//AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfigDao.class);

		TrekDao trekDao = (TrekDao) appContext.getBean("trekDao");
		DayDao dayDao = (DayDao) appContext.getBean("dayDao");
		
		dayTest(dayDao);
		TrekTest(trekDao);
		
		appContext.close();
	}

	
	public static boolean dayTest(DayDao dayDao) {
		// Save a new customer
		Day newDay = new Day();
		newDay.setNumber("number");		
		dayDao.save(newDay);
		
		// Find a customer by ID
		Optional<Day> result = dayDao.findById(1L);
		result.ifPresent(new Consumer<Day>() {
			public void accept(Day customer) {
				System.out.println(customer);
			}
		});
		
		// Find customers by last name
		List<Day> customers = dayDao.findByNumber("number");
		customers.forEach(new Consumer<Day>() {
			public void accept(Day customer) {
				System.out.println(customer);
			}
		});
		
		// List all customers
		Iterable<Day> iterator = dayDao.findAll();
		iterator.forEach(new Consumer<Day>() {
			public void accept(Day customer) {
				System.out.println(customer);
			}
		});
		
		// Count number of customer
		long count = dayDao.count();
		System.out.println("Number of day: " + count);
		
		return true;
	}
	
	
	public static boolean TrekTest(TrekDao trekDao) {
		// Save a new customer

		Trek newTrek = new Trek();
		newTrek.setLocation("location");
		newTrek.setName("Smith");		
		trekDao.save(newTrek);
		
		
		
		// Find a customer by ID
		Optional<Trek> result = trekDao.findById(1L);
		result.ifPresent(new Consumer<Trek>() {
			public void accept(Trek customer) {
				System.out.println(customer);
			}
		});
		
		// Find customers by last name
		List<Trek> customers = trekDao.findByName("Smith");
		customers.forEach(new Consumer<Trek>() {
			public void accept(Trek customer) {
				System.out.println(customer);
			}
		});
		
		// List all customers
		Iterable<Trek> iterator = trekDao.findAll();
		iterator.forEach(new Consumer<Trek>() {
			public void accept(Trek customer) {
				System.out.println(customer);
			}
		});
		
		// Count number of customer
		long count = trekDao.count();
		System.out.println("Number of trek: " + count);
		
		return true;
	}
	
	
}
