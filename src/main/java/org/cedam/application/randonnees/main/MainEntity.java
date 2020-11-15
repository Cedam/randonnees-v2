package org.cedam.application.randonnees.main;


import org.cedam.application.randonnees.appconfig.AppConfigEntity;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.entity.Trek;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainEntity {
	
	private static AnnotationConfigApplicationContext appContext;

	public static void main(String[] args) {
		appContext = new AnnotationConfigApplicationContext(AppConfigEntity.class);
		Day day = (Day) appContext.getBean(Day.class);
		day.getId();
		
		Trek trek = (Trek) appContext.getBean(Trek.class);
		trek.getId();
	}
	
	public static void PourTest(String[] args) {
		String a = "a";
		System.out.println(a);		
	}
}
