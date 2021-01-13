package org.cedam.application.randonnees.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.cedam.application.randonnees.dao.DayDao;
import org.cedam.application.randonnees.entity.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dayBusiness")
public class DayBusiness {
	
	@Autowired
	private DayDao dayDao;
	
	public List<Day> getAll() {
		List<Day> result = new ArrayList<Day>();
		dayDao.findAll().forEach(result::add);
		return result;
	}
	
	public Day getById(Long id) {
		Optional<Day> value = dayDao.findById(id);
		if (value.isPresent()) {
			return value.get();
		}
		return null;
		//return dayDao.findById(id).get();
	}
	
	public Day save(Day day) {
		return dayDao.save(day);
	}
	

	
	public boolean test() {
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


}
