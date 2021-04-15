package org.cedam.application.randonnees;

import org.cedam.application.randonnees.appconfig.AppConfigController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;


@SpringBootApplication()
@Import(AppConfigController.class)
public class SpringApp extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringApp.class);
	}
	
}
