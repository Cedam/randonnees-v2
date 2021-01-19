package org.cedam.application.randonnees.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	}

	public Trek save(Trek trek) {
		return trekDao.save(trek);
	}

	public boolean addDay(Trek trek, Day day) {
		day.setTrek(trek);
		day = dayBusiness.save(day);
		return day!=null;
	}

}
