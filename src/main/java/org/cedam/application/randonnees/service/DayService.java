package org.cedam.application.randonnees.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.cedam.application.randonnees.dao.DayDao;
import org.cedam.application.randonnees.entity.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dayService")
public class DayService {

	
	@Autowired
	private DayDao dayDao;

	public List<Day> getAll() {
		List<Day> result = new ArrayList<>();
		dayDao.findAll().forEach(result::add);
		return result;
	}

	public Day getById(Long id) {
		Day day = null;
		Optional<Day> value = dayDao.findById(id);
		if (value.isPresent()) {
			day= value.get();
		}
		return day;
	}

	public Day save(Day day) {
		//dayDao.
		return dayDao.save(day);
	}

<<<<<<< HEAD:src/main/java/org/cedam/application/randonnees/service/DayService.java
	public void delete(long id) {
		dayDao.deleteById(id);
=======
	public boolean delete(long id) {
		// TODO
		return false;
>>>>>>> bb70fb99bc4a70fd3a386636e7ffff87fd07206c:src/main/java/org/cedam/application/randonnees/business/DayBusiness.java
	}

}
