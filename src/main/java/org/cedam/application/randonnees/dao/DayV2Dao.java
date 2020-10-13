package org.cedam.application.randonnees.dao;

import java.util.List;

import org.cedam.application.randonnees.entity.DayV2;
import org.springframework.data.repository.CrudRepository;

public interface DayV2Dao extends CrudRepository<DayV2, Long> {
	List<DayV2> findByNumber(String number);
}
