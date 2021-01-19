package org.cedam.application.randonnees.main;

import org.cedam.application.randonnees.appconfig.AppConfigEntity;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.entity.Trek;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainEntity {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfigEntity.class);
		Day day = appContext.getBean(Day.class);
		day.getId();

		Trek trek = appContext.getBean(Trek.class);
		trek.getId();
		
		appContext.close();
	}

}
