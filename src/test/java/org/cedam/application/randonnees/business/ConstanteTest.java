package org.cedam.application.randonnees.business;

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

	public static Day getDay() {
		Day day = new Day();
		day.setNumber(DAY_TEST_NUMBER_1);
		day.setTrek(getTrek());
		return day;
	}

	public static final Long DAY_TEST_ID_1 = 1L;
	public static final Long DAY_TEST_ID_2 = 2L;
	public static final String DAY_TEST_NUMBER_1 = "TEST_NUMBER_1";

	public static final Long TREK_TEST_ID_1 = 1L;

	public static final String TREK_TEST_NAME_1 = "TEST_NUMBER_1";
	public static final String TREK_TEST_LOCATION_1 = "TEST_NUMBER_1";

	public static final Long TREK_TEST_ID_2 = 2L;
	public static final String TREK_TEST_LOCATION_2 = "TEST_NUMBER_2";
}
