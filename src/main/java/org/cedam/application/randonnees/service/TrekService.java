package org.cedam.application.randonnees.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.cedam.application.randonnees.dao.TrekDao;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.entity.Trek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("trekService")
public class TrekService {

	@Autowired
	private TrekDao trekDao;

	@Autowired
	private DayService dayService;

	public List<Trek> getAll() {
		List<Trek> result = new ArrayList<>();
		trekDao.findAll().forEach(result::add);
		return result;
	}

	public Trek getById(Long id) {
		Trek trek = null;
		Optional<Trek> value = trekDao.findById(id);
		if (value.isPresent()) {
			trek = value.get();
		}
		return trek;
	}

	public Trek save(Trek trek) {
		var trekOut = trekDao.save(trek);
		return trekOut;
	}

	public boolean addDay(Trek trek, Day day) {
		day.setTrek(trek);
<<<<<<< HEAD:src/main/java/org/cedam/application/randonnees/service/TrekService.java
		day = dayService.save(day);
		return day != null;
	}

	public void delete(long id) {
		trekDao.deleteById(id);
=======
		//TODO
		//day = dayBusiness.save(day);
		return day != null;
	}

	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
>>>>>>> bb70fb99bc4a70fd3a386636e7ffff87fd07206c:src/main/java/org/cedam/application/randonnees/business/TrekBusiness.java
	}

}
