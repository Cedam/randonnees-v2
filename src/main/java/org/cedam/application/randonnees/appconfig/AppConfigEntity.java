package org.cedam.application.randonnees.appconfig;

import org.cedam.application.randonnees.entity.Day;
import org.cedam.application.randonnees.entity.Trek;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScans(value = { @ComponentScan("org.cedam.application.randonnees.entity") })
public class AppConfigEntity {

	@Bean(name = "day")
	public Day getDay() {
		return new Day();
	}

	@Bean(name = "trek")
	public Trek getTtek() {
		return new Trek();
	}

}
