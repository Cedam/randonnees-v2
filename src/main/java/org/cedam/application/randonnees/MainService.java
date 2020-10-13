package org.cedam.application.randonnees;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication()
public class MainService extends SpringBootServletInitializer  {

	public static void main(String[] args) {
	    SpringApplication.run(AppConfigService.class, args);
	}

}
