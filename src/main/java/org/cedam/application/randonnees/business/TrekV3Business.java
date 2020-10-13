package org.cedam.application.randonnees.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.cedam.application.randonnees.dao.TrekV2Dao;
import org.cedam.application.randonnees.entity.DayV2;
import org.cedam.application.randonnees.entity.TrekV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("trekV3Business")
public class TrekV3Business {

	@Autowired
	private TrekV2Dao trekV2Dao;

	@Autowired
	private DayV3Business dayV2Business;

	public List<TrekV2> getAll() {
		List<TrekV2> result = new ArrayList<TrekV2>();
		trekV2Dao.findAll().forEach(result::add);
		return result;
	}

	public TrekV2 getById(Long id) {
		return trekV2Dao.findById(id).get();
	}

	public TrekV2 save(TrekV2 trek) {
		return trekV2Dao.save(trek);
	}

	public boolean addDay(TrekV2 trek, DayV2 day) {
		Boolean result = true;
		day.setTrek(trek);
		day = dayV2Business.save(day);
		return result;
	}

	public boolean test() {
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
