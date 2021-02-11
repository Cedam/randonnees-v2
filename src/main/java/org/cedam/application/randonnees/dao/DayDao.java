package org.cedam.application.randonnees.dao;

import java.util.List;

import org.cedam.application.randonnees.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayDao extends JpaRepository<Day, Long> {
	List<Day> findByNumber(String number);
}
