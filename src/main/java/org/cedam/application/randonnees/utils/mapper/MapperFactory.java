package org.cedam.application.randonnees.utils.mapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	private static final Logger logger = LogManager.getLogger(MapperFactory.class);

	@Autowired
	private DozerBeanMapperFactoryBean dozerBean;

	public DayDto convertDayToDayDto(Day source) throws Exception {
		var destination = new DayDto();
		try {
			var mapper = (Mapper) dozerBean.getObject();
			destination = new DayDto();
			mapper.map(source, destination);
		} catch (Exception e) {
			logger.error("MapperFactory.convertDayToDayDto", e);
			throw e;
		}
		return destination;
	}

	public Day convertDayDtoToDay(DayDto source) throws Exception {
		var destination = new Day();
		try {
			var mapper = (Mapper) dozerBean.getObject();
			mapper.map(source, destination);
		} catch (Exception e) {
			logger.error("MapperFactory.convertDayDtoToDay", e);
			throw e;
		}
		return destination;
	}

	public TrekDto convertTrekToTrekDto(Trek source) throws Exception {
		var destination = new TrekDto();
		try {
			var mapper = (Mapper) dozerBean.getObject();
			mapper.map(source, destination);
		} catch (Exception e) {
			logger.error("MapperFactory.convertTrekToTrekDto", e);
			throw e;
		}
		return destination;
	}

	public Trek convertTrekDtoToTrek(TrekDto source) throws Exception {
		var destination = new Trek();
		try {
			var mapper = (Mapper) dozerBean.getObject();
			mapper.map(source, destination);
		} catch (Exception e) {
			logger.error("MapperFactory.convertTrekDtoToTrek", e);
			throw e;
		}
		return destination;
	}
}
