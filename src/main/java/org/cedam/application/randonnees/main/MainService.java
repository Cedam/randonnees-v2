package org.cedam.application.randonnees.main;

import org.cedam.application.randonnees.appconfig.AppConfigService;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.entity.Trek;
import org.cedam.application.randonnees.service.DayService;
import org.cedam.application.randonnees.service.TrekService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainService {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfigService.class);
		
		TrekService trekService = appContext.getBean(TrekService.class);
		DayService dayService = appContext.getBean(DayService.class);
		
		Trek trek = trekService.getAll().iterator().next();
		Day day = dayService.getById(2L);
		day.setNumber("99");
		dayService.save(day);
		trekService.addDay(trek, day);
		
		appContext.close();
	}

}
