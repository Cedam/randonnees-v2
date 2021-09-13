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

	public Trek getByName(String name) {
		Trek trek = null;
		List<Trek> treks = trekDao.findByName(name);
		Optional<Trek> trekOpt = treks.stream().findFirst();
		if (trekOpt.isPresent()) {
			trek = trekOpt.get();
		}
		return trek;
	}

	public Trek save(Trek trek) {
		return trekDao.save(trek);
	}

	public void addDay(Trek trek, Day day) {
		if(day!=null)
		{
			day.setTrek(trek);
			dayService.save(day);
		}
	}

	public void delete(long id) {
		trekDao.deleteById(id);
	}


}
