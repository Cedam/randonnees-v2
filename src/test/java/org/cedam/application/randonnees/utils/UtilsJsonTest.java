package org.cedam.application.randonnees.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.cedam.application.randonnees.appconfig.AppConfigController;
import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.entity.Trek;
import org.cedam.application.randonnees.test.mock.Constante;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = AppConfigController.class)
@SpringBootTest
public class UtilsJsonTest {

	private final String DAY_JSON ="{\"id\":0,\"number\":\"TEST_NUMBER_1\",\"trek\":{\"id\":1,\"name\":\"TEST_NAME_1\",\"year\":0,\"location\":\"TEST_NUMBER_1\",\"days\":[]}}";
	private final String TREK_JSON ="{\"id\":1,\"name\":\"TEST_NAME_1\",\"year\":0,\"location\":\"TEST_NUMBER_1\",\"days\":[]}";
	
	
	@Autowired
	private UtilsJson object;

	@Test
	public void testSerialize() throws Exception {
		
		Day source = Constante.getDay();
		String strJson = object.serialize(source);
		assertNotNull(strJson);
		assertThat(DAY_JSON).isEqualTo(strJson);
		
		Trek source2 = Constante.getTrek();
		String strJson2 = object.serialize(source2);
		assertNotNull(strJson2);
		assertThat(TREK_JSON).isEqualTo(strJson2);
	}

	@Test
	public void testDeserialize() throws Exception {
		Day day = object.deserialize(DAY_JSON, Day.class);
		assertNotNull(day);
		assertThat(Constante.DAY_TEST_NUMBER_1).isEqualTo(day.getNumber());
		
		Trek trek = object.deserialize(TREK_JSON, Trek.class);
		assertNotNull(trek);
		assertThat(Constante.TREK_TEST_NAME_1).isEqualTo(trek.getName());
	}


}
