package org.cedam.application.randonnees.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.cedam.application.randonnees.dao.TrekDao;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.entity.Trek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("trekBusiness")
public class TrekBusiness {

	@Autowired
	private TrekDao trekDao;

	@Autowired
	private DayBusiness dayBusiness;

	public List<Trek> getAll() {
		List<Trek> result = new ArrayList<>();
		trekDao.findAll().forEach(result::add);
		return result;
	}

	public Trek getById(Long id) {
		Optional<Trek> value = trekDao.findById(id);
		if (value.isPresent()) {
			return value.get();
		}
		return null;
//		return trekDao.findById(id).get();
	}

	public Trek save(Trek trek) {
		return trekDao.save(trek);
	}

	public boolean addDay(Trek trek, Day day) {
		Boolean result = true;
		day.setTrek(trek);
		day = dayBusiness.save(day);
		return result;
	}

	public boolean test() {
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
