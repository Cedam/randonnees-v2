package org.cedam.application.randonnees.dao;

import org.cedam.application.randonnees.entity.DayV2;
import org.cedam.application.randonnees.entity.TrekV2;

public class ConstanteTest {

	
	public static TrekV2 getTrek()
	{
		TrekV2 trekV2 = new TrekV2();
		trekV2.setId(TREK_TEST_ID_1);
		trekV2.setName(TREK_TEST_NAME_1);
		trekV2.setLocation(TREK_TEST_LOCATION_1);
		return trekV2;
	}
	
	public static TrekV2 getTrek2()
	{
		TrekV2 trekV2 = new TrekV2();
		trekV2.setId(TREK_TEST_ID_2);
		trekV2.setName(TREK_TEST_NAME_2);
		trekV2.setLocation(TREK_TEST_LOCATION_2);
		return trekV2;
	}
	
	public static DayV2 getDay()
	{
		DayV2 day = new DayV2();
		day.setNumber(DAY_TEST_NUMBER_1);		
		day.setTrek(getTrek());
		return day;
	}
	
	public final static Long DAY_TEST_ID_1 = 1L;
	public final static String DAY_TEST_NUMBER_1 = "TEST_NUMBER_1";
	
	public final static Long TREK_TEST_ID_1 = 1L;
	public final static String TREK_TEST_NAME_1 = "TEST_NUMBER_1";
	public final static String TREK_TEST_LOCATION_1 = "TEST_NUMBER_1";
	
	public final static Long TREK_TEST_ID_2 = 2L;
	public final static String TREK_TEST_NAME_2 = "TEST_NUMBER_2";
	public final static String TREK_TEST_LOCATION_2 = "TEST_NUMBER_2";
	

}
