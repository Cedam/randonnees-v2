package org.cedam.application.randonnees.main;

import org.cedam.application.randonnees.appconfig.AppConfigBusiness;
import org.cedam.application.randonnees.business.DayBusiness;
import org.cedam.application.randonnees.business.TrekBusiness;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.entity.Trek;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainBusiness {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfigBusiness.class);

		TrekBusiness trekBusiness = (TrekBusiness) appContext.getBean("trekBusiness");
		DayBusiness dayBusiness = (DayBusiness) appContext.getBean("dayBusiness");
		
		Trek trek = trekBusiness.getAll().iterator().next();
		Day day = dayBusiness.getById(1L);
		
		trekBusiness.addDay(trek, day);
		
		appContext.close();
	}

}
