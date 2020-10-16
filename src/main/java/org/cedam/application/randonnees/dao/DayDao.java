package org.cedam.application.randonnees.dao;

import java.util.List;

import org.cedam.application.randonnees.entity.Day;
import org.springframework.data.repository.CrudRepository;

public interface DayDao extends CrudRepository<Day, Long> {
	List<Day> findByNumber(String number);
}
