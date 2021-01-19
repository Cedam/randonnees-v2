package org.cedam.application.randonnees.dao;

import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.entity.Trek;

public class ConstanteTest {

	public static Trek getTrek() {
		Trek trek = new Trek();
		trek.setId(TREK_TEST_ID_1);
		trek.setName(TREK_TEST_NAME_1);
		trek.setLocation(TREK_TEST_LOCATION_1);
		return trek;
	}

	public static Trek getTrek2() {
		Trek trek = new Trek();
		trek.setId(TREK_TEST_ID_2);
		trek.setName(TREK_TEST_NAME_2);
		trek.setLocation(TREK_TEST_LOCATION_2);
		return trek;
	}

	public static Day getDay() {
		Day day = new Day();
		day.setNumber(DAY_TEST_NUMBER_1);
		day.setTrek(getTrek());
		return day;
	}

	public final static Long DAY_TEST_ID_1 = 1L;
	public final static String DAY_TEST_NUMBER_1 = "TEST_NUMBER_1";

	public final static Long TREK_TEST_ID_1 = 1L;
	public final static String TREK_TEST_NAME_1 = "TEST_NAME_1";
	public final static String TREK_TEST_LOCATION_1 = "TEST_NUMBER_1";

	public final static Long TREK_TEST_ID_2 = 2L;
	public final static String TREK_TEST_NAME_2 = "TEST_NUMBER_2";
	public final static String TREK_TEST_LOCATION_2 = "TEST_NUMBER_2";

}
