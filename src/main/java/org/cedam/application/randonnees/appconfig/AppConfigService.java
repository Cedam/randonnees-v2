package org.cedam.application.randonnees.appconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScans(value = { @ComponentScan("org.cedam.application.randonnees"),
		@ComponentScan("org.cedam.application.randonnees.service")})
public class AppConfigService {


}
