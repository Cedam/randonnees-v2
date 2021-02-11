package org.cedam.application.randonnees.dao;

import java.util.List;

import org.cedam.application.randonnees.entity.Trek;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrekDao extends JpaRepository<Trek, Long> {
	List<Trek> findByName(String name);
}
