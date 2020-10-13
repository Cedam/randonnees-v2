package org.cedam.application.randonnees;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.cedam.application.randonnees.dao.DayV2Dao;
import org.cedam.application.randonnees.dao.TrekV2Dao;
import org.cedam.application.randonnees.entity.DayV2;
import org.cedam.application.randonnees.entity.TrekV2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDao {

	public static void main(String[] args) {
		//AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfigDao.class);

		TrekV2Dao trekV2Dao = (TrekV2Dao) appContext.getBean("trekV2Dao");
		DayV2Dao dayV2Dao = (DayV2Dao) appContext.getBean("dayV2Dao");
		
		dayTest(dayV2Dao);
		TrekTest(trekV2Dao);
		
		appContext.close();
	}

	
	public static boolean dayTest(DayV2Dao dayV2Dao) {
		// Save a new customer
		DayV2 newDay = new DayV2();
		newDay.setNumber("number");		
		dayV2Dao.save(newDay);
		
		// Find a customer by ID
		Optional<DayV2> result = dayV2Dao.findById(1L);
		result.ifPresent(new Consumer<DayV2>() {
			public void accept(DayV2 customer) {
				System.out.println(customer);
			}
		});
		
		// Find customers by last name
		List<DayV2> customers = dayV2Dao.findByNumber("number");
		customers.forEach(new Consumer<DayV2>() {
			public void accept(DayV2 customer) {
				System.out.println(customer);
			}
		});
		
		// List all customers
		Iterable<DayV2> iterator = dayV2Dao.findAll();
		iterator.forEach(new Consumer<DayV2>() {
			public void accept(DayV2 customer) {
				System.out.println(customer);
			}
		});
		
		// Count number of customer
		long count = dayV2Dao.count();
		System.out.println("Number of day: " + count);
		
		return true;
	}
	
	
	public static boolean TrekTest(TrekV2Dao trekV2Dao) {
		// Save a new customer

		TrekV2 newTrek = new TrekV2();
		newTrek.setLocation("location");
		newTrek.setName("Smith");		
		trekV2Dao.save(newTrek);
		
		
		
		// Find a customer by ID
		Optional<TrekV2> result = trekV2Dao.findById(1L);
		result.ifPresent(new Consumer<TrekV2>() {
			public void accept(TrekV2 customer) {
				System.out.println(customer);
			}
		});
		
		// Find customers by last name
		List<TrekV2> customers = trekV2Dao.findByName("Smith");
		customers.forEach(new Consumer<TrekV2>() {
			public void accept(TrekV2 customer) {
				System.out.println(customer);
			}
		});
		
		// List all customers
		Iterable<TrekV2> iterator = trekV2Dao.findAll();
		iterator.forEach(new Consumer<TrekV2>() {
			public void accept(TrekV2 customer) {
				System.out.println(customer);
			}
		});
		
		// Count number of customer
		long count = trekV2Dao.count();
		System.out.println("Number of trek: " + count);
		
		return true;
	}
	
	
}
