package org.cedam.application.randonnees.dao;

import java.util.List;

import org.cedam.application.randonnees.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DayDao extends JpaRepository<Day, Long> {
	
	public static final String RQT_FIND_BY_TREK_ID = "SELECT ID, NUMBER, TREK_ID FROM Day p WHERE p.TREK_ID = :trekId";
	
	List<Day> findByNumber(String number);

	List<Day> findListByTrekId(Long id);
	
	@Query(value = RQT_FIND_BY_TREK_ID, nativeQuery=true)
	List<Day> findListByTrekIdSql(@Param("trekId") Long id);


}
