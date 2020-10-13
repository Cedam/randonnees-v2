package org.cedam.application.randonnees;

import org.cedam.application.randonnees.business.DayV3Business;
import org.cedam.application.randonnees.business.TrekV3Business;
import org.cedam.application.randonnees.entity.DayV2;
import org.cedam.application.randonnees.entity.TrekV2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainBusiness {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfigBusiness.class);

		TrekV3Business trekBusiness = (TrekV3Business) appContext.getBean("trekV3Business");
		DayV3Business dayBusiness = (DayV3Business) appContext.getBean("dayV3Business");
		
		TrekV2 trek = trekBusiness.getAll().iterator().next();
		DayV2 day = dayBusiness.getById(1L);
		
		trekBusiness.addDay(trek, day);
		
		appContext.close();
	}

}
