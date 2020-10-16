package org.cedam.application.randonnees.dao;

import java.util.List;

import org.cedam.application.randonnees.entity.Trek;
import org.springframework.data.repository.CrudRepository;

public interface TrekDao extends CrudRepository<Trek, Long> {
	List<Trek> findByName(String name);
}
