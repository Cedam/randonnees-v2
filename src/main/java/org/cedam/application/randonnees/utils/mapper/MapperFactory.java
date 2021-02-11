package org.cedam.application.randonnees.utils.mapper;

import org.cedam.application.randonnees.dto.DayDto;
import org.cedam.application.randonnees.dto.TrekDto;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.entity.Trek;
import org.dozer.Mapper;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mapperFactory")
public class MapperFactory {

	@Autowired
	private DozerBeanMapperFactoryBean dozerBean;

	public DayDto convertDayToDayDto(Day source) throws Exception {
		DayDto destination = null;
		if (source != null) {
			destination = new DayDto();
			var mapper = (Mapper) dozerBean.getObject();
			destination = new DayDto();
			mapper.map(source, destination);
		}
		return destination;
	}

	public Day convertDayDtoToDay(DayDto source) throws Exception {
		Day destination = null;
		if (source != null) {
			destination = new Day();
			var mapper = (Mapper) dozerBean.getObject();
			mapper.map(source, destination);
		}
		return destination;
	}

	public TrekDto convertTrekToTrekDto(Trek source) throws Exception {
		TrekDto destination = null;
		if (source != null) {
			destination = new TrekDto();
			var mapper = (Mapper) dozerBean.getObject();
			mapper.map(source, destination);
		}
		return destination;
	}

	public Trek convertTrekDtoToTrek(TrekDto source) throws Exception {
		Trek destination = null;
		if (source != null) {
			destination = new Trek();
			var mapper = (Mapper) dozerBean.getObject();
			mapper.map(source, destination);
		}
		return destination;
	}
}
