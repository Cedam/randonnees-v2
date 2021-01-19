package org.cedam.application.randonnees.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.cedam.application.randonnees.dao.DayDao;
import org.cedam.application.randonnees.entity.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dayBusiness")
public class DayBusiness {

	@Autowired
	private DayDao dayDao;

	public List<Day> getAll() {
		List<Day> result = new ArrayList<>();
		dayDao.findAll().forEach(result::add);
		return result;
	}

	public Day getById(Long id) {
		Optional<Day> value = dayDao.findById(id);
		if (value.isPresent()) {
			return value.get();
		}
		return null;
	}

	public Day save(Day day) {
		return dayDao.save(day);
	}

}
