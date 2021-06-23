package org.cedam.application.randonnees.utils;

import org.cedam.application.randonnees.dto.DayDto;
import org.cedam.application.randonnees.dto.TrekDto;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.entity.Trek;
import org.dozer.Mapper;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("utilsMapping")
public class UtilsMapping {

	@Autowired
	private DozerBeanMapperFactoryBean dozerBean;

	private <T, V> T mapObjectToObject(V source, Class<T> classDest) throws Exception {
		T destination = null;
		if (source != null) {
			destination = classDest.getDeclaredConstructor().newInstance();
			var mapper = (Mapper) dozerBean.getObject();
			mapper.map(source, destination);
		}
		return destination;
	}

	public DayDto convertDayToDayDto(Day source) throws Exception {
		var tmp = mapObjectToObject(source, DayDto.class);
		if (source != null) {
			tmp.setTrek(mapObjectToObject(source.getTrek(), TrekDto.class));
		}
		return tmp;
	}

	public TrekDto convertTrekToTrekDto(Trek source) throws Exception {
		return mapObjectToObject(source, TrekDto.class);
	}

	public Day convertDayDtoToDay(DayDto source) throws Exception {
		var tmp = mapObjectToObject(source, Day.class);
		if (source != null) {
			tmp.setTrek(mapObjectToObject(source.getTrek(), Trek.class));
		}
		return tmp;
	}

	public Trek convertTrekDtoToTrek(TrekDto source) throws Exception {
		return mapObjectToObject(source, Trek.class);
	}
}
