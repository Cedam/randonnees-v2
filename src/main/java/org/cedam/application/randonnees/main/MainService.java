package org.cedam.application.randonnees.main;

import org.cedam.application.randonnees.appconfig.AppConfigService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication()
public class MainService extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AppConfigService.class, args);
	}

	public static void PourTest(String[] args) {
	
	}
	
}
