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
		Mapper mapper = (Mapper) dozerBean.getObject();
		DayDto destination = new DayDto();
		mapper.map(source, destination);
		return destination;
	}

	public Day convertDayDtoToDay(DayDto source) throws Exception {
		Mapper mapper = (Mapper) dozerBean.getObject();
		Day destination = new Day();
		mapper.map(source, destination);
		return destination;
	}

	public TrekDto convertTrekToTrekDto(Trek source) throws Exception {
		Mapper mapper = (Mapper) dozerBean.getObject();
		TrekDto destination = new TrekDto();
		mapper.map(source, destination);
		return destination;
	}

	public Trek convertTrekDtoToTrek(TrekDto source) throws Exception {
		Mapper mapper = (Mapper) dozerBean.getObject();
		Trek destination = new Trek();
		mapper.map(source, destination);
		return destination;
	}
}
