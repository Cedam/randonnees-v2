package org.cedam.application.randonnees.appconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource(value = "classpath:application.properties")
@Import(AppConfigEntity.class)
// @EnableJpaRepositories(basePackages = { "org.cedam.application.randonnees.dao" })
@ComponentScan(basePackages = { "org.cedam.application.randonnees" })
public class AppConfigDao {

	//Test Commit
	
	
}
