package org.cedam.application.randonnees.main;

import org.cedam.application.randonnees.appconfig.AppConfigDao;
import org.cedam.application.randonnees.controller.DayController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainController {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfigDao.class);
		DayController dayController = appContext.getBean(DayController.class);
		dayController.test();
		
		appContext.close();
	}
	
}
