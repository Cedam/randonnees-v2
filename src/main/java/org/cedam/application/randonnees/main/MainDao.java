package org.cedam.application.randonnees.main;

import org.cedam.application.randonnees.appconfig.AppConfigDao;
import org.cedam.application.randonnees.dao.DayDao;
import org.cedam.application.randonnees.dao.TrekDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDao {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfigDao.class);

		TrekDao trekDao = appContext.getBean(TrekDao.class);
		DayDao dayDao = appContext.getBean(DayDao.class);

		trekDao.findById(0L);
		dayDao.findById(0L);

		appContext.close();
	}

}
