package org.cedam.application.randonnees.dao;

import java.util.List;

import org.cedam.application.randonnees.entity.TrekV2;
import org.springframework.data.repository.CrudRepository;

public interface TrekV2Dao extends CrudRepository<TrekV2, Long> {
	List<TrekV2> findByName(String name);
}
